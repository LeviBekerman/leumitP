package ui.elements;

import enums.ui.locators.LocatorsStrategy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ui.driver.Browser;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static ui.elements.BaseElement.getSearchContext;

public class ElementList<ELEMENT_TYPE extends BaseElement> {
    private Class<ELEMENT_TYPE> elementClass;
    private BaseElement fatherElement;
    private Browser browser;
    private By locator;

    public ElementList(BaseElement fatherElement, Browser browser, LocatorsStrategy locatorsStrategy, String selector, Class<ELEMENT_TYPE> elementClass) {
        this(browser, locatorsStrategy, selector, elementClass);
        this.fatherElement = fatherElement;
    }

    public ElementList(Browser browser, LocatorsStrategy locatorsStrategy, String selector, Class<ELEMENT_TYPE> elementClass) {
        this.browser = browser;
        this.locator = locatorsStrategy.getLocators(selector);
        this.elementClass = elementClass;
    }

    public List<ELEMENT_TYPE> getAll() {
        int numberOfElements = getNumberOfElements();
        return IntStream.range(0, numberOfElements).mapToObj(this::getElementByIndex).collect(toList());
    }

    public int getNumberOfElements() {
        return browser.performActionWithoutImplicitWait(() -> getElements().size());
    }

    public ELEMENT_TYPE getElementByIndex(int index) {
        return getElementInstance(() -> getElements().get(index));
    }

    @SneakyThrows
    private ELEMENT_TYPE getElementInstance(Supplier<WebElement> webElementSupplier) {
        return elementClass.getConstructor(Browser.class, Supplier.class).newInstance(browser, webElementSupplier);
    }

    public ELEMENT_TYPE getElementByCondition(Predicate<ELEMENT_TYPE> condition, String conditionExplanation) {
        Supplier<NoSuchElementException> exception = ()-> new NoSuchElementException("Cold not find element with condition : '" + conditionExplanation +"'");

        Supplier<WebElement> elementSupplier = ()-> getAll().stream().filter(condition).findAny().orElseThrow(exception).getElement();
        return getElementInstance(elementSupplier);
    }

    private List<WebElement> getElements() {
        return getSearchContext(fatherElement, browser).findElements(locator);
    }
}
