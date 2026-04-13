package io.quarkiverse.amazon.devservices.eventbridge;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.eventbridge.runtime.EventBridgeBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class EventBridgeDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupEventBridge(EventBridgeBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("events", clientBuildTimeConfig.devservices());
    }
}
