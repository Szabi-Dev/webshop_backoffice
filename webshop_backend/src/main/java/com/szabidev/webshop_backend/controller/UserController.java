package com.szabidev.webshop_backend.controller;

import com.szabidev.webshop_backend.facade.UserFacade;
import com.szabidev.webshop_backend.facade.dto.UserData;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userFacade")
    private UserFacade userFacade;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<UserData> userData = userFacade.getUserById(id);
        if (userData.isPresent()){
            return ResponseEntity.ok(userData.get());
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        Optional<Long> userId = userFacade.deleteUserById(id);
        if (userId.isPresent()){
            return ResponseEntity.ok(userId.get());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public CollectionModel<UserData> fetchAllUsers(){
        return userFacade.fetchAllUsers();
    }
}
