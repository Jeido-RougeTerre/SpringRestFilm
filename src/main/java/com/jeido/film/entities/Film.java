package com.jeido.film.entities;

import com.jeido.film.util.Genre;
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

    @Column(columnDefinition = "text")
    private String description;

    private Duration duration;

    @Enumerated
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
}
