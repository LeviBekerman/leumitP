package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static properties.config.ConfigurationValues.SELENIUM_IMPLICIT_WAIT_IN_SECONDS;
import static java.time.Duration.ofNanos;
import static java.time.Duration.ofSeconds;


public abstract class DriverConfiguration {
    @Getter
    protected WebDriver driver;

    protected void initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void setImplicitlyWaitToDefaultValue(WebDriver driver) {
        setImplicitlyWait(driver, ofSeconds(SELENIUM_IMPLICIT_WAIT_IN_SECONDS));
    }

    public static void setImplicitlyWait(WebDriver driver, Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public void setNoImplicitWait(){
        setImplicitlyWait(driver, ofNanos(1));
    }

}
