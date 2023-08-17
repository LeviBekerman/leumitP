package enums.ui.locators;

import org.openqa.selenium.By;
import static utils.files.fileReder.LocatorsUtils.*;

public enum LocatorsStrategy {
    XPATH {
        public By getLocators(String locators) {
            return By.xpath(locators);
        }
    },
    CSS {
        public By getLocators(String locators) {
            return By.cssSelector(locators);
        }
    },
    ID {
        public By getLocators(String locators) {
            return By.id(locators);
        }
    },
    CLASS_NAME {
        public By getLocators(String locators) {
            return By.className(locators);
        }
    },
    TAG_NAME {
        public By getLocators(String locators) {
            return By.tagName(locators);
        }
    },
    NAME {
        public By getLocators(String locators) {
            return By.name(locators);
        }
    },
    LINK_TEXT {
        public By getLocators(String locators) {
            return By.partialLinkText(locators);
        }
    },
    CONTAINS_TEXT {
        public By getLocators(String locators) {
            return By.xpath(getXpathByTextContains(locators));
        }
    },
    EQUALS_TEXT {
        public By getLocators(String locators) {
            return By.xpath(getXpathByTextEquals(locators));
        }
    },
    LINK {
        public By getLocators(String locators) {
            return By.xpath(getXpathByAttributeEquals("href", locators));
        }
    };

    public abstract By getLocators (String locators);

}
