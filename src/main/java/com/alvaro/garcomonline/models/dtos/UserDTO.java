package com.alvaro.garcomonline.models.dtos;

import com.alvaro.garcomonline.models.AddressModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Length(min = 3, max = 35, message = "O nome deve ter no máximo {max} caracteres")
    private String fullName;

    @Column(unique = true)
    private String username;

    @NotBlank
    private String email;

    @NotNull
    private LocalDate dateOfBirth;

    // Substituir para o model de Address
    private AddressModel addressModel;

}
