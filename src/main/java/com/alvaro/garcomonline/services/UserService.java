package com.alvaro.garcomonline.services;

import com.alvaro.garcomonline.models.AddressModel;
import com.alvaro.garcomonline.models.UserModel;
import com.alvaro.garcomonline.models.dtos.UserDTO;
import com.alvaro.garcomonline.services.servicesImp.UserServiceImpl;

import java.util.Optional;

public interface UserService {

    Optional<UserModel> findById(Integer id);

    UserModel saveUser (UserDTO userDTO);

}
