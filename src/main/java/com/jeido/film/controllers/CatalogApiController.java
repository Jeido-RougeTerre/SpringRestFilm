package com.jeido.film.controllers;

import com.jeido.film.dto.DirectorDtoReceive;
import com.jeido.film.dto.DirectorDtoSend;
import com.jeido.film.dto.FilmDtoReceive;
import com.jeido.film.dto.FilmDtoSend;
import com.jeido.film.entities.Director;
import com.jeido.film.entities.Film;
import com.jeido.film.services.DirectorService;
import com.jeido.film.services.FilmService;
import com.jeido.film.util.Genre;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/catalogue/")
public class CatalogApiController {
    private final FilmService filmService;
    private final DirectorService directorService;


    @Autowired
    public CatalogApiController(FilmService filmService, DirectorService directorService) {
        this.filmService = filmService;
        this.directorService = directorService;

        if (!filmService.isExist("AAA")) {
            filmService.save(new FilmDtoReceive(
                    "AAA",
                    LocalDate.now(),
                    "Bien",
                    Duration.ofMinutes(145L),
                    Genre.COMEDY,
                    UUID.fromString("e32a16c9-5965-4f5a-8bd9-2576bd995b05")
            ));
        }
    }


    @PostMapping("film")
    public ResponseEntity<FilmDtoSend> addFilm(@Valid @RequestBody FilmDtoReceive filmDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(FilmDtoSend.of(filmService.save(filmDtoReceive)));
    }

    @GetMapping("films")
    public ResponseEntity<List<FilmDtoSend>> films() {
        List<Film> films = filmService.findAll();
        List<FilmDtoSend> filmDtoSends = new ArrayList<>();
        for (Film film : films) {
            filmDtoSends.add(FilmDtoSend.of(film));
        }

        return ResponseEntity.ok(filmDtoSends);
    }

    @GetMapping("film/{id}")
    public ResponseEntity<FilmDtoSend> film(@PathVariable("id") UUID id) {
        Film film = filmService.findById(id);
        FilmDtoSend filmDtoSend = FilmDtoSend.of(film);
        return ResponseEntity.ok(filmDtoSend);
    }

    @PutMapping("film")
    public ResponseEntity<FilmDtoSend> updateFilm(@Validated @RequestBody FilmDtoReceive filmDtoReceive) {
        return ResponseEntity.status(HttpStatus.OK).body(FilmDtoSend.of(filmService.save(filmDtoReceive)));
    }

    @DeleteMapping("film/{id}")
    public ResponseEntity<List<FilmDtoSend>> deleteFilm(@PathVariable("id") UUID id) {
        filmService.delete(id);
        return films();
    }

    @PostMapping("director")
    public ResponseEntity<DirectorDtoSend> addDirector(@Validated @RequestBody DirectorDtoReceive directorDtoReceive) {
        return ResponseEntity.status(HttpStatus.CREATED).body(DirectorDtoSend.of(directorService.save(directorDtoReceive), filmService));
    }

    @GetMapping("directors")
    public ResponseEntity<List<DirectorDtoSend>> directors() {
        List<Director> directors = directorService.findAll();
        List<DirectorDtoSend> directorDtoSends = new ArrayList<>();
        for (Director director : directors) {
            directorDtoSends.add(DirectorDtoSend.of(director, filmService));
        }

        return ResponseEntity.ok(directorDtoSends);
    }

    @GetMapping("director/{id}")
    public ResponseEntity<DirectorDtoSend> director(@PathVariable("id") UUID id) {
        Director director = directorService.findById(id);
        DirectorDtoSend directorDtoSend = DirectorDtoSend.of(director, filmService);
        return ResponseEntity.ok(directorDtoSend);
    }

    @PutMapping("director")
    public ResponseEntity<DirectorDtoSend> updateDirector(@Validated @RequestBody DirectorDtoReceive directorDtoReceive) {
        return ResponseEntity.ok(DirectorDtoSend.of(directorService.save(directorDtoReceive), filmService));
    }

    @DeleteMapping("director/{id}")
    public ResponseEntity<List<DirectorDtoSend>> deleteDirector(@PathVariable("id") UUID id) {
        directorService.delete(id);
        return directors();
    }

}
