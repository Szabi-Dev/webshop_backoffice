package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.UserJson;
import com.szabidev.webshop_backend.model.UserModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("userJsonConverter")
public class UserJsonConverter implements Converter<UserJson, UserModel> {

    @Override
    public UserModel convert(UserJson source) {
        UserModel userModel = new UserModel();
        userModel.setEmail(source.getEmail());
        userModel.setFirstName(source.getFirstName());
        userModel.setLastName(source.getLastName());
        userModel.setPassword(source.getPassword());
        return userModel;
    }
}
