package ui.elements;

import enums.ui.locators.LocatorsStrategy;
import org.openqa.selenium.WebElement;
import ui.driver.Browser;

import java.util.function.Supplier;

public class Label extends BaseElement {
    public Label(Browser browser, LocatorsStrategy locatorsStrategy, String selector) {
        super(browser, locatorsStrategy, selector);
    }

    public Label(BaseElement fatherElement, Browser browser, LocatorsStrategy locatorsStrategy, String selector) {
        super(fatherElement, browser, locatorsStrategy, selector);
    }

    public Label(Browser browser, Supplier<WebElement> webElementSupplier) {
        super(browser, webElementSupplier);
    }

    public boolean contains (String text){
        return getText().contains(text);
    }
    public boolean equals (String text){
        return getText().equals(text);
    }
}
