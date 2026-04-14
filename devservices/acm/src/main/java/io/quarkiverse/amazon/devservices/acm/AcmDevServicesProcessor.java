package io.quarkiverse.amazon.devservices.acm;

import io.quarkiverse.amazon.acm.runtime.AcmBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.EnabledService;
import io.quarkus.deployment.annotations.BuildStep;

public class AcmDevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupSsm(AcmBuildTimeConfig clientBuildTimeConfig) {
        return this.setup(EnabledService.named("acm"), clientBuildTimeConfig.devservices());
    }
}
