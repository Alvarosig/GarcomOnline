package com.alvaro.garcomonline.controllers;

import com.alvaro.garcomonline.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
}
