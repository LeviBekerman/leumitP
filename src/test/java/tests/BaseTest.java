package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.driver.Browser;

public class BaseTest {
    protected  Browser browser;
    @BeforeEach
    public void beforeTest(){
        browser = new Browser();
    }

    @AfterEach
    public void afterTest(){
        browser.getAssertions().assertAll();
        browser.getDriver().quit();

    }



}
