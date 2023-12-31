package com.alvaro.garcomonline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_Address", schema = "garcom")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
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
