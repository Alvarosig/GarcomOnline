package com.alvaro.garcomonline.controllers;

import com.alvaro.garcomonline.models.dtos.SellerDTO;
import com.alvaro.garcomonline.services.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerDTO> saveSeller (@RequestBody @Valid SellerDTO sellerDTO) {
        SellerDTO savedSeller = sellerService.saveSeller(sellerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSeller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller (@PathVariable Integer id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SellerDTO> updateSeller (@PathVariable Integer id, @RequestBody @Valid SellerDTO sellerDTO) {
        SellerDTO updateSeller = sellerService.updateSeller(id, sellerDTO);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
}
