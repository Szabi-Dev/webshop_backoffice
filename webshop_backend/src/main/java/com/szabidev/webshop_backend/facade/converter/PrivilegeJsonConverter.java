package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.PrivilegeJson;
import com.szabidev.webshop_backend.model.PrivilegeModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("privilegeJsonConverter")
public class PrivilegeJsonConverter implements Converter<PrivilegeJson, PrivilegeModel> {

    @Override
    public PrivilegeModel convert(PrivilegeJson source) {
        PrivilegeModel privilegeModel = new PrivilegeModel();
        privilegeModel.setName(source.getName());
        return privilegeModel;
    }
}
