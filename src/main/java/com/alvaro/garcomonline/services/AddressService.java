package com.alvaro.garcomonline.services;

import com.alvaro.garcomonline.models.dtos.AddressDTO;

import java.util.Optional;

public interface AddressService {

    Optional <AddressDTO> findById(Integer id);

    AddressDTO updateAddress (Integer id, AddressDTO addressDTO);
}
