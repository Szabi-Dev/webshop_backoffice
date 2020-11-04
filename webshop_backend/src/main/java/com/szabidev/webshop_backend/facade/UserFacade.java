package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.UserJson;
import com.szabidev.webshop_backend.facade.dto.RoleData;
import com.szabidev.webshop_backend.facade.dto.UserData;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Facade to transform results coming from the service to DTO
 */

public interface UserFacade {

    /**
     * Fetch the user and converts it into {@link UserData}
     *
     * @param id - id of user
     * @return {@link Optional<UserData>}
     */
    Optional<UserData> getUserById(Long id);

    /**
     * Fetch all the users and convert them into {@link CollectionModel<UserData>}
     *
     * @return {@link CollectionModel<UserData>}
     */
    CollectionModel<UserData> fetchAllUsers();

    /**
     * Delete user by Id
     *
     * @param id - id
     * @return id of deleted user
     */
    Optional<Long> deleteUserById(Long id);

    /**
     * Create a new user
     *
     * @param userJson - json coming from the request
     * @return {@link Optional<UserData>}
     */
    Optional<UserData> createUser(UserJson userJson);

    /**
     * Update a user
     * @param userJson - user with the update
     * @return {@link Optional<UserData>}
     */
    Optional<UserData> updateUser(UserJson userJson, Long id);

    /**
     * Patch a user (update just specific fields)
     * @param userJson - json holding the data
     * @param id - id of the user to be updated
     * @return {@link Optional<UserData>}
     */
    Optional<UserData> patchUser(UserJson userJson, Long id);

    /**
     * Fetch all roles for user
     *
     * @param id - id
     * @return {@link CollectionModel<RoleData>}
     */
    CollectionModel<RoleData> fetchAllRolesForUser(Long id);

    /**
     * Add role to a user
     *
     * @param userid - id of a user
     * @param roleid - id of a role
     * @return {@link Optional<UserData>}
     */
    Optional<UserData> addRoleToUser(Long userid, Long roleid);

    /**
     * Remove a role from a user
     *
     * @param userid - id of a user
     * @param roleid - id of a role
     * @return {@link Optional<UserData>}
     */
    Optional<UserData> removeRoleFromUser(Long userid, Long roleid);

}
