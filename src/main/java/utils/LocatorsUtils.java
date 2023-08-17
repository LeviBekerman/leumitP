package utils;

public class LocatorsUtils {

    public static String getXpathByTextContains(String value) {
        return "//*[contains(text(), '" + value + "')]";
    }

    public static String getXpathByTextEquals(String value) {
        return "//*[text()= '" + value + "')]";
    }

    public static String getXpathByAttributeEquals(String attribute, String value) {
        return "//*[@" + attribute + "='" + value + "']";
    }

    public static String getXpathByAttributeContains(String attribute, String value) {
        return "//*[contains(@" + attribute + ",'" + value + "')]";
    }
}
