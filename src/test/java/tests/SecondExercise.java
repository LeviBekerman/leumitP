package tests;

import lombok.extern.slf4j.Slf4j;
import parameterized.SecondExerciseParameters;
import parameterized.SecondTestParameter;

import static properties.config.ConfigurationValues.SECOND_EXERCISE_URL;
import static ui.pages.manager.pages.w3scool.table.html.HtmlActions.getHtmlActions;
import static ui.pages.manager.pages.w3scool.table.html.HtmlAssertion.getHtmlAssertion;

@Slf4j
public class SecondExercise extends BaseTest {

    @SecondTestParameter
    public void secondExercise(SecondExerciseParameters parameter) {
        browser.navigateTo(SECOND_EXERCISE_URL);
        getHtmlAssertion(browser).verifyTableCellText(getHtmlActions(browser).castomersTable, parameter.getSearchColumn(), parameter.getSearchText(), parameter.getReturnColumnText(), parameter.getExceptedValue());
    }
}
