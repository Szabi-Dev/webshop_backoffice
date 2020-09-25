package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.PrivilegeModel;
import com.szabidev.webshop_backend.model.PrivilegeModel;

import java.util.List;
import java.util.Optional;

/**
 * Service to provide privilege specific operations
 */
public interface PrivilegeService {

    /**
     * Get privilege by id
     * @param id - id of privilege
     * @return {@link PrivilegeModel}
     */
    Optional<PrivilegeModel> getPrivilegeById(Long id);

    /**
     * Find all privileges
     * @return {@link List<PrivilegeModel>}
     */
    List<PrivilegeModel> findAllPrivileges();

    /**
     * Delete Privilege with specified id
     *
     * @param id - id
     * @return {@link Optional<PrivilegeModel>}
     */
    Optional<PrivilegeModel> deletePrivilegeById(Long id);

    /**
     * Create new Privilege
     *
     * @param privilegeModel - {@link PrivilegeModel}
     * @return {@link Optional<PrivilegeModel>}
     */
    Optional<PrivilegeModel> createPrivilege(PrivilegeModel privilegeModel);

    /**
     * Update Privilege
     *
     * @param privilegeModel - {@link PrivilegeModel}
     * @param id - id of the Privilege to be updated
     * @return {@link PrivilegeModel}
     */
    Optional<PrivilegeModel> updatePrivilege(PrivilegeModel privilegeModel, Long id);

    /**
     * Patch Privilege (update only the subset of attributes)
     *
     * @param privilegeModel - model sent in the request
     * @param id - id of the Privilege to be updated
     * @return {@link Optional<PrivilegeModel>}
     */
    Optional<PrivilegeModel> patchPrivilege(PrivilegeModel privilegeModel, Long id);
}
