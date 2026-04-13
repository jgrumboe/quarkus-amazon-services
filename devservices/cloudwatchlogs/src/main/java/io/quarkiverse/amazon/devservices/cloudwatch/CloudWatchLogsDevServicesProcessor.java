package io.quarkiverse.amazon.devservices.cloudwatch;

import io.quarkiverse.amazon.cloudwatchlogs.runtime.CloudWatchLogsBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public class CloudWatchLogsDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupCloudWatchLogs(CloudWatchLogsBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("cloudwatchlogs", clientBuildTimeConfig.devservices());
    }
}
