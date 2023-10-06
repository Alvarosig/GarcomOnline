package com.alvaro.garcomonline.services;

import com.alvaro.garcomonline.models.AddressModel;

import java.util.Optional;

public interface AddressService {

    Optional <AddressModel> findById(Integer id);
}
