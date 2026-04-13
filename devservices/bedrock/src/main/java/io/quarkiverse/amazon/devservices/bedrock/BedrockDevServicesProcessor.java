package io.quarkiverse.amazon.devservices.bedrock;

import io.quarkiverse.amazon.bedrock.runtime.BedrockBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public class BedrockDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupBedrock(BedrockBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("bedrock", clientBuildTimeConfig.devservices());
    }
}
