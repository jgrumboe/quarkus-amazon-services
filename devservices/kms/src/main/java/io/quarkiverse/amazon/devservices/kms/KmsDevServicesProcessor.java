package io.quarkiverse.amazon.devservices.kms;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.kms.runtime.KmsBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class KmsDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupKms(KmsBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("kms", clientBuildTimeConfig.devservices());
    }
}
