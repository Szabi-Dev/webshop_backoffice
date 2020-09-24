package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.service.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("passwordEncoder")
public class DefaultPasswordEncoder implements PasswordEncoder {

    private static final Integer strength = 10;

    private org.springframework.security.crypto.password.PasswordEncoder encoder;

    public DefaultPasswordEncoder(){
        encoder = new BCryptPasswordEncoder(strength);
    }

    @Override
    public String encode(String pass) {
        return encoder.encode(pass);
    }

    @Override
    public boolean matches(String plainPass, String encPass) {
        return encoder.matches(plainPass, encPass);
    }

    @Override
    public org.springframework.security.crypto.password.PasswordEncoder getEncoder() {
        return encoder;
    }
}
