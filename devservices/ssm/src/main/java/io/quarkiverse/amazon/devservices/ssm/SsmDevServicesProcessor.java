package io.quarkiverse.amazon.devservices.ssm;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.ssm.runtime.SsmBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SsmDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSsm(SsmBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("ssm", clientBuildTimeConfig.devservices());
    }
}
