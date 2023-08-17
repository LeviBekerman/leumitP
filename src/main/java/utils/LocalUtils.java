package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static java.util.Arrays.asList;

public class LocalUtils {
    public static final List<Locale> localeList = asList(Locale.getAvailableLocales());

    public static String getCodeByLocalLanguageName(String localLanguageName) {
        return getLocalByLocalLanguageName(localLanguageName).getLanguage().toUpperCase();
    }

    public static Locale getLocalByLocalLanguageName(String localLanguageName) {
        return localeList.stream().filter(locale -> locale.getDisplayName(locale).toLowerCase().contains(localLanguageName.toLowerCase())).findFirst().orElseThrow(() -> new RuntimeException("No found local by local language name'" + localLanguageName + "'"));
    }
}
