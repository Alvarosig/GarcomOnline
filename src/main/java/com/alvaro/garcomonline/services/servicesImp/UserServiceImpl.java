package com.alvaro.garcomonline.services.servicesImp;

import com.alvaro.garcomonline.models.UserModel;
import com.alvaro.garcomonline.models.dtos.UserDTO;
import com.alvaro.garcomonline.repositories.UserRepository;
import com.alvaro.garcomonline.services.AddressService;
import com.alvaro.garcomonline.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ModelMapper modelMapper;

    public UserModel saveUser (UserDTO userDTO) {
        var userModel = modelMapper.map(userDTO, UserModel.class);
        userModel.setAddressModel(addressService.findById(userDTO.getAddressModelId()).orElse(null));
        return userRepository.save(userModel);
    }

    @Override
    public Optional<UserModel> findById(Integer id) {
        return userRepository.findById(id);
    }

}
