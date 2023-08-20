package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureUtils {
    @Attachment(value = "logs", type = "text/html", fileExtension = ".txt")
    public static byte[] addAllureTxtAttachment(String logs) {
        return logs.getBytes();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] screenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String getAllureTestUUID() {
        return Allure.getLifecycle().getCurrentTestCase().orElse("");
    }

    public static void addAllureUUIDToCurrentThreadLogs(String uuid) {
        ThreadContext.put("test-uuid", uuid);
    }

}
