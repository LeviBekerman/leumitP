package utils;

import org.assertj.core.api.SoftAssertions;
import ui.driver.Browser;

import static org.assertj.core.api.Assertions.*;
import static utils.AllureUtils.screenshot;


public class AssertionUtils {

    public static <T> void softAssertEquals(T actual, T expected, Browser browser, String assertDescription){
        screenshotIfSoftAssertionFail(()-> browser.getAssertions().assertThat(actual).as(assertDescription).isEqualTo(expected), browser);
    }

    public static <T> void assertEquals(T actual, T expected, String assertDescription, Browser browser){
        screenshotIfTestFail(()-> assertThat(actual).as(assertDescription).isEqualTo(expected), browser);
    }

    private static void screenshotIfTestFail(Runnable assertion, Browser browser){
        try {
            assertion.run();
        }catch (Exception exception){
            screenshot(browser.getDriver());
        }
    }

    private static void screenshotIfSoftAssertionFail(Runnable assertion, Browser browser){
        int  errorSize = browser.getAssertions().assertionErrorsCollected().size();
        assertion.run();
        if (errorSize < browser.getAssertions().assertionErrorsCollected().size()){
            screenshot(browser.getDriver());
        }
    }
}
