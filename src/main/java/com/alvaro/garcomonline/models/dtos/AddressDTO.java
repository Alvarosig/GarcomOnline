package com.alvaro.garcomonline.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {

    private Integer id;

    @NotNull
    private String city;

    @NotBlank
    private String address;

    @NotNull
    private Integer number;

    @NotBlank
    private String cep;
}
