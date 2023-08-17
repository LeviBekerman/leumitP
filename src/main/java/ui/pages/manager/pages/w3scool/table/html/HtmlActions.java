package ui.pages.manager.pages.w3scool.table.html;

import lombok.SneakyThrows;
import org.assertj.core.api.SoftAssertions;
import ui.driver.Browser;

import java.util.concurrent.Callable;

import static utils.AssertionUtils.softAssertEquals;

public class HtmlActions extends HtmlTableLocators {
    protected HtmlActions(Browser browser) {
        super(browser);
    }

    public static HtmlActions getHtmlActions(Browser browser) {
        return browser.getPageManager().getHtmlPage().getActions();
    }


}
