package com.alvaro.garcomonline.controllers;

import com.alvaro.garcomonline.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;
}
