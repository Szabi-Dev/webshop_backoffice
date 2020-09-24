package com.szabidev.webshop_backend.service;

/**
 * Service to encode and decode password
 */
public interface PasswordEncoder {

    /**
     * Encode the password
     * @param pass - password to be encoded
     * @return the encoded password
     */
    String encode(String pass);

    /**
     * Check whether the encoded pass matches the plain pass
     *
     * @param plainPass - password in plain text
     * @param encPass - encoded pass
     * @return True, if the plain password matches the encoded one
     */
    boolean matches(String plainPass, String encPass);

    /**
     * Getting the encoder wrapped in this custom class
     *
     * @return {@link org.springframework.security.crypto.password.PasswordEncoder}
     */
    org.springframework.security.crypto.password.PasswordEncoder getEncoder();
}
