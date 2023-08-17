package ui.elements;

import enums.ui.locators.LocatorsStrategy;
import org.openqa.selenium.WebElement;
import ui.driver.Browser;

import java.util.function.Supplier;

import static ui.wait.WarpedElementsWait.waitUntilVisibleOf;

public class Button extends BaseElement {


    public Button(Browser browser, LocatorsStrategy locatorsStrategy, String selector) {
        super(browser, locatorsStrategy, selector);
    }

    public Button(BaseElement fatherElement, Browser browser, LocatorsStrategy locatorsStrategy, String selector) {
        super(fatherElement, browser, locatorsStrategy, selector);
    }

    public Button(Browser browser, Supplier<WebElement> webElementSupplier) {
        super(browser, webElementSupplier);
    }

    public void click() {
        waitUntilVisibleOf(this);
        getElement().click();
    }

    public void forceClick(Browser browser) {
        waitUntilVisibleOf(this);
        browser.executeScript("argument[0].click()", getElement());
    }
}
