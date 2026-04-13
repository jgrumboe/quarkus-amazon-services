package io.quarkiverse.amazon.devservices.lambda;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.lambda.runtime.LambdaBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class LambdaDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupLambda(LambdaBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("lambda", clientBuildTimeConfig.devservices());
    }
}
