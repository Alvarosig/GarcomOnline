package com.alvaro.garcomonline.models.dtos;

import com.alvaro.garcomonline.models.SellerModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Length(min = 3, max = 35, message = "O nome deve ter no máximo {max} caracteres")
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Boolean status;

    private SellerModel sellerModel;
}
