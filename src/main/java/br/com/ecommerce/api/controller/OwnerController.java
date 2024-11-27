package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.dto.owner.OwnerResponseDTO;
import br.com.ecommerce.api.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owners")
    public ResponseEntity<List<OwnerResponseDTO>> getAllOwners() {
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

}
