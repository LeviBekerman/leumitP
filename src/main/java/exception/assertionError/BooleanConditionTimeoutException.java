package exception.assertionError;

import org.awaitility.core.ConditionTimeoutException;

import java.time.Duration;

import static utils.time.DurationUtils.getDurationByHumanReadAble;

public class BooleanConditionTimeoutException extends RuntimeException {
    public BooleanConditionTimeoutException(Duration duration, String failureMessage, ConditionTimeoutException originalException) {
        super("Timed out waiting:" + getDurationByHumanReadAble(duration) + ", until: " + failureMessage);
        initCause(originalException);
    }
}
