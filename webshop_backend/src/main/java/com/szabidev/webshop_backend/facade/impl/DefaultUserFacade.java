package com.szabidev.webshop_backend.facade.impl;

import com.szabidev.webshop_backend.controller.dto.UserJson;
import com.szabidev.webshop_backend.facade.UserFacade;
import com.szabidev.webshop_backend.facade.assembler.UserDataAssembler;
import com.szabidev.webshop_backend.facade.converter.UserJsonConverter;
import com.szabidev.webshop_backend.facade.dto.UserData;
import com.szabidev.webshop_backend.model.UserModel;
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

    @Resource(name = "userJsonConverter")
    private UserJsonConverter userJsonConverter;

    @Override
    public Optional<UserData> getUserById(Long id) {
        return userService.getUserById(id).map(userDataAssembler::toModel);
    }

    @Override
    public CollectionModel<UserData> fetchAllUsers(){
        return userDataAssembler.toCollectionModel(userService.findAllUsers());
    }

    @Override
    public Optional<Long> deleteUserById(Long id) {
        return userService.deleteUserById(id).map(UserModel::getId);
    }

    @Override
    public Optional<UserData> createUser(UserJson userJson) {
        UserModel userModel = userJsonConverter.convert(userJson);
        return userService.createUser(userModel).map(userDataAssembler::toModel);
    }

    @Override
    public Optional<UserData> updateUser(UserJson userJson, Long id) {
        UserModel userModel = userJsonConverter.convert(userJson);
        return userService.updateUser(userModel, id).map(userDataAssembler::toModel);
    }

    @Override
    public Optional<UserData> patchUser(UserJson userJson, Long id) {
        UserModel userModel = userJsonConverter.convert(userJson);
        return userService.patchUser(userModel, id).map(userDataAssembler::toModel);
    }
}
