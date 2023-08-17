package ui.pages.manager.pages.sportSite.home;

import ui.driver.Browser;
import ui.elements.Button;
import ui.elements.ElementList;
import ui.pages.manager.pages.AbstractBasePage;

import static enums.ui.locators.LocatorsStrategy.CLASS_NAME;
import static enums.ui.locators.LocatorsStrategy.XPATH;
import static utils.files.fileReder.LocatorsUtils.getXpathByAttributeContains;
import static utils.files.fileReder.LocatorsUtils.getXpathByAttributeEquals;

public class HomeLocators extends AbstractBasePage {
    protected Button selectLanguageButton = new Button(browser, CLASS_NAME, "current-language");
    protected ElementList<Button> languagesButton = new ElementList(browser, XPATH, getXpathByAttributeContains("class", "header-only-mobile show") +getXpathByAttributeEquals("class", "languageLink") + "/*[@href]", Button.class);

    protected HomeLocators(Browser browser) {
        super(browser);
    }
}
