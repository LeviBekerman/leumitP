package ui.pages.manager.pages.w3scool.table.html;

import ui.driver.Browser;
import ui.elements.table.Table;
import ui.pages.manager.pages.AbstractBasePage;

import static enums.ui.locators.LocatorsStrategy.ID;

public class HtmlTableLocators extends AbstractBasePage {
    public  Table castomersTable = new Table(browser, ID, "customers");
    protected HtmlTableLocators(Browser browser) {
        super(browser);
    }
}
