package io.quarkiverse.amazon.devservices.iam;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.Service;
import io.quarkiverse.amazon.iam.runtime.IamBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class IamDevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupIam(IamBuildTimeConfig clientBuildTimeConfig) {
        return this.setup(Service.IAM, clientBuildTimeConfig.devservices());
    }
}
