package com.alvaro.garcomonline.dtos;

import java.time.LocalDate;

public record UserDTO(Integer id, String fullName, String email, LocalDate dateOfBirth) {
}
