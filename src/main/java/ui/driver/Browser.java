package ui.driver;

import lombok.Getter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import ui.pages.manager.PageManager;

import java.util.List;
import java.util.function.Supplier;

@Getter
public class Browser extends DriverConfiguration implements SearchContext {

    private PageManager pageManager ;
    private SoftAssertions assertions = new SoftAssertions();

    public Browser() {
        initChromeDriver();
        driver.manage().window().maximize();
        setImplicitlyWaitToDefaultValue(driver);
        pageManager = new PageManager(this);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void executeScript(String script, Object... argument) {
        ((JavascriptExecutor) driver).executeScript(script, argument);
    }

    public <T> T performActionWithoutImplicitWait(Supplier<T> function) {
        try {
            setNoImplicitWait();

            T resultFunction = function.get();
            return resultFunction;
        } finally {
            setImplicitlyWaitToDefaultValue(driver);
        }
    }
}
