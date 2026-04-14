package io.quarkiverse.amazon.common.deployment.spi;

import java.net.URI;

/**
 * Exposes configuration of an existing localstack container borrowed from another application
 */
public interface BorrowedLocalStackContainer {
    public URI getEndpointOverride(EnabledService enabledService);

    public String getRegion();

    public String getAccessKey();

    public String getSecretKey();
}
