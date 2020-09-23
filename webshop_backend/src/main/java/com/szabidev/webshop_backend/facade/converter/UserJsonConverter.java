package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.UserJson;
import com.szabidev.webshop_backend.model.UserModel;

import com.szabidev.webshop_backend.service.PasswordEncoder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userJsonConverter")
public class UserJsonConverter implements Converter<UserJson, UserModel> {

    @Resource(name = "passwordEncoder")
    private PasswordEncoder encoder;

    @Override
    public UserModel convert(UserJson source) {
        UserModel userModel = new UserModel();
        userModel.setEmail(source.getEmail());
        userModel.setFirstName(source.getFirstName());
        userModel.setLastName(source.getLastName());
        userModel.setPassword( encoder.encode( source.getPassword()));
        return userModel;
    }
}
