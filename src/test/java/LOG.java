import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;

@Slf4j
public class LOG {
    public static void main(String[] args) {
        printLog();
    }

    private static void printLog() {
        log.debug("Debug Message");
        log.warn("Warn Message");
        log.error("Error Message");
        log.info("Info Message");
        log.trace("Trace Message");

    }

}
