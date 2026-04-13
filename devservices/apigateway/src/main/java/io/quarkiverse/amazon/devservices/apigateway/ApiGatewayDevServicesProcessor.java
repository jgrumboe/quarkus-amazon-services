package io.quarkiverse.amazon.devservices.apigateway;

import io.quarkiverse.amazon.apigateway.runtime.ApiGatewayBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public class ApiGatewayDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupSsm(ApiGatewayBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("apigateway", clientBuildTimeConfig.devservices());
    }
}
