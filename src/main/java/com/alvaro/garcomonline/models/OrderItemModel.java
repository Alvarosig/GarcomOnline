package com.alvaro.garcomonline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_Orders_Items", schema = "garcom")
public class OrderItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_item")
    private Integer id;

    @NotNull
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private OrderModel orderModel;

    @ManyToOne
    @JoinColumn(name = "id_products")
    private ProductModel productModel;

}
