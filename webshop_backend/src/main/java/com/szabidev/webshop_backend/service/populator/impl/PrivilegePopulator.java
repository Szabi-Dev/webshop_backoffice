package com.szabidev.webshop_backend.service.populator.impl;

import com.szabidev.webshop_backend.model.PrivilegeModel;
import com.szabidev.webshop_backend.service.populator.Populator;
import org.springframework.stereotype.Component;

@Component("privilegePopulator")
public class PrivilegePopulator implements Populator<PrivilegeModel, PrivilegeModel> {

    @Override
    public void populatePut(PrivilegeModel target, PrivilegeModel source) {
        target.setName(source.getName());
        target.setRoles(source.getRoles());
    }

    @Override
    public void populatePatch(PrivilegeModel target, PrivilegeModel source) {
        if (source.getName() != null && !source.getName().isEmpty() ) target.setName(source.getName());
        if (source.getRoles() != null && !source.getRoles().isEmpty() ) target.setRoles(source.getRoles());
    }
}
