package com.alvaro.garcomonline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_Users", schema = "garcom")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @NotBlank (message = "O nome é obrigatório")
    @Length(min = 3, max = 35, message = "O nome deve ter no máximo {max} caracteres")
    private String fullName;

    @Column(unique = true)
    private String username;

    @NotNull
    private String email;

    @NotNull
    private LocalDate dateOfBirth;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private AddressModel addressModel;

}
