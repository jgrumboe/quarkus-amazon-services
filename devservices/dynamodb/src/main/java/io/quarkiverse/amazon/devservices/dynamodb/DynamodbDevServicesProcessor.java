package io.quarkiverse.amazon.devservices.dynamodb;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.dynamodb.runtime.DynamoDbBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class DynamodbDevServicesProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    DevServicesMiniStackProviderBuildItem setupDynamodb(DynamoDbBuildTimeConfig clientBuildTimeConfig) {
        return this.setup("dynamodb", clientBuildTimeConfig.devservices());
    }
}
