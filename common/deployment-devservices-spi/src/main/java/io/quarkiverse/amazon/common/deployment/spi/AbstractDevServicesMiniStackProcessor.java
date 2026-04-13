package io.quarkiverse.amazon.common.deployment.spi;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.ministack.testcontainers.MiniStackContainer;

import io.quarkiverse.amazon.common.runtime.AwsCredentialsProviderType;
import io.quarkiverse.amazon.common.runtime.DevServicesBuildTimeConfig;
import io.quarkus.runtime.configuration.ConfigUtils;

public abstract class AbstractDevServicesMiniStackProcessor {

    private static final Logger log = Logger.getLogger(AbstractDevServicesMiniStackProcessor.class);

    private static final String ENDPOINT_OVERRIDE = "quarkus.%s.endpoint-override";
    private static final String AWS_REGION = "quarkus.%s.aws.region";
    private static final String AWS_CREDENTIALS_TYPE = "quarkus.%s.aws.credentials.type";
    private static final String AWS_CREDENTIALS_STATIC_PROVIDER_ACCESS_KEY_ID = "quarkus.%s.aws.credentials.static-provider.access-key-id";
    private static final String AWS_CREDENTIALS_STATIC_PROVIDER_SECRET_ACCESS_KEY = "quarkus.%s.aws.credentials.static-provider.secret-access-key";

    private static final String DEFAULT_REGION = "us-east-1";
    private static final String DEFAULT_ACCESS_KEY = "test";
    private static final String DEFAULT_SECRET_KEY = "test";

    protected DevServicesMiniStackProviderBuildItem setup(String serviceName,
            DevServicesBuildTimeConfig devServicesBuildTimeConfig) {

        String propertyConfigurationName = getPropertyConfigurationName(serviceName);

        // explicitly disabled
        if (!devServicesBuildTimeConfig.enabled().orElse(true)) {
            log.debugf(
                    "Not starting Dev Services for Amazon Services - %s, as it has been disabled in the config.",
                    serviceName);
            return null;
        }

        String endpointOverride = String.format(ENDPOINT_OVERRIDE, propertyConfigurationName);
        if (ConfigUtils.isPropertyPresent(endpointOverride)) {
            log.debugf("Not starting Dev Services for Amazon Services - %s, the %s is configured.",
                    serviceName,
                    endpointOverride);
            return null;
        }

        MiniStackDevServicesBaseConfig sharedConfig = getConfiguration(devServicesBuildTimeConfig);

        return new DevServicesMiniStackProviderBuildItem(serviceName,
                sharedConfig,
                new DevServicesAmazonProvider() {
                    @Override
                    public Map<String, String> prepareMiniStack(MiniStackContainer ministack) {
                        AbstractDevServicesMiniStackProcessor.this.prepareMiniStack(
                                devServicesBuildTimeConfig,
                                ministack);

                        var config = new HashMap<String, String>();

                        // Standard configuration - use the container's generated endpoint
                        // The hostname modification for shared network is handled in DevServicesMiniStackProcessor
                        config.put(
                                endpointOverride,
                                ministack.getEndpoint());

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
                    public Map<String, String> reuseMiniStack(
                            BorrowedMiniStackContainer ministack) {
                        return Map.of(
                                endpointOverride,
                                ministack.getEndpointOverride()
                                        .toString(),
                                String.format(AWS_REGION, propertyConfigurationName),
                                ministack.getRegion(),
                                String.format(AWS_CREDENTIALS_TYPE,
                                        propertyConfigurationName),
                                AwsCredentialsProviderType.STATIC.name(),
                                String.format(AWS_CREDENTIALS_STATIC_PROVIDER_ACCESS_KEY_ID,
                                        propertyConfigurationName),
                                ministack.getAccessKey(),
                                String.format(AWS_CREDENTIALS_STATIC_PROVIDER_SECRET_ACCESS_KEY,
                                        propertyConfigurationName),
                                ministack.getSecretKey());
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
    protected MiniStackDevServicesBaseConfig getConfiguration(
            DevServicesBuildTimeConfig devServicesBuildTimeConfig) {
        return new MiniStackDevServicesBaseConfig(
                devServicesBuildTimeConfig.shared(),
                devServicesBuildTimeConfig.isolated(),
                devServicesBuildTimeConfig.serviceName(),
                devServicesBuildTimeConfig.containerProperties());
    }

    /**
     * Prepare the owned MiniStack container
     *
     * @param devServicesBuildTimeConfig build time configuration to apply to container
     * @param ministack the new MiniStack container to prepare
     */
    protected void prepareMiniStack(DevServicesBuildTimeConfig devServicesBuildTimeConfig,
            MiniStackContainer ministack) {
    }

    /**
     * Returns the property configuration name for the given service name.
     * <p>
     * The property configuration name is the name of the service, which is the same as the AWSSDK artifact id.
     * The only exception is the Step Functions service, which is named "sfn" in the AWSSDK, "stepfunctions"
     * in the MiniStack configuration, and "events" for EventBridge.
     * <p>
     *
     * @param serviceName the service name
     * @return the property configuration name
     */
    protected String getPropertyConfigurationName(String serviceName) {
        if (serviceName.equals("stepfunctions"))
            return "sfn";
        if (serviceName.equals("events"))
            return "eventbridge";
        if (serviceName.equals("logs"))
            return "cloudwatchlogs";
        if (serviceName.equals("scheduler"))
            return "eventbridge-scheduler";
        return serviceName;
    }
}
