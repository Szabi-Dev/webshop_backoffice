package com.szabidev.webshop_backend.service.populator.impl;

import com.szabidev.webshop_backend.model.RoleModel;
import com.szabidev.webshop_backend.service.populator.Populator;
import org.springframework.stereotype.Component;

@Component("rolePopulator")
public class RolePopulator implements Populator<RoleModel, RoleModel> {


    @Override
    public void populatePut(RoleModel target, RoleModel source) {
        target.setName(source.getName());
        target.setPrivileges(source.getPrivileges());
        target.setUsers(source.getUsers());
    }

    @Override
    public void populatePatch(RoleModel target, RoleModel source) {
        if (source.getName()!=null && !source.getName().isEmpty()) target.setName(source.getName());
        if (source.getPrivileges()!= null && !source.getPrivileges().isEmpty()) target.setPrivileges(source.getPrivileges());
        if (source.getUsers()!=null && !source.getUsers().isEmpty()) target.setUsers(source.getUsers());
    }
}
