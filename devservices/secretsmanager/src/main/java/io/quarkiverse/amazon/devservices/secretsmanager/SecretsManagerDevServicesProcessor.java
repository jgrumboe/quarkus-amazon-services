package io.quarkiverse.amazon.devservices.secretsmanager;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.secretsmanager.runtime.SecretsManagerBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class SecretsManagerDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSecretsManager(SecretsManagerBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("secretsmanager", clientBuildTimeConfig.devservices());
    }
}
