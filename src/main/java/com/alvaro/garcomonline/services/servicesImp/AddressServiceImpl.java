package com.alvaro.garcomonline.services.servicesImp;

import com.alvaro.garcomonline.models.AddressModel;
import com.alvaro.garcomonline.repositories.AddressRepository;
import com.alvaro.garcomonline.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<AddressModel> findById(Integer id) {
        return addressRepository.findById(id);
    }
}
