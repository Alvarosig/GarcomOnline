package com.alvaro.garcomonline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    private String cnpj;

    @NotBlank
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private AddressModel addressModel;

}
