package io.quarkiverse.amazon.devservices.scheduler;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.scheduler.runtime.SchedulerBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SchedulerDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupEventBridge(SchedulerBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("scheduler", clientBuildTimeConfig.devservices());
    }
}
