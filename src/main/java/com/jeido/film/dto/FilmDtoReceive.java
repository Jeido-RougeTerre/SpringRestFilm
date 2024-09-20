package com.jeido.film.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDtoReceive {

    @Size(min = 1, max = 255)
    private String name;

    private LocalDate releaseDate;

    @Max(2000)
    private String description;

    private Duration duration;

    @Max(255)
    private String genre;

    @NotNull
    private UUID directorId;
}
