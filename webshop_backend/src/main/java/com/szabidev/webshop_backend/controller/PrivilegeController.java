package com.szabidev.webshop_backend.controller;

import com.szabidev.webshop_backend.controller.dto.PrivilegeJson;
import com.szabidev.webshop_backend.facade.PrivilegeFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
    
    @Resource(name = "privilegeFacade")
    private PrivilegeFacade privilegeFacade;

    @GetMapping
    public ResponseEntity<?> fetchAllPrivileges(){
        return ResponseEntity.ok(privilegeFacade.fetchAllPrivileges());
    }

    @PostMapping
    public ResponseEntity<?> createPrivilege(@RequestBody PrivilegeJson privilegeJson){
        return privilegeFacade.createPrivilege(privilegeJson)
                .map(data -> ResponseEntity.status(HttpStatus.CREATED).body(data))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrivilegeById(@PathVariable Long id){
        return privilegeFacade.getPrivilegeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.OK).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replacePrivilege(@PathVariable Long id, @RequestBody PrivilegeJson PrivilegeJson){
        return privilegeFacade.updatePrivilege(PrivilegeJson, id)
                .map(data -> ResponseEntity.status(HttpStatus.CREATED).body(data))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePrivilege(@PathVariable Long id, @RequestBody PrivilegeJson PrivilegeJson){
        return privilegeFacade.patchPrivilege(PrivilegeJson, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.OK).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrivilegeById(@PathVariable Long id) {
        return privilegeFacade.deletePrivilegeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }
    
}
