package com.jeido.film.dto;

import com.jeido.film.entities.Film;
import com.jeido.film.util.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDtoSend {
    private UUID id;
    private String name;
    private LocalDate releaseDate;
    private String description;
    private Duration duration;
    private Genre genre;
    private UUID directorId;

    public static FilmDtoSend of(Film film) {
        return new FilmDtoSend(film.getId(), film.getName(), film.getReleaseDate(), film.getDescription(), film.getDuration(), film.getGenre(), film.getDirector().getId());
    }
}
