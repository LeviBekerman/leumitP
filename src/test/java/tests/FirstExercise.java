package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ui.pages.manager.pages.sportSite.home.HomeActions;

import java.util.stream.IntStream;

import static properties.config.ConfigurationValues.FIRST_EXERCISE_URL;
import static ui.pages.manager.pages.sportSite.home.HomeActions.getHomeActions;
import static workFlows.sport.home.SportHomPageWorkflows.getExpectedCod;
import static workFlows.sport.home.SportHomPageWorkflows.softAssertionCodeLanguageIsDisplayCorrect;

@Slf4j
public class FirstExercise extends BaseTest {

    @Test
    public void firstExercise() {
        HomeActions homeActions = getHomeActions(browser);

        browser.navigateTo(FIRST_EXERCISE_URL);
        homeActions.openLanguageOptions();

        IntStream.range(0, homeActions.getNumberOfLanguageDisplay()).
                forEach(selectLanguageDisplayIndex -> {

                    homeActions.openLanguageOptions();

                    String localLanguageName = homeActions.getLocalLanguageName(selectLanguageDisplayIndex);

                    log.info("Display local language name = '" + localLanguageName + "'");
                    String expectedCode = getExpectedCod(selectLanguageDisplayIndex, browser);
                    homeActions.selectLanguage(localLanguageName);
                    softAssertionCodeLanguageIsDisplayCorrect(expectedCode, browser);

                });
    }
}
