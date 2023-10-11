package com.alvaro.garcomonline.services;

import com.alvaro.garcomonline.models.dtos.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findById(Integer id);

    UserDTO saveUser (UserDTO userDTO);

    void deleteUser (Integer id);

    UserDTO updateUser (Integer id, UserDTO userDTO);

    List<UserDTO> listAllUsers();
}
