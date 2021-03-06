package com.szabidev.webshop_backend.controller;

import com.szabidev.webshop_backend.controller.dto.UserJson;
import com.szabidev.webshop_backend.facade.UserFacade;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userFacade")
    private UserFacade userFacade;

    @GetMapping
    public ResponseEntity<?> fetchAllUsers(){
        return ResponseEntity.ok(userFacade.fetchAllUsers());
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserJson userJson){
        return userFacade.createUser(userJson)
                .map(data -> ResponseEntity.status(HttpStatus.CREATED).body(data))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return userFacade.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.OK).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceUser(@PathVariable Long id, @RequestBody UserJson userJson){
        return userFacade.updateUser(userJson, id)
                .map(data -> ResponseEntity.status(HttpStatus.CREATED).body(data))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserJson userJson){
        return userFacade.patchUser(userJson, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.OK).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        return userFacade.deleteUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @GetMapping("/{id}/role")
    public ResponseEntity<?> getAllRolesForUser(@PathVariable Long id){
        return ResponseEntity.ok(userFacade.fetchAllRolesForUser(id));
    }

    @PatchMapping("/{userid}/role/{roleid}")
    public ResponseEntity<?> addRoleToUser(@PathVariable Long userid, @PathVariable Long roleid){
        return userFacade.addRoleToUser(userid, roleid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @DeleteMapping("/{userid}/role/{roleid}")
    public ResponseEntity<?> deleteRoleFromUser(@PathVariable Long userid, @PathVariable Long roleid){
        return userFacade.removeRoleFromUser(userid, roleid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }
}
