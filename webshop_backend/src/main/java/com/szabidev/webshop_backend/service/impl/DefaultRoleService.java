package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.RoleRepository;
import com.szabidev.webshop_backend.model.PrivilegeModel;
import com.szabidev.webshop_backend.model.RoleModel;
import com.szabidev.webshop_backend.service.RoleService;
import com.szabidev.webshop_backend.service.populator.impl.RolePopulator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("roleService")
public class DefaultRoleService implements RoleService {

    @Resource(name = "roleRepository")
    private RoleRepository roleRepository;

    @Resource(name = "rolePopulator")
    private RolePopulator rolePopulator;

    @Override
    public Optional<RoleModel> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<RoleModel> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<RoleModel> deleteRoleById(Long id) {
        Optional<RoleModel> roleModel = roleRepository.findById(id);
        if (roleModel.isPresent()) {
            roleRepository.deleteById(id);
            return roleModel;
        }
        return Optional.empty();
    }

    @Override
    public Optional<RoleModel> createRole(RoleModel roleModel) {
        if (roleRepository.findByName(roleModel.getName()).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(roleRepository.save(roleModel));
    }

    @Override
    public Optional<RoleModel> updateRole(RoleModel roleModel, Long id) {
        if (!roleRepository.existsById(id)) {
            return createRole(roleModel);
        }
        RoleModel roleToBeUpdated = roleRepository.findById(id).get();
        rolePopulator.populatePut(roleToBeUpdated, roleModel);
        return Optional.of(roleRepository.save(roleToBeUpdated));
    }

    @Override
    public Optional<RoleModel> patchRole(RoleModel roleModel, Long id) {
        if (!roleRepository.existsById(id)) {
            return createRole(roleModel);
        }
        RoleModel roleToBeUpdated = roleRepository.findById(id).get();
        rolePopulator.populatePatch(roleToBeUpdated, roleModel);
        return Optional.of(roleRepository.save(roleToBeUpdated));
    }

    @Override
    public List<PrivilegeModel> findAllPrivilegesForRole(Long id) {
        Optional<RoleModel> roleModel = roleRepository.findById(id);
        return roleModel.map(role -> new ArrayList<>(role.getPrivileges()))
                .orElseGet(ArrayList::new);
    }

    @Override
    public Optional<RoleModel> addPrivilegeToRole(Long roleId, PrivilegeModel privilegeModel) {
        Optional<RoleModel> roleModel = getRoleById(roleId);
        if (!roleModel.isPresent()) {
            return Optional.empty();
        }
        RoleModel role = roleModel.get();
        if (role.getPrivileges().contains(privilegeModel)) {
            return Optional.empty();
        }

        role.getPrivileges().add(privilegeModel);
        return patchRole(role, roleId);
    }

    @Override
    public Optional<RoleModel> removePrivilegeFromRole(Long roleId, PrivilegeModel privilegeModel) {
        Optional<RoleModel> roleModel = getRoleById(roleId);
        if (!roleModel.isPresent()) {
            return Optional.empty();
        }
        RoleModel role = roleModel.get();
        if (!role.getPrivileges().contains(privilegeModel)) {
            return Optional.empty();
        }
        role.getPrivileges().remove(privilegeModel);
        return patchRole(role, roleId);
    }
}
