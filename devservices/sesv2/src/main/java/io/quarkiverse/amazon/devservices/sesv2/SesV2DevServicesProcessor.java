package io.quarkiverse.amazon.devservices.sesv2;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.sesv2.runtime.SesV2BuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SesV2DevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSesV2(SesV2BuildTimeConfig clientBuildTimeConfig) {
        return this.setup("ses", clientBuildTimeConfig.devservices());
    }

    @Override
    protected String getPropertyConfigurationName(String serviceName) {
        return "sesv2";
    }
}
