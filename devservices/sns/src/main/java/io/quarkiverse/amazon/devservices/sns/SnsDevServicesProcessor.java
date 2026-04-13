package io.quarkiverse.amazon.devservices.sns;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.sns.runtime.SnsBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SnsDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSns(SnsBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("sns", clientBuildTimeConfig.devservices());
    }
}
