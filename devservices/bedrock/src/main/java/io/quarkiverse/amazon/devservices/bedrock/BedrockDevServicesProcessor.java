package io.quarkiverse.amazon.devservices.bedrock;

import io.quarkiverse.amazon.bedrock.runtime.BedrockBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.EnabledService;
import io.quarkus.deployment.annotations.BuildStep;

public class BedrockDevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupBedrock(BedrockBuildTimeConfig clientBuildTimeConfig) {
        return this.setup(EnabledService.named("bedrock"), clientBuildTimeConfig.devservices());
    }
}
