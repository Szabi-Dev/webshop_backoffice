package com.szabidev.webshop_backend.facade.assembler;


import com.szabidev.webshop_backend.controller.UserController;
import com.szabidev.webshop_backend.facade.dto.UserData;
import com.szabidev.webshop_backend.model.UserModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component("userDataAssembler")
public class UserDataAssembler implements RepresentationModelAssembler<UserModel, UserData> {

    private static String ALL_USERS_REL = "users";
    private static String DELETE_USER_REL = "delete";
    private static String CREATE_USER_REL = "create";

    @Override
    public UserData toModel(UserModel entity) {
        UserData userData = convert(entity);
        populateSelfLink(userData);
        populateLinkToAll(userData, ALL_USERS_REL);
        populateDeleteLink(userData, DELETE_USER_REL);
        return userData;
    }

    @Override
    public CollectionModel<UserData> toCollectionModel(Iterable<? extends UserModel> entities) {
        List<UserData> userDataList = new ArrayList<>();
        entities.forEach(entity ->  userDataList.add(this.toModel(entity)));
        return CollectionModel.of(userDataList,
                linkTo(methodOn(UserController.class).fetchAllUsers()).withSelfRel(),
                linkTo(methodOn(UserController.class).createUser(null)).withRel(CREATE_USER_REL));
    }

    private UserData convert(UserModel userModel){
        UserData userData =  new UserData();
        userData.setEmail(userModel.getEmail());
        userData.setFirstName(userModel.getFirstName());
        userData.setLastName(userModel.getLastName());
        userData.setId(userModel.getId());
        return userData;
    }

    private void populateSelfLink(UserData userData){
        userData.add(linkTo(methodOn(UserController.class).getUserById(userData.getId())).withSelfRel());
    }

    private void populateLinkToAll(UserData userData, String rel){
        userData.add(linkTo(methodOn(UserController.class).fetchAllUsers()).withRel(rel));
    }

    private void populateDeleteLink(UserData userData, String rel){
        userData.add(linkTo(methodOn(UserController.class).deleteUserById(userData.getId())).withRel(rel));
    }
}
