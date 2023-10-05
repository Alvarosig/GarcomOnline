package com.alvaro.garcomonline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_Sellers", schema = "garcom")
public class SellerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seller")
    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Length(min = 3, max = 35, message = "O nome deve ter no máximo {max} caracteres")
    private String nome;

    @NotBlank
    private String cpnj;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private AddressModel addressModel;

}
