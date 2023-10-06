package com.alvaro.garcomonline.controllers;

import com.alvaro.garcomonline.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;
}
