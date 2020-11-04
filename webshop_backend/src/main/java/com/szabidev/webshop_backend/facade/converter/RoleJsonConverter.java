package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.RoleJson;
import com.szabidev.webshop_backend.model.RoleModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("roleJsonConverter")
public class RoleJsonConverter implements Converter<RoleJson, RoleModel> {

    @Override
    public RoleModel convert(RoleJson source) {
        RoleModel roleModel = new RoleModel();
        roleModel.setName(source.getName());
        return roleModel;
    }
}
