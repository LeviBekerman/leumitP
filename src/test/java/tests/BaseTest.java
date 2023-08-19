package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.driver.Browser;

public abstract class BaseTest {
    protected  Browser browser;
    @BeforeEach
    protected void beforeTest(){
        browser = new Browser();
    }

    @AfterEach
    protected void afterTest(){
        browser.getDriver().quit();
        browser.getAssertions().assertAll();
    }



}
