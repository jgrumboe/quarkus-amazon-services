package io.quarkiverse.amazon.devservices.sts;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.sts.runtime.StsBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class StsDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSts(StsBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("sts", clientBuildTimeConfig.devservices());
    }
}