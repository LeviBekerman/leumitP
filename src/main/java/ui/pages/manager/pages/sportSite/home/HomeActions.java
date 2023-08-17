package ui.pages.manager.pages.sportSite.home;

import ui.driver.Browser;
import ui.elements.Button;

import static awaiter.AsyncAwait.waitUntilConditionIsTrue;

public class HomeActions extends HomeLocators {
    protected HomeActions(Browser browser) {
        super(browser);
    }

    public static HomeActions getHomeActions(Browser browser) {
        return browser.getPageManager().getSportHomePage().getHomeActions();
    }

    public void openLanguageOptions() {

        if (getNumberOfLanguageDisplay() == 0) {
            selectLanguageButton.click();
            waitUntilLanguageOptionsIsEnabled();
        }

    }

    public void waitUntilLanguageOptionsIsisUnEnabled() {
        waitUntilConditionIsTrue(() -> getNumberOfLanguageDisplay() == 0, "Wait until language options is unable");
    }

    public void waitUntilLanguageOptionsIsEnabled() {
        waitUntilConditionIsTrue(() -> getNumberOfLanguageDisplay() > 0, "Wait until language options is enabled");
    }

    public String getCodeLanguageSelected() {
        return selectLanguageButton.getText();
    }

    public void selectLanguage(String localLanguageName) {
        getLanguageSelectButtonByName(localLanguageName).click();
        waitUntilLanguageOptionsIsisUnEnabled();
    }

    public String getLanguageUrl(String localLanguageName) {
        return getLanguageSelectButtonByName(localLanguageName).getAttribute("href");
    }

    public String getLocalLanguageName(int languageNameDisplayIndex) {
        return languagesButton.getAll().get(languageNameDisplayIndex).getText();
    }

    public int getNumberOfLanguageDisplay() {
        return languagesButton.getNumberOfElements();
    }

    private Button getLanguageSelectButtonByName(String localLanguageName) {
        return languagesButton.getAll().stream().filter(button -> button.getText().toUpperCase().equals(localLanguageName.toUpperCase())).findFirst().orElseThrow(() -> new RuntimeException("No found local by local language name'" + localLanguageName + "'"));
    }


}
