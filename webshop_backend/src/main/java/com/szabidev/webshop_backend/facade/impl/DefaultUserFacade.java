package com.szabidev.webshop_backend.facade.impl;

import com.szabidev.webshop_backend.facade.UserFacade;
import com.szabidev.webshop_backend.facade.assembler.UserDataAssembler;
import com.szabidev.webshop_backend.facade.dto.UserData;
import com.szabidev.webshop_backend.service.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Default implementation of {@link UserFacade}
 */
@Component("userFacade")
public class DefaultUserFacade implements UserFacade {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "userDataAssembler")
    private UserDataAssembler userDataAssembler;


    @Override
    public Optional<UserData> getUserById(Long id) {
        return userService.getUserById(id).map(userDataAssembler::toModel);
    }

    @Override
    public CollectionModel<UserData> fetchAllUsers(){
        return userDataAssembler.toCollectionModel(userService.findAllUsers());
    }
}
