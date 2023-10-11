package com.alvaro.garcomonline.services.servicesImp;

import com.alvaro.garcomonline.models.UserModel;
import com.alvaro.garcomonline.models.dtos.UserDTO;
import com.alvaro.garcomonline.repositories.UserRepository;
import com.alvaro.garcomonline.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public UserDTO saveUser (UserDTO userDTO) {
        UserModel userModel = userRepository.save(modelMapper.map(userDTO, UserModel.class));
        return toUserDTO(userModel);
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            System.out.println("Usuário não encontrado no sistema");
        }
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        Optional<UserModel> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserModel user = existingUser.get();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            return toUserDTO(userRepository.save(user));
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<UserModel> userModels = userRepository.findAll();
        List<UserDTO> userDTOs = userModels.stream()
                .map(userModel -> modelMapper.map(userModel, UserDTO.class))
                .collect(Collectors.toList());
        return userDTOs;
    }

    @Override
    public Optional<UserDTO> findById(Integer id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(this::toUserDTO);
    }

    private UserDTO toUserDTO (UserModel userModel) {
        return modelMapper.map(userModel, UserDTO.class);
    }
}
