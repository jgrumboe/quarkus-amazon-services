package io.quarkiverse.amazon.devservices.ecr;

import io.quarkiverse.amazon.bedrockruntime.runtime.BedrockRuntimeBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.EnabledService;
import io.quarkus.deployment.annotations.BuildStep;

public class BedrockRuntimeDevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupBedrockRuntime(BedrockRuntimeBuildTimeConfig clientBuildTimeConfig) {
        return this.setup(EnabledService.named("bedrock"), clientBuildTimeConfig.devservices());
    }

    @Override
    protected String getPropertyConfigurationName(EnabledService enabledService) {
        return "bedrockruntime";
    }
}
