package ui.pages.manager.pages.sportSite.home;

import lombok.Getter;
import ui.driver.Browser;
import ui.pages.manager.pages.AbstractBasePage;

@Getter
public class SportHomePage extends AbstractBasePage {
    private HomeActions homeActions = new HomeActions(browser);
    private HomeAssertion homeAssertion = new HomeAssertion(browser);

    public SportHomePage(Browser browser) {
        super(browser);
    }
}
