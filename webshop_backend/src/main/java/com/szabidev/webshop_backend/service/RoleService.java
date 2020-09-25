package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.PrivilegeModel;
import com.szabidev.webshop_backend.model.RoleModel;

import java.util.List;
import java.util.Optional;

/**
 * Interface to provide role specific operations
 */
public interface RoleService {
    /**
     * Get Role by id
     * @param id - id of Role
     * @return {@link RoleModel}
     */
    Optional<RoleModel> getRoleById(Long id);

    /**
     * Find all Roles
     * @return {@link List <RoleModel>}
     */
    List<RoleModel> findAllRoles();

    /**
     * Delete Role with specified id
     *
     * @param id - id
     * @return {@link Optional<RoleModel>}
     */
    Optional<RoleModel> deleteRoleById(Long id);

    /**
     * Create new Role
     *
     * @param roleModel - {@link RoleModel}
     * @return {@link Optional<RoleModel>}
     */
    Optional<RoleModel> createRole(RoleModel roleModel);

    /**
     * Update Role
     *
     * @param roleModel - {@link RoleModel}
     * @param id - id of the Role to be updated
     * @return {@link RoleModel}
     */
    Optional<RoleModel> updateRole(RoleModel roleModel, Long id);

    /**
     * Patch Role (update only the subset of attributes)
     *
     * @param roleModel - model sent in the request
     * @param id - id of the Role to be updated
     * @return {@link Optional<RoleModel>}
     */
    Optional<RoleModel> patchRole(RoleModel roleModel, Long id);

    /**
     * Find all privileges for user
     *
     * @param id - id
     * @return {@link List<PrivilegeModel>}
     */
    List<PrivilegeModel> findAllPrivilegesForRole(Long id);
}
