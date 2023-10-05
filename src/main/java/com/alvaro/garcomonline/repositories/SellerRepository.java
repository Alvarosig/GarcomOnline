package com.alvaro.garcomonline.repositories;

import com.alvaro.garcomonline.models.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerModel, Integer> {
}
