package awaiter;

import exception.assertionError.AssertionTimeOutException;
import exception.assertionError.BooleanConditionTimeoutException;
import org.awaitility.core.ConditionFactory;
import org.awaitility.core.ConditionTimeoutException;
import org.awaitility.core.ThrowingRunnable;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.concurrent.Callable;

import static org.awaitility.Awaitility.await;

public class AsyncAwait {

    public static final AwaitedParameters DEFAULT_AWAITED = AwaitedParameters.builder().build();

    public static void waitUntilConditionIsTrue(Callable<Boolean> condition, String failureMessage) {
        waitUntilConditionIsTrue(condition, DEFAULT_AWAITED, failureMessage);
    }

    public static void waitUntilConditionIsTrue(Callable<Boolean> condition, AwaitedParameters awaitedParameters, String failureMessage) {
        try {
            getConditionFactory(awaitedParameters).until(condition);
        } catch (ConditionTimeoutException exception) {
            throw new BooleanConditionTimeoutException(awaitedParameters.getTimeout(), failureMessage, exception);
        }
    }


    public static void waitUntilAsserted(ThrowingRunnable throwingRunnable, String failureMessage) {
        try {
            getConditionFactory(DEFAULT_AWAITED).untilAsserted(throwingRunnable);
        } catch (ConditionTimeoutException exception) {
            throw new AssertionTimeOutException(DEFAULT_AWAITED.getTimeout(), failureMessage, exception);
        }
    }

    public static void waitUntilAsserted(ThrowingRunnable throwingRunnable, AwaitedParameters awaitedParameters, String failureMessage) {
        try {
            getConditionFactory(awaitedParameters).untilAsserted(throwingRunnable);
        } catch (ConditionTimeoutException exception) {
            throw new AssertionTimeOutException(awaitedParameters.getTimeout(), failureMessage, exception);
        }
    }

    private static ConditionFactory getConditionFactory(AwaitedParameters awaitedParameters) {
        return await().atMost(awaitedParameters.getTimeout()).
                pollInterval(awaitedParameters.getInterval()).
                ignoreException(StaleElementReferenceException.class).
                ignoreException(NoSuchElementException.class);
    }
}
