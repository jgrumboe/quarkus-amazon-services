package io.quarkiverse.amazon.devservices.rds;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.rds.runtime.RdsBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class RdsDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupRds(RdsBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("rds", clientBuildTimeConfig.devservices());
    }
}
