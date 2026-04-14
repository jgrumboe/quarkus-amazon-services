package io.quarkiverse.amazon.common.deployment.spi;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.ministack.testcontainers.MiniStackContainer;

import io.quarkiverse.amazon.common.runtime.AwsCredentialsProviderType;
import io.quarkiverse.amazon.common.runtime.DevServicesBuildTimeConfig;
import io.quarkus.runtime.configuration.ConfigUtils;

public abstract class AbstractDevServicesLocalStackProcessor {

    private static final Logger log = Logger.getLogger(AbstractDevServicesLocalStackProcessor.class);

    private static final String ENDPOINT_OVERRIDE = "quarkus.%s.endpoint-override";
    private static final String AWS_REGION = "quarkus.%s.aws.region";
    private static final String AWS_CREDENTIALS_TYPE = "quarkus.%s.aws.credentials.type";
    private static final String AWS_CREDENTIALS_STATIC_PROVIDER_ACCESS_KEY_ID = "quarkus.%s.aws.credentials.static-provider.access-key-id";
    private static final String AWS_CREDENTIALS_STATIC_PROVIDER_SECRET_ACCESS_KEY = "quarkus.%s.aws.credentials.static-provider.secret-access-key";

    // Default credentials and region for MiniStack
    private static final String DEFAULT_REGION = "us-east-1";
    private static final String DEFAULT_ACCESS_KEY = "test";
    private static final String DEFAULT_SECRET_KEY = "test";

    protected DevServicesLocalStackProviderBuildItem setup(EnabledService enabledService,
            DevServicesBuildTimeConfig devServicesBuildTimeConfig) {

        String propertyConfigurationName = getPropertyConfigurationName(enabledService);

        // explicitly disabled
        if (!devServicesBuildTimeConfig.enabled().orElse(true)) {
            log.debugf(
                    "Not starting Dev Services for Amazon Services - %s, as it has been disabled in the config.",
                    enabledService.getName());
            return null;
        }

        String endpointOverride = String.format(ENDPOINT_OVERRIDE, propertyConfigurationName);
        if (ConfigUtils.isPropertyPresent(endpointOverride)) {
            log.debugf("Not starting Dev Services for Amazon Services - %s, the %s is configured.",
                    enabledService.getName(),
                    endpointOverride);
            return null;
        }

        LocalStackDevServicesBaseConfig sharedConfig = getConfiguration(devServicesBuildTimeConfig);

        return new DevServicesLocalStackProviderBuildItem(enabledService,
                sharedConfig,
                new DevServicesAmazonProvider() {
                    @Override
                    public Map<String, String> prepareLocalStack(MiniStackContainer localstack) {
                        AbstractDevServicesLocalStackProcessor.this.prepareLocalStack(
                                devServicesBuildTimeConfig,
                                localstack);

                        var config = new HashMap<String, String>();

                        // Standard configuration - use the container's generated endpoint
                        // The hostname modification for shared network is handled in DevServicesLocalStackProcessor
                        config.put(
                                endpointOverride,
                                URI.create(localstack.getEndpoint()).toString());

                        config.put(String.format(AWS_REGION, propertyConfigurationName),
                                DEFAULT_REGION);
                        config.put(String.format(AWS_CREDENTIALS_TYPE,
                                propertyConfigurationName),
                                AwsCredentialsProviderType.STATIC.name());
                        config.put(String.format(AWS_CREDENTIALS_STATIC_PROVIDER_ACCESS_KEY_ID,
                                propertyConfigurationName),
                                DEFAULT_ACCESS_KEY);
                        config.put(String.format(AWS_CREDENTIALS_STATIC_PROVIDER_SECRET_ACCESS_KEY,
                                propertyConfigurationName),
                                DEFAULT_SECRET_KEY);

                        overrideDefaultConfig(config);

                        return config;
                    }

                    @Override
                    public Map<String, String> reuseLocalStack(
                            BorrowedLocalStackContainer localstack) {
                        return Map.of(
                                endpointOverride,
                                localstack.getEndpointOverride(enabledService)
                                        .toString(),
                                String.format(AWS_REGION, propertyConfigurationName),
                                localstack.getRegion(),
                                String.format(AWS_CREDENTIALS_TYPE,
                                        propertyConfigurationName),
                                AwsCredentialsProviderType.STATIC.name(),
                                String.format(AWS_CREDENTIALS_STATIC_PROVIDER_ACCESS_KEY_ID,
                                        propertyConfigurationName),
                                localstack.getAccessKey(),
                                String.format(AWS_CREDENTIALS_STATIC_PROVIDER_SECRET_ACCESS_KEY,
                                        propertyConfigurationName),
                                localstack.getSecretKey());
                    }
                });
    }

    protected void overrideDefaultConfig(Map<String, String> defaultConfig) {
    }

    /**
     * Returns an equatable configuration
     *
     * @param devServicesBuildTimeConfig build time configuration
     * @return
     */
    protected LocalStackDevServicesBaseConfig getConfiguration(
            DevServicesBuildTimeConfig devServicesBuildTimeConfig) {
        return new LocalStackDevServicesBaseConfig(
                devServicesBuildTimeConfig.shared(),
                devServicesBuildTimeConfig.isolated(),
                devServicesBuildTimeConfig.serviceName(),
                devServicesBuildTimeConfig.containerProperties());
    }

    /**
     * Prepare the owned localStack container
     *
     * @param devServicesBuildTimeConfig build time configuration to apply to container
     * @param localstack the new localStack container to prepare
     */
    protected void prepareLocalStack(DevServicesBuildTimeConfig devServicesBuildTimeConfig,
            MiniStackContainer localstack) {
    }

    /**
     * Returns the property configuration name for the given {@link EnabledService}.
     * <p>
     * The property configuration name is the name of the service, which is the same as the AWSSDK artifact id.
     * The only exception is the Step Functions service, which is named "sfn" in the AWSSDK, "stepfunctions"
     * and "logs" in the configuration.
     * <p>
     *
     * @param enabledService the enabled service
     * @return the property configuration name
     */
    protected String getPropertyConfigurationName(EnabledService enabledService) {
        if (enabledService == Service.STEPFUNCTIONS)
            return "sfn";
        if (enabledService.getName().equals("events"))
            return "eventbridge";
        if (enabledService == Service.CLOUDWATCHLOGS)
            return "cloudwatchlogs";
        if (enabledService.getName().equals("scheduler"))
            return "eventbridge-scheduler";
        return enabledService.getName();
    }
}
