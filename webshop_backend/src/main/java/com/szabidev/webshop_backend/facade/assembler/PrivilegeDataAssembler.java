package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.controller.PrivilegeController;
import com.szabidev.webshop_backend.facade.dto.PrivilegeData;
import com.szabidev.webshop_backend.model.PrivilegeModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component("privilegeDataAssembler")
public class PrivilegeDataAssembler implements RepresentationModelAssembler<PrivilegeModel, PrivilegeData> {

    private static final String ALL_PRIVILEGES_REL = "privileges";
    private static final String CREATE_PRIVILEGE_REL = "create";

    @Override
    public PrivilegeData toModel(PrivilegeModel entity) {
        PrivilegeData privilegeData = convert(entity);
        populateSelfLink(privilegeData);
        populateLinkToAll(privilegeData, ALL_PRIVILEGES_REL);
        return privilegeData;
    }

    @Override
    public CollectionModel<PrivilegeData> toCollectionModel(Iterable<? extends PrivilegeModel> entities) {
        List<PrivilegeData> privilegeDataList = new ArrayList<>();
        entities.forEach(entity -> privilegeDataList.add(this.toModel(entity)));
        return CollectionModel.of(privilegeDataList,
                linkTo(methodOn(PrivilegeController.class).fetchAllPrivileges()).withSelfRel(),
                linkTo(methodOn(PrivilegeController.class).createPrivilege(null)).withRel(CREATE_PRIVILEGE_REL));
    }

    private PrivilegeData convert(PrivilegeModel entity){
        PrivilegeData privilegeData = new PrivilegeData();
        privilegeData.setId(entity.getId());
        privilegeData.setName(entity.getName());
        return privilegeData;
    }

    private void populateSelfLink(PrivilegeData privilegeData){
        privilegeData.add(linkTo(methodOn(PrivilegeController.class).getPrivilegeById(privilegeData.getId())).withSelfRel());
    }

    private void populateLinkToAll(PrivilegeData privilegeData, String rel){
        privilegeData.add(linkTo(methodOn(PrivilegeController.class).fetchAllPrivileges()).withRel(rel));
    }
}
