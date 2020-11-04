package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.RoleJson;
import com.szabidev.webshop_backend.facade.dto.PrivilegeData;
import com.szabidev.webshop_backend.facade.dto.RoleData;
import com.szabidev.webshop_backend.model.PrivilegeModel;
import org.springframework.hateoas.CollectionModel;

import java.util.List;
import java.util.Optional;

/**
 * Facade to transform data coming from {@link com.szabidev.webshop_backend.service.RoleService}
 */
public interface RoleFacade {
    /**
     * Fetch the Role and converts it into {@link RoleData}
     *
     * @param id - id of Role
     * @return {@link Optional <RoleData>}
     */
    Optional<RoleData> getRoleById(Long id);

    /**
     * Fetch all the Roles and convert them into {@link CollectionModel <RoleData>}
     *
     * @return {@link CollectionModel<RoleData>}
     */
    CollectionModel<RoleData> fetchAllRoles();

    /**
     * Delete Role by Id
     *
     * @param id - id
     * @return id of deleted Role
     */
    Optional<Long> deleteRoleById(Long id);

    /**
     * Create a new Role
     *
     * @param roleJson - json coming from the request
     * @return {@link Optional<RoleData>}
     */
    Optional<RoleData> createRole(RoleJson roleJson);

    /**
     * Update a Role
     * @param roleJson - Role with the update
     * @return {@link Optional<RoleData>}
     */
    Optional<RoleData> updateRole(RoleJson roleJson, Long id);

    /**
     * Patch a Role (update just specific fields)
     * @param roleJson - json holding the data
     * @param id - id of the Role to be updated
     * @return {@link Optional<RoleData>}
     */
    Optional<RoleData> patchRole(RoleJson roleJson, Long id);

    /**
     * Fetch all the priviliges associated with a role
     * @param id - role id
     * @return {@link List<PrivilegeModel>}
     */
    CollectionModel<PrivilegeData> fetchAllPrivileges(Long id);


    Optional<RoleData> addPrivilegeToRole(Long roleId, Long privilegeId);

    Optional<RoleData> removePrivilegeFromRole(Long roleId, Long privilegeId);
}
