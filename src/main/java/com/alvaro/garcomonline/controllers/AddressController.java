package com.alvaro.garcomonline.controllers;

import com.alvaro.garcomonline.models.dtos.AddressDTO;
import com.alvaro.garcomonline.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PutMapping("{id}")
    public ResponseEntity <AddressDTO> addressUpdate (@PathVariable Integer id, @RequestBody @Valid AddressDTO addressDTO) {
        AddressDTO addressUpdate = addressService.updateAddress(id, addressDTO);
        return ResponseEntity.ok(addressUpdate);
    }

}
