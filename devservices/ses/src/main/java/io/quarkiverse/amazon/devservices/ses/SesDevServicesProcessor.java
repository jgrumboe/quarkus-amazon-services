package io.quarkiverse.amazon.devservices.ses;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.Service;
import io.quarkiverse.amazon.ses.runtime.SesBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SesDevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupSes(SesBuildTimeConfig clientBuildTimeConfig) {
        return this.setup(Service.SES, clientBuildTimeConfig.devservices());
    }
}
