package io.quarkiverse.amazon.devservices.sesv2;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.EnabledService;
import io.quarkiverse.amazon.common.deployment.spi.Service;
import io.quarkiverse.amazon.sesv2.runtime.SesV2BuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SesV2DevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupSesV2(SesV2BuildTimeConfig clientBuildTimeConfig) {
        return this.setup(Service.SES, clientBuildTimeConfig.devservices());
    }

    @Override
    protected String getPropertyConfigurationName(EnabledService enabledService) {
        return "sesv2";
    }
}
