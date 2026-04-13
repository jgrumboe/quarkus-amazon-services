package io.quarkiverse.amazon.common.deployment;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import io.quarkiverse.amazon.common.deployment.spi.AbstractDevServicesMiniStackProcessor;
import io.quarkiverse.amazon.common.deployment.spi.DevServicesMiniStackProviderBuildItem;
import io.quarkiverse.amazon.common.runtime.DevServicesBuildTimeConfig;
import io.quarkiverse.amazon.common.runtime.MiniStackDevServicesBuildTimeConfig;
import io.quarkus.deployment.annotations.BuildStep;

public class DevServicesAdditionalServicesMiniStackServiceProcessor extends AbstractDevServicesMiniStackProcessor {

    @BuildStep
    List<DevServicesMiniStackProviderBuildItem> setupServices(
            MiniStackDevServicesBuildTimeConfig miniStackDevServicesBuildTimeConfig) {
        return miniStackDevServicesBuildTimeConfig.additionalServices().entrySet().stream()
                .map(entry -> setupService(entry.getKey(), entry.getValue()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    DevServicesMiniStackProviderBuildItem setupService(String serviceName, DevServicesBuildTimeConfig config) {
        return setup(serviceName, config);
    }
}
