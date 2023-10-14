package com.alvaro.garcomonline.services.servicesImp;

import com.alvaro.garcomonline.models.AddressModel;
import com.alvaro.garcomonline.models.dtos.AddressDTO;
import com.alvaro.garcomonline.repositories.AddressRepository;
import com.alvaro.garcomonline.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Optional<AddressDTO> findById(Integer id) {
        Optional<AddressModel> addressModel = addressRepository.findById(id);
        return addressModel.map(this::toAddressDTO);
    }

    @Override
    public AddressDTO updateAddress(Integer id, AddressDTO addressDTO) {
        Optional<AddressModel> addressModel = addressRepository.findById(id);
        if (addressModel.isPresent()){
            AddressModel address = addressModel.get();
            address.setCity(addressDTO.getCity());
            address.setAddress(addressDTO.getAddress());
            address.setCep(addressDTO.getAddress());
            address.setNumber(addressDTO.getNumber());
            return toAddressDTO(addressRepository.save(address));
        } else {
            return null;
        }
    }

    private AddressDTO toAddressDTO (AddressModel addressModel) {
        return modelMapper.map(addressModel, AddressDTO.class);
    }
}
