package io.quarkiverse.amazon.devservices.apigateway;

import io.quarkiverse.amazon.apigateway.runtime.ApiGatewayBuildTimeConfig;
import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesLocalStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesLocalStackProviderBuildItem;
import io.quarkiverse.amazon.common.deployment.spi.EnabledService;
import io.quarkus.deployment.annotations.BuildStep;

public class ApiGatewayDevServicesProcessor extends AbstractDevServicesLocalStackProcessor {

    @BuildStep
    DevServicesLocalStackProviderBuildItem setupSsm(ApiGatewayBuildTimeConfig clientBuildTimeConfig) {
        return this.setup(EnabledService.named("apigateway"), clientBuildTimeConfig.devservices());
    }
}
