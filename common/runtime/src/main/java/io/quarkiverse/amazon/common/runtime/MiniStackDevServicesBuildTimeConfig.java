package io.quarkiverse.amazon.common.runtime;

import java.util.Map;
import java.util.Optional;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "quarkus.aws.devservices.ministack")
@ConfigRoot(phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
public interface MiniStackDevServicesBuildTimeConfig {
    /**
     * The MiniStack container image to use.
     */
    @WithDefault(value = "ministackorg/ministack:1.2")
    String imageName();

    /**
     * Generic properties that are pass for additional container configuration.
     */
    Map<String, String> containerProperties();

    /**
     * Path to init scripts folder executed during ministack startup.
     */
    Optional<String> initScriptsFolder();

    /**
     * Classpath to init scripts folder executed during ministack startup. initScriptsFolder has higher precedence.
     */
    Optional<String> initScriptsClasspath();

    /**
     * Specific container log message to be waiting for ministack init scripts
     * completion.
     */
    @WithDefault(value = "Application startup complete")
    Optional<String> initCompletionMsg();

    /**
     * Additional services to be started. Use this property if the service
     * you want is not covered by the extension
     */
    Map<String, DevServicesBuildTimeConfig> additionalServices();

    /**
     * Optional fixed port ministack will listen to.
     */
    Optional<Integer> port();
}
