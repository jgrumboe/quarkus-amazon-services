package io.quarkiverse.amazon.devservices.ecr;

import io.quarkiverse.amazon.bedrockruntime.runtime.BedrockRuntimeBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public class BedrockRuntimeDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupBedrockRuntime(BedrockRuntimeBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("bedrock", clientBuildTimeConfig.devservices());
    }

    @Override
    protected String getPropertyConfigurationName(String serviceName) {
        return "bedrockruntime";
    }
}
