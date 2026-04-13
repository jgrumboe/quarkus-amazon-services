package io.quarkiverse.amazon.devservices.ecr;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.ecr.runtime.EcrBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class EcrDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupEcr(EcrBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("ecr", clientBuildTimeConfig.devservices());
    }
}
