package com.jeido.film.dto;

import com.jeido.film.entities.Director;
import com.jeido.film.services.FilmService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
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
    private List<FilmDtoSend> films;

    public static DirectorDtoSend of(Director director, FilmService filmService) {
        return new DirectorDtoSend(director.getId(), director.getLastName(), director.getFirstName(), director.getBirthDate(), director.getNationality(), filmService.findAllFilmsByDirector(director).stream().map(FilmDtoSend::of).toList());
    }
}
