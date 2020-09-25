package com.szabidev.webshop_backend.facade.impl;

import com.szabidev.webshop_backend.controller.dto.RoleJson;
import com.szabidev.webshop_backend.facade.RoleFacade;
import com.szabidev.webshop_backend.facade.assembler.PrivilegeDataAssembler;
import com.szabidev.webshop_backend.facade.assembler.RoleDataAssembler;
import com.szabidev.webshop_backend.facade.converter.RoleJsonConverter;
import com.szabidev.webshop_backend.facade.dto.PrivilegeData;
import com.szabidev.webshop_backend.facade.dto.RoleData;
import com.szabidev.webshop_backend.model.RoleModel;
import com.szabidev.webshop_backend.service.RoleService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component("roleFacade")
public class DefaultRoleFacade implements RoleFacade {

    @Resource(name = "roleService")
    private RoleService roleService;

    @Resource(name = "roleDataAssembler")
    private RoleDataAssembler roleDataAssembler;

    @Resource(name = "privilegeDataAssembler")
    private PrivilegeDataAssembler privilegeDataAssembler;

    @Resource(name = "roleJsonConverter")
    private RoleJsonConverter roleJsonConverter;


    @Override
    public Optional<RoleData> getRoleById(Long id) {
        return roleService.getRoleById(id)
                .map(roleDataAssembler::toModel);
    }

    @Override
    public CollectionModel<RoleData> fetchAllRoles() {
        return roleDataAssembler.toCollectionModel(roleService.findAllRoles());
    }

    @Override
    public Optional<Long> deleteRoleById(Long id) {
        return roleService.deleteRoleById(id)
                .map(RoleModel::getId);
    }

    @Override
    public Optional<RoleData> createRole(RoleJson roleJson) {
        RoleModel roleModel = roleJsonConverter.convert(roleJson);
        return roleService.createRole(roleModel)
                .map(roleDataAssembler::toModel);
    }

    @Override
    public Optional<RoleData> updateRole(RoleJson roleJson, Long id) {
        RoleModel roleModel = roleJsonConverter.convert(roleJson);
        return roleService.updateRole(roleModel,id)
                .map(roleDataAssembler::toModel);
    }

    @Override
    public Optional<RoleData> patchRole(RoleJson roleJson, Long id) {
        RoleModel roleModel = roleJsonConverter.convert(roleJson);
        return roleService.patchRole(roleModel,id)
                .map(roleDataAssembler::toModel);
    }

    @Override
    public CollectionModel<PrivilegeData> fetchAllPrivileges(Long id) {
        return privilegeDataAssembler.toCollectionModel(roleService.findAllPrivilegesForRole(id));
    }
}
