package ui.wait;

import ui.elements.BaseElement;

import static awaiter.AsyncAwait.waitUntilConditionIsTrue;

public class WarpedElementsWait {

    public static void waitUntilVisibleOf(BaseElement element) {
        waitUntilConditionIsTrue(element::isEnabled, " element is enabled");
    }

    public static void waitUntilTextIsNoEmpty(BaseElement element) {
        waitUntilConditionIsTrue(() -> {
            System.out.println(element.getText());
            return element.getText().length() > 0;
        }, " element is enabled");
    }
}
