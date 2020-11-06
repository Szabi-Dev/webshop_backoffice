package com.szabidev.webshop_backend.model.util;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LocaleProvider {

    private static String DEFAULT_LANGUAGE = "hu";

    public static String getCurrentLanguage(){
        Locale currentLocale = LocaleContextHolder.getLocale();
        if (currentLocale.getLanguage() == null || currentLocale.getLanguage().isEmpty()) {
            return DEFAULT_LANGUAGE;
        }
        List<String> supportedLanguages = getSupportedLanguages();
        if (!supportedLanguages.contains(currentLocale.getLanguage())) {
            return DEFAULT_LANGUAGE;
        }

        return currentLocale.getLanguage();
    }


    private static List<String> getSupportedLanguages() {
        return Arrays.asList(DEFAULT_LANGUAGE, "en", "sk");
    }
}
