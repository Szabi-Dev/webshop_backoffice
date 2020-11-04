package com.szabidev.webshop_backend.service.populator.impl;

import com.szabidev.webshop_backend.model.UserModel;
import com.szabidev.webshop_backend.service.populator.Populator;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link com.szabidev.webshop_backend.service.populator.Populator} for {@link com.szabidev.webshop_backend.model.UserModel}
 */
@Component("userPopulator")
public class UserPopulator implements Populator<UserModel, UserModel> {

    @Override
    public void populatePut(UserModel target, UserModel source) {
        target.setPassword(source.getPassword());
        target.setLastName(source.getLastName());
        target.setEmail(source.getEmail());
        target.setFirstName(source.getFirstName());
    }

    @Override
    public void populatePatch(UserModel target, UserModel source) {
        if (source.getFirstName() != null) target.setFirstName(source.getFirstName());
        if (source.getLastName() != null) target.setLastName(source.getLastName());
        if (source.getEmail() != null) target.setEmail(source.getEmail());
        if (source.getPassword() != null) target.setPassword(source.getPassword());
    }
}
