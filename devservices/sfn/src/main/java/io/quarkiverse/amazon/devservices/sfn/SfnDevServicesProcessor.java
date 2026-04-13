package io.quarkiverse.amazon.devservices.sfn;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.sfn.runtime.SfnBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SfnDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSfn(SfnBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("stepfunctions", clientBuildTimeConfig.devservices());
    }
}
