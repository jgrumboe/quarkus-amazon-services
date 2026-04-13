package io.quarkiverse.amazon.devservices.acm;

import io.quarkiverse.amazon.acm.runtime.AcmBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public class AcmDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSsm(AcmBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("acm", clientBuildTimeConfig.devservices());
    }
}
