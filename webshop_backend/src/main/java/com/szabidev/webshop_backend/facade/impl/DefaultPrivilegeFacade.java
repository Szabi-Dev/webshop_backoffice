package com.szabidev.webshop_backend.facade.impl;

import com.szabidev.webshop_backend.controller.dto.PrivilegeJson;
import com.szabidev.webshop_backend.facade.PrivilegeFacade;
import com.szabidev.webshop_backend.facade.assembler.PrivilegeDataAssembler;
import com.szabidev.webshop_backend.facade.converter.PrivilegeJsonConverter;
import com.szabidev.webshop_backend.facade.dto.PrivilegeData;
import com.szabidev.webshop_backend.model.PrivilegeModel;
import com.szabidev.webshop_backend.service.PrivilegeService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Default implementation of {@link com.szabidev.webshop_backend.facade.PrivilegeFacade}
 */
@Component("privilegeFacade")
public class DefaultPrivilegeFacade implements PrivilegeFacade {

    @Resource(name = "privilegeService")
    private PrivilegeService privilegeService;

    @Resource(name = "privilegeDataAssembler")
    private PrivilegeDataAssembler privilegeDataAssembler;

    @Resource(name = "privilegeJsonConverter")
    private PrivilegeJsonConverter privilegeJsonConverter;

    @Override
    public Optional<PrivilegeData> getPrivilegeById(Long id) {
        return privilegeService.getPrivilegeById(id)
                .map(privilegeDataAssembler::toModel);
    }

    @Override
    public CollectionModel<PrivilegeData> fetchAllPrivileges() {
        return privilegeDataAssembler.toCollectionModel(privilegeService.findAllPrivileges());
    }

    @Override
    public Optional<Long> deletePrivilegeById(Long id) {
        return privilegeService.deletePrivilegeById(id)
                .map(PrivilegeModel::getId);
    }

    @Override
    public Optional<PrivilegeData> createPrivilege(PrivilegeJson privilegeJson) {
        PrivilegeModel privilegeModel = privilegeJsonConverter.convert(privilegeJson);
        return privilegeService.createPrivilege(privilegeModel)
                .map(privilegeDataAssembler::toModel);
    }

    @Override
    public Optional<PrivilegeData> updatePrivilege(PrivilegeJson privilegeJson, Long id) {
        PrivilegeModel privilegeModel = privilegeJsonConverter.convert(privilegeJson);
        return privilegeService.updatePrivilege(privilegeModel, id)
                .map(privilegeDataAssembler::toModel);
    }

    @Override
    public Optional<PrivilegeData> patchPrivilege(PrivilegeJson privilegeJson, Long id) {
        PrivilegeModel privilegeModel = privilegeJsonConverter.convert(privilegeJson);
        return privilegeService.patchPrivilege(privilegeModel, id)
                .map(privilegeDataAssembler::toModel);
    }
}
