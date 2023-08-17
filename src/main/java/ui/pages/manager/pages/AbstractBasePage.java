package ui.pages.manager.pages;

import ui.driver.Browser;

public abstract class AbstractBasePage {
    protected Browser browser;
    protected AbstractBasePage(Browser browser){
        this.browser = browser;
    }
}
