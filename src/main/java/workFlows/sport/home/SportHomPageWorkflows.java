package workFlows.sport.home;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ui.driver.Browser;
import ui.pages.manager.pages.sportSite.home.HomeActions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Arrays.asList;
import static ui.pages.manager.pages.sportSite.home.HomeActions.getHomeActions;
import static ui.pages.manager.pages.sportSite.home.HomeAssertion.HomeAssertion;

@Slf4j
public class SportHomPageWorkflows {

    @Step("Assertion display language code")
    public static void softAssertionCodeLanguageIsDisplayCorrect(String expectedCod, Browser browser) {
        HomeAssertion(browser).softAssertionCodeLanguageIsDisplayCorrect(getHomeActions(browser).getCodeLanguageSelected(), expectedCod);
    }

    @SneakyThrows
    public static String getExpectedCod(int selectLanguageDisplayIndex, Browser browser) {
        HomeActions homeActions = getHomeActions(browser);
        String localLanguageName = homeActions.getLocalLanguageName(selectLanguageDisplayIndex);
        String url = homeActions.getLanguageUrl(localLanguageName);
        List<Callable<String>> getCodOptions = asList((() -> getCodeByRegex(url)), () -> getCodeBySubString(url), () -> getCodeBySplit(url));
        int getIndex = selectLanguageDisplayIndex % getCodOptions.size();
        return getCodOptions.get(getIndex).call().toUpperCase();
    }


    private static String getCodeByRegex(String url) {
        log.info("url = " + url);
        String code;
        if (url.endsWith("en")) {
            code = url.replace("https://www.888.com/?lang=", "");
        } else {
            code = url.replace("https://", "").replace(".888.com/", "");
        }
        log.info("code language by regex is '" + code + "'");
        return code;
    }

    private static String getCodeBySubString(String url) {
        String code;
        String noCodeeValue[] = isEnglishUrlSelector(url) ? url.split("=") : url.split("//");
        url = url.substring(noCodeeValue[0].length());
        if (isEnglishUrlSelector(url)) {
            code = url.substring(1,3);
        } else {
            code = url.substring(2, url.length()).substring(0, 2);
        }

        log.info("code language by sub string is '" + code + "'");
        return code;
    }

    private static String getCodeBySplit(String url) {
        String slashes = "//";
        String codeRegex = "[A-Za-z]{2}";
        String equals = "=";
        String splitBy = isEnglishUrlSelector(url) ? equals + codeRegex : slashes + codeRegex;
        List<String> noCodeeValues = new ArrayList(asList(url.split(splitBy)));
        noCodeeValues.addAll(asList(splitBy, slashes, equals));
        AtomicReference<String> result = new AtomicReference<>(url);
        noCodeeValues.forEach(noCodeeValue -> {
            result.set(result.get().replace(noCodeeValue, ""));
        });

        log.info("code language by split is '" + result.get() + "'");
        return result.get();
    }

    private static boolean isEnglishUrlSelector(String url) {
        return url.contains("en");
    }
}
