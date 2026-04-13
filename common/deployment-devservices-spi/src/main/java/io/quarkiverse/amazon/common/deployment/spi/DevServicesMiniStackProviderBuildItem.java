package io.quarkiverse.amazon.common.deployment.spi;

import io.quarkus.builder.item.MultiBuildItem;

/**
 * BuildItem to request a ministack dev service container.
 *
 */
public final class DevServicesMiniStackProviderBuildItem extends MultiBuildItem {
    private final String serviceName;
    private final DevServicesAmazonProvider devProvider;
    private final MiniStackDevServicesBaseConfig config;

    /**
     * ctor
     *
     * @param serviceName amazon service name the container must expose
     * @param config configuration for this service
     * @param devProvider provider to configure the container and get client configuration properties
     */
    public DevServicesMiniStackProviderBuildItem(String serviceName,
            MiniStackDevServicesBaseConfig config,
            DevServicesAmazonProvider devProvider) {
        this.serviceName = serviceName;
        this.config = config;
        this.devProvider = devProvider;
    }

    public String getServiceName() {
        return serviceName;
    }

    public DevServicesAmazonProvider getDevProvider() {
        return devProvider;
    }

    public MiniStackDevServicesBaseConfig getConfig() {
        return config;
    }
}
