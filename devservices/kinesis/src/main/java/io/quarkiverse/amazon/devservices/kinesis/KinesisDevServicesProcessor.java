package io.quarkiverse.amazon.devservices.kinesis;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.kinesis.runtime.KinesisBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class KinesisDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupKinesis(KinesisBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("kinesis", clientBuildTimeConfig.devservices());
    }
}
