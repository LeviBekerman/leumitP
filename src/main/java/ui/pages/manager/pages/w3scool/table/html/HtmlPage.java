package ui.pages.manager.pages.w3scool.table.html;

import lombok.Getter;
import ui.driver.Browser;
import ui.pages.manager.pages.AbstractBasePage;

@Getter
public class HtmlPage extends AbstractBasePage {

    private HtmlActions actions;
    private HtmlAssertion assertion;
    public HtmlPage(Browser browser) {
        super(browser);
        actions = new HtmlActions(browser);
        assertion = new HtmlAssertion(browser);
    }
}
