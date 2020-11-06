package com.szabidev.webshop_backend.service;

/**
 * Service to provide localization attributes
 */
public interface LocalizationService {

    /**
     * Get the actual localization (e.g from Request header)
     *
     * @return - the language string abbreviation
     */
    String getLocalization();
}
