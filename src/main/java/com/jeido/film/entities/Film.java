package com.jeido.film.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "film_id")
    private UUID id;
    private String name;
    private LocalDate releaseDate;
    private String description;
    private Duration duration;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
}
