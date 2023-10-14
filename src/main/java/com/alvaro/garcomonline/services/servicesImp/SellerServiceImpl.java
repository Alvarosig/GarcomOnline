package com.alvaro.garcomonline.services.servicesImp;

import com.alvaro.garcomonline.models.SellerModel;
import com.alvaro.garcomonline.models.dtos.SellerDTO;
import com.alvaro.garcomonline.repositories.SellerRepository;
import com.alvaro.garcomonline.services.SellerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Optional<SellerDTO> findById(Integer id) {
        Optional<SellerModel> sellerModel = sellerRepository.findById(id);
        return sellerModel.map(this::toSellerDTO);
    }

    @Transactional
    public SellerDTO saveSeller(SellerDTO sellerDTO) {
        SellerModel sellerModel = sellerRepository.save(modelMapper.map(sellerDTO, SellerModel.class));
        return toSellerDTO(sellerModel);
    }

    @Override
    public void deleteSeller(Integer id) {
        Optional<SellerModel> sellerModel = sellerRepository.findById(id);
        if (sellerModel.isPresent()) {
            sellerRepository.delete(sellerModel.get());
        } else {
            System.out.println("Nenhum vendedor encontrado");
        }
    }

    @Override
    public SellerDTO updateSeller(Integer id, SellerDTO sellerDTO) {
        Optional<SellerModel> existingSeller = sellerRepository.findById(id);
        if (existingSeller.isPresent()) {
            SellerModel seller = existingSeller.get();
            modelMapper.map(sellerDTO, seller);
            return toSellerDTO(sellerRepository.save(seller));
        } else {
            return null;
        }
    }

    private SellerDTO toSellerDTO (SellerModel sellerModel) {
        return modelMapper.map(sellerModel, SellerDTO.class);
    }

}
