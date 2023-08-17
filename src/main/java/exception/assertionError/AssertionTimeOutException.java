package exception.assertionError;

import org.awaitility.core.ConditionTimeoutException;

import java.time.Duration;

import static org.apache.commons.lang3.time.DurationFormatUtils.formatDurationWords;
import static utils.time.DurationUtils.getDurationByHumanReadAble;

public class AssertionTimeOutException extends RuntimeException {
    public AssertionTimeOutException(Duration timeoutDuration, String failureMessage, ConditionTimeoutException exception) {
        super("Timed out waiting: " + getDurationByHumanReadAble(timeoutDuration) + " until assertion passes: " + failureMessage);
        initCause(exception);
    }
}
