package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.UserModel;

import java.util.List;
import java.util.Optional;

/**
 * Service to provide user specific operations
 */
public interface UserService {

    /**
     * Get user by id
     * @param id - id of user
     * @return {@link UserModel}
     */
    Optional<UserModel> getUserById(Long id);

    /**
     * Find all users
     * @return {@link List<UserModel>}
     */
    List<UserModel> findAllUsers();

    /**
     * Delete user with specified id
     *
     * @param id - id
     * @return {@link Optional<UserModel>}
     */
    Optional<UserModel> deleteUserById(Long id);

    /**
     * Create new user
     *
     * @param userModel - {@link UserModel}
     * @return {@link Optional<UserModel>}
     */
    Optional<UserModel> createUser(UserModel userModel);

    /**
     * Update user
     *
     * @param userModel - {@link UserModel}
     * @param id - id of the user to be updated
     * @return {@link UserModel}
     */
    Optional<UserModel> updateUser(UserModel userModel, Long id);

}
