package io.quarkiverse.amazon.devservices.ecr;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.EnabledService;
import io.quarkiverse.amazon.ecr.runtime.EcrBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class EcrDevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupEcr(EcrBuildTimeConfig clientBuildTimeConfig) {
        return this.setup(EnabledService.named("ecr"), clientBuildTimeConfig.devservices());
    }
}
