package ui.pages.manager.pages.w3scool.table.html;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import ui.driver.Browser;
import ui.elements.table.Table;

import java.util.concurrent.Callable;

import static utils.AssertionUtils.softAssertEquals;

public class HtmlAssertion extends HtmlTableLocators {

    protected HtmlAssertion(Browser browser) {
        super(browser);
    }

    public static HtmlAssertion getHtmlAssertion(Browser browser) {
        return browser.getPageManager().getHtmlPage().getAssertion();
    }

    @SneakyThrows
    @Step("Verify cell value")
    public void verifyTableCellText(Table table, int searchColumn, String searchText, int returnColumnText, String exceptedValue) {
        softAssertEquals(table.getTableCelText(searchColumn, searchText, returnColumnText), exceptedValue, browser, "Cell value");
    }

    @SneakyThrows
    @Step("Verify cell value by xpath")
    public void verifyTableCellTextByXpath(Table table, int searchColumn, String searchText, int returnColumnText, String exceptedValue) {
        softAssertEquals(table.getTableCelTextByXpath(searchColumn, searchText, returnColumnText), exceptedValue, browser, "Cell value");
    }

    @SneakyThrows
    @Step("Verify cell value")
    public void verifyTableCellText(Table table, String searchColumn, String searchText, int returnColumnText, String exceptedValue) {
        softAssertEquals(table.getTableCelText(searchColumn, searchText, returnColumnText), exceptedValue, browser, "Cell value");
    }
}
