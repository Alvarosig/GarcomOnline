package com.alvaro.garcomonline.services;

import com.alvaro.garcomonline.models.dtos.SellerDTO;

import java.util.Optional;

public interface SellerService {

    Optional<SellerDTO> findById(Integer id);

    SellerDTO saveSeller (SellerDTO sellerDTO);

    void deleteSeller (Integer id);

    SellerDTO updateSeller (Integer id, SellerDTO sellerDTO);
}
