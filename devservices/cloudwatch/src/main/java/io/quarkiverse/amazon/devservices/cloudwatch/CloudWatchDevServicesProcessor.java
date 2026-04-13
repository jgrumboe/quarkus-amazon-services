package io.quarkiverse.amazon.devservices.cloudwatch;

import io.quarkiverse.amazon.cloudwatch.runtime.CloudWatchBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public class CloudWatchDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupCloudWatch(CloudWatchBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("cloudwatch", clientBuildTimeConfig.devservices());
    }
}
