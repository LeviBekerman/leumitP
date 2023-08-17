package awaiter;

import lombok.Builder;
import lombok.Getter;
import lombok.Builder.Default;


import java.time.Duration;

import static properties.config.ConfigurationValues.DEFAULT_AWAITER_INTERVAL_IN_MILLIS;
import static properties.config.ConfigurationValues.SELENIUM_EXPLICIT_WAIT_IN_SECONDS;

@Builder
@Getter
public class AwaitedParameters {

    @Default
    Duration timeout = Duration.ofSeconds(SELENIUM_EXPLICIT_WAIT_IN_SECONDS);
    @Default
    Duration interval = Duration.ofMillis(DEFAULT_AWAITER_INTERVAL_IN_MILLIS);

}
