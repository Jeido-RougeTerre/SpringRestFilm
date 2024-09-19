package com.jeido.film.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDtoReceive {
    @Size(min = 2, max = 20)
    private String lastName;

    @Size(min = 2, max = 20)
    private String firstName;

    private LocalDate birthDate;

    @Size(min = 2, max = 20)
    private String nationality;
}
