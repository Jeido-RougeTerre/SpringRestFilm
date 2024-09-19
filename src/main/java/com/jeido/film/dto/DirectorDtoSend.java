package com.jeido.film.dto;

import com.jeido.film.entities.Director;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDtoSend {
    private UUID id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String nationality;

    public static DirectorDtoSend of(Director director) {
        return new DirectorDtoSend(director.getId(), director.getLastName(), director.getFirstName(), director.getBirthDate(), director.getNationality());
    }
}
