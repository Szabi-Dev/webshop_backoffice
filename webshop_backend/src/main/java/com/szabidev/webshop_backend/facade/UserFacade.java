package com.szabidev.webshop_backend.facade;

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



}
