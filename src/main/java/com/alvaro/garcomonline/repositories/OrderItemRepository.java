package com.alvaro.garcomonline.repositories;

import com.alvaro.garcomonline.models.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemModel, Integer> {
}
