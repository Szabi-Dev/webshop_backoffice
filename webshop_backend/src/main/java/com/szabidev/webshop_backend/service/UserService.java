package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.UserModel;

import java.util.List;
import java.util.Optional;

/**
 * Service to provide user specific operations
 */
public interface UserService {

    /**
     * Get user by name
     * @param Id - id of user
     * @return {@link UserModel}
     */
    Optional<UserModel> getUserById(Long Id);

    /**
     * Find all users
     * @return {@link List<UserModel>}
     */
    List<UserModel> findAllUsers();

}
