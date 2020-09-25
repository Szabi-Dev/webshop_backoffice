package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.PrivilegeJson;
import com.szabidev.webshop_backend.facade.dto.PrivilegeData;
import org.springframework.hateoas.CollectionModel;

import java.util.Optional;

/**
 * Facade to transform results coming from {@link com.szabidev.webshop_backend.service.PrivilegeService}
 */
public interface PrivilegeFacade {
    /**
     * Fetch the Privilege and converts it into {@link PrivilegeData}
     *
     * @param id - id of Privilege
     * @return {@link Optional <PrivilegeData>}
     */
    Optional<PrivilegeData> getPrivilegeById(Long id);

    /**
     * Fetch all the Privileges and convert them into {@link CollectionModel <PrivilegeData>}
     *
     * @return {@link CollectionModel<PrivilegeData>}
     */
    CollectionModel<PrivilegeData> fetchAllPrivileges();

    /**
     * Delete Privilege by Id
     *
     * @param id - id
     * @return id of deleted Privilege
     */
    Optional<Long> deletePrivilegeById(Long id);

    /**
     * Create a new Privilege
     *
     * @param privilegeJson - json coming from the request
     * @return {@link Optional<PrivilegeData>}
     */
    Optional<PrivilegeData> createPrivilege(PrivilegeJson privilegeJson);

    /**
     * Update a Privilege
     * @param privilegeJson - Privilege with the update
     * @return {@link Optional<PrivilegeData>}
     */
    Optional<PrivilegeData> updatePrivilege(PrivilegeJson privilegeJson, Long id);

    /**
     * Patch a Privilege (update just specific fields)
     * @param privilegeJson - json holding the data
     * @param id - id of the Privilege to be updated
     * @return {@link Optional<PrivilegeData>}
     */
    Optional<PrivilegeData> patchPrivilege(PrivilegeJson privilegeJson, Long id);
}
