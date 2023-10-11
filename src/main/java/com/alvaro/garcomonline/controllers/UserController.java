package com.alvaro.garcomonline.controllers;

import com.alvaro.garcomonline.models.UserModel;
import com.alvaro.garcomonline.models.dtos.UserDTO;
import com.alvaro.garcomonline.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO userDTO) {
        UserDTO savedUserDTO = userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser (@PathVariable Integer id, @RequestBody @Valid UserDTO userDTO) {
        UserDTO updateUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updateUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listAllUsers() {
        List<UserDTO> userDTOs = userService.listAllUsers();
        return ResponseEntity.ok(userDTOs);
    }

}
