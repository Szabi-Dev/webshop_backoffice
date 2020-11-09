package com.szabidev.webshop_backend.controller;

import com.szabidev.webshop_backend.controller.dto.DeliveryModeJson;
import com.szabidev.webshop_backend.facade.DeliveryModeFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/delivery")
public class DeliveryModeController {

    @Resource(name = "deliveryModeFacade")
    private DeliveryModeFacade deliveryModeFacade;

    @GetMapping
    public ResponseEntity<?> findAllDeliveryMode(){
        return ResponseEntity.ok(deliveryModeFacade.findAllDeliveryModes());
    }

    @PostMapping
    public ResponseEntity<?> createDeliveryMode(@RequestBody DeliveryModeJson deliveryModeJson) {
        return deliveryModeFacade.createDeliveryMode(deliveryModeJson)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeliveryById(@PathVariable Long id){
        return deliveryModeFacade.getDeliveryModeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchDeliveryMode(@PathVariable Long id, @RequestBody DeliveryModeJson deliveryModeJson){
        return deliveryModeFacade.patchDeliveryMode(deliveryModeJson, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDelivery(@PathVariable Long id){
        return deliveryModeFacade.deleteDeliveryMode(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }
}
