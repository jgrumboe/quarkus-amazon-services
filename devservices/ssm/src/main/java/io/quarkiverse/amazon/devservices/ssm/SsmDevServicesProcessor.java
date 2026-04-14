package io.quarkiverse.amazon.devservices.ssm;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.Service;
import io.quarkiverse.amazon.ssm.runtime.SsmBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SsmDevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupSsm(SsmBuildTimeConfig clientBuildTimeConfig) {
        return this.setup(Service.SSM, clientBuildTimeConfig.devservices());
    }
}
