package io.quarkiverse.amazon.devservices.resourcegroupstaggingapi;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.resourcegroupstaggingapi.runtime.ResourceGroupsTaggingApiBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class ResourceGroupsTaggingApiDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSsm(ResourceGroupsTaggingApiBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("resourcegroupstaggingapi", clientBuildTimeConfig.devservices());
    }
}
