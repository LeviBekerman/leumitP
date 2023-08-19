package ui.elements;

import enums.ui.locators.LocatorsStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ui.driver.Browser;

import javax.swing.*;
import java.util.function.Supplier;

public class BaseElement {

    protected Browser browser;
    private WebElement element;
    private BaseElement fatherElement;

    protected By locator;
    protected LocatorsStrategy locatorsStrategy;
    protected String selector;

    //Fore list Implementation
    private Supplier<WebElement> elementSupplier;

    public BaseElement(Browser browser, LocatorsStrategy locatorsStrategy, String selector) {
        this.browser = browser;
        this.locatorsStrategy = locatorsStrategy;
        this.selector = selector;
        this.locator = locatorsStrategy.getLocators(selector);
    }

    public BaseElement(BaseElement fatherElement, Browser browser, LocatorsStrategy locatorsStrategy, String selector) {
        this(browser, locatorsStrategy, selector);
        this.fatherElement = fatherElement;
    }

    public BaseElement(Browser browser, Supplier<WebElement> webElementSupplier) {
        this.browser = browser;
        this.elementSupplier = webElementSupplier;
    }

    public WebElement getElement() {
        if (element == null || isStale()) {
            initElement();
        }
        return element;
    }

    private boolean isStale() {
        try {
            element.getTagName();
            return false;
        } catch (StaleElementReferenceException | NoSuchElementException exception) {
            return true;
        }
    }

    private void initElement() {
        if (elementSupplier != null){
            element = elementSupplier.get();
        } else {
            element = getSearchContext(fatherElement, browser).findElement(locator);
        }
    }

    public static SearchContext getSearchContext(BaseElement fatherElement, Browser browser) {
        return fatherElement == null ? browser : fatherElement.getElement();
    }

    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    public String getText() {
        return getElement().getText();
    }

    public void scrollToElement() {
        browser.executeScript("arguments[0].scrollIntoView()", getElement());
    }

    public String getAttribute(String attribute) {
        return getElement().getAttribute(attribute);
    }

    public void click() {
        getElement().click();
    }

}
