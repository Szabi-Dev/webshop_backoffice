package com.szabidev.webshop_backend.controller;

import com.szabidev.webshop_backend.controller.dto.RoleJson;
import com.szabidev.webshop_backend.facade.RoleFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource(name = "roleFacade")
    private RoleFacade roleFacade;

    @GetMapping
    public ResponseEntity<?> fetchAllRoles(){
        return ResponseEntity.ok(roleFacade.fetchAllRoles());
    }

    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody RoleJson RoleJson){
        return roleFacade.createRole(RoleJson)
                .map(data -> ResponseEntity.status(HttpStatus.CREATED).body(data))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id){
        return roleFacade.getRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.OK).build());
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Long id, @RequestBody RoleJson RoleJson){
        return roleFacade.patchRole(RoleJson, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.OK).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoleById(@PathVariable Long id) {
        return roleFacade.deleteRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @GetMapping("/{id}/privilege")
    public ResponseEntity<?> findAllPrivilegesForRole(@PathVariable Long id){
        return ResponseEntity.ok(roleFacade.fetchAllPrivileges(id));
    }

    @PatchMapping("/{roleId}/privilege/{privilegeId}")
    public ResponseEntity<?> addPrivilegeToRole(@PathVariable Long roleId, @PathVariable Long privilegeId){
        return roleFacade.addPrivilegeToRole(roleId, privilegeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @DeleteMapping("/{roleId}/privilege/{privilegeId}")
    public ResponseEntity<?> removePrivilegeFromRole(@PathVariable Long roleId, @PathVariable Long privilegeId){
        return roleFacade.removePrivilegeFromRole(roleId, privilegeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }
}
