package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.controller.RoleController;
import com.szabidev.webshop_backend.facade.dto.RoleData;
import com.szabidev.webshop_backend.model.RoleModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component("roleDataAssembler")
public class RoleDataAssembler implements RepresentationModelAssembler<RoleModel, RoleData> {

    private static final String ALL_ROLES_REL = "roles";
    private static final String CREATE_ROLE_REL = "create";

    @Override
    public RoleData toModel(RoleModel entity) {
        RoleData roleData = convert(entity);
        populateSelfLink(roleData);
        populateLinkToAll(roleData, ALL_ROLES_REL);
        return roleData;
    }

    @Override
    public CollectionModel<RoleData> toCollectionModel(Iterable<? extends RoleModel> entities) {
        List<RoleData> roleDataList = new ArrayList<>();
        entities.forEach(entity -> roleDataList.add(this.toModel(entity)));
        return CollectionModel.of(roleDataList,
                linkTo(methodOn(RoleController.class).fetchAllRoles()).withRel(ALL_ROLES_REL),
                linkTo(methodOn(RoleController.class).createRole(null)).withRel(CREATE_ROLE_REL));
    }

    private RoleData convert(RoleModel entity){
        RoleData roleData = new RoleData();
        roleData.setId(entity.getId());
        roleData.setName(entity.getName());
        return roleData;
    }

    private void populateSelfLink(RoleData roleData){
        roleData.add(linkTo(methodOn(RoleController.class).getRoleById(roleData.getId())).withSelfRel());
    }

    private void populateLinkToAll(RoleData roleData, String rel){
        roleData.add(linkTo(methodOn(RoleController.class).fetchAllRoles()).withRel(rel));
    }
}
