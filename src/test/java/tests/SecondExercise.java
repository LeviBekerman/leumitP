package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import parameterized.SecondExerciseParameters;
import parameterized.SecondTestParameterByColumnIndex;
import parameterized.SecondTestParameterByColumnName;

import static properties.config.ConfigurationValues.SECOND_EXERCISE_URL;
import static ui.pages.manager.pages.w3scool.table.html.HtmlActions.getHtmlActions;
import static ui.pages.manager.pages.w3scool.table.html.HtmlAssertion.getHtmlAssertion;

@Slf4j
public class SecondExercise extends BaseTest {

    @BeforeEach
    public void navigateToSite(){
        browser.navigateTo(SECOND_EXERCISE_URL);
    }

    @SecondTestParameterByColumnIndex
    public void verifyTableCellTextByColumnIndex(SecondExerciseParameters parameter) {
        getHtmlAssertion(browser).verifyTableCellText(getHtmlActions(browser).castomersTable, (Integer) parameter.getSearchColumn(), parameter.getSearchText(), parameter.getReturnColumnText(), parameter.getExceptedValue());
    }

    @SecondTestParameterByColumnName
    public void verifyTableCellTextByColumnName(SecondExerciseParameters parameter) {
        getHtmlAssertion(browser).verifyTableCellText(getHtmlActions(browser).castomersTable, (String) parameter.getSearchColumn(), parameter.getSearchText(), parameter.getReturnColumnText(), parameter.getExceptedValue());
    }

    @SecondTestParameterByColumnIndex
    public void verifyTableCellTextByXpath(SecondExerciseParameters parameter) {
        getHtmlAssertion(browser).verifyTableCellTextByXpath(getHtmlActions(browser).castomersTable, (Integer) parameter.getSearchColumn(), parameter.getSearchText(), parameter.getReturnColumnText(), parameter.getExceptedValue());
    }
}
