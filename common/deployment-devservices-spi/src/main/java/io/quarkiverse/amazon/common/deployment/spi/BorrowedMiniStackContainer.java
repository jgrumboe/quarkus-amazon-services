package io.quarkiverse.amazon.common.deployment.spi;

import java.net.URI;

/**
 * Exposes configuration of an existing ministack container borrowed from another application
 */
public interface BorrowedMiniStackContainer {
    public URI getEndpointOverride();

    public String getRegion();

    public String getAccessKey();

    public String getSecretKey();
}
