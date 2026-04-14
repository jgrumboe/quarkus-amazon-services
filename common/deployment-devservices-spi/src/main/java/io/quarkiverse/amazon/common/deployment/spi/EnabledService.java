package io.quarkiverse.amazon.common.deployment.spi;

/**
 * Represents an AWS service that can be enabled in the dev services container.
 * This is a local replacement for the removed LocalStackContainer.EnabledService type.
 * All services share the same port (4566) and are distinguished only by name.
 */
public interface EnabledService {
    String getName();

    int getPort();

    static EnabledService named(String name) {
        return new EnabledService() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public int getPort() {
                return 4566;
            }
        };
    }
}
