package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.service.LocalizationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service("localizationService")
public class DefaultLocalizationService implements LocalizationService {

    @Value("${localization.languages.defaultLanguage}")
    private String DEFAULT_LANGUAGE;

    @Value("#{${localization.languages.supportedLanguages}}")
    private List<String> supportedLanguages;

    @Override
    public String getLocalization() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        if (currentLocale.getLanguage() == null || currentLocale.getLanguage().isEmpty()) {
            return DEFAULT_LANGUAGE;
        }

        if (!supportedLanguages.contains(currentLocale.getLanguage())) {
            return DEFAULT_LANGUAGE;
        }

        return currentLocale.getLanguage();
    }

}
