package io.quarkiverse.amazon.devservices.iam;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.iam.runtime.IamBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class IamDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupIam(IamBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("iam", clientBuildTimeConfig.devservices());
    }
}
