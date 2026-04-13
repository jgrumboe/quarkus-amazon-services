package io.quarkiverse.amazon.devservices.ses;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.ses.runtime.SesBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SesDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSes(SesBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("ses", clientBuildTimeConfig.devservices());
    }
}
