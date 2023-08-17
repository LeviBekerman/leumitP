package ui.pages.manager.pages.sportSite.home;

import ui.driver.Browser;

import static utils.AssertionUtils.softAssertEquals;

public class HomeAssertion extends HomeLocators {

    HomeActions actions = new HomeActions(browser);
    protected HomeAssertion(Browser browser) {
        super(browser);
    }

    public static HomeAssertion HomeAssertion(Browser browser) {
        return browser.getPageManager().getSportHomePage().getHomeAssertion();
    }

    public void softAssertionCodeLanguageIsDisplayCorrect(String actualLanguageNameCode, String codeExpected) {
        softAssertEquals(actualLanguageNameCode, codeExpected, browser, "Language code selected");
    }


}
