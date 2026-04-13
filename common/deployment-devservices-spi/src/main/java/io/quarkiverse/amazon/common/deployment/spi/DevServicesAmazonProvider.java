package io.quarkiverse.amazon.common.deployment.spi;

import java.util.Map;

import org.ministack.testcontainers.MiniStackContainer;

/**
 * Allows to prepare a ministack container and get client properties
 */
public interface DevServicesAmazonProvider {
    /**
     * Prepare a new container owned by this application
     *
     * @param ministack The new ministack container
     * @return properties to configure a client to consume the container
     */
    Map<String, String> prepareMiniStack(MiniStackContainer ministack);

    /**
     * Prepare an existing container not owned by this application
     *
     * @param ministack The borrowed ministack container
     * @return properties to configure a client to consume the container
     */
    Map<String, String> reuseMiniStack(BorrowedMiniStackContainer ministack);
}
