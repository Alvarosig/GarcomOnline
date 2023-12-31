package com.alvaro.garcomonline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_Products", schema = "garcom")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;

    @NotBlank (message = "O nome é obrigatório")
    @Length(min = 3, max = 35, message = "O nome deve ter no máximo {max} caracteres")
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_seller")
    private SellerModel sellerModel;

}
