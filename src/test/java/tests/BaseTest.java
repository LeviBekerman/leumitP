package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ui.driver.Browser;
@Slf4j
@ExtendWith({AllureLogsAttachmentExtension.class})
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
