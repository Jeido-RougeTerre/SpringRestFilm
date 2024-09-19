package com.jeido.film.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "director_id")
    private UUID id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String nationality;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Film> films;
}
