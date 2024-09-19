package com.jeido.film.services;

import com.jeido.film.dto.FilmDtoReceive;
import com.jeido.film.entities.Director;
import com.jeido.film.entities.Film;
import com.jeido.film.repositories.IDirectorRepository;
import com.jeido.film.repositories.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmService {
    private final IFilmRepository filmRepository;
    private final IDirectorRepository directorRepository;


    @Autowired
    public FilmService(IFilmRepository filmRepository, IDirectorRepository directorRepository) {
        this.filmRepository = filmRepository;
        this.directorRepository = directorRepository;
    }


    //CREATE
    public Film save(FilmDtoReceive filmDtoReceive) {
        Director director = directorRepository.findById(filmDtoReceive.getDirectorId()).orElseThrow();

        Film film = Film.builder()
                .name(filmDtoReceive.getName())
                .description(filmDtoReceive.getDescription())
                .genre(filmDtoReceive.getGenre())
                .director(director)
                .duration(filmDtoReceive.getDuration())
                .releaseDate(filmDtoReceive.getReleaseDate())
                .build();

        return filmRepository.save(film);
    }

    //READ
    public Film findById(UUID id) {
        return filmRepository.findById(id).orElseThrow();
    }

    public List<Film> findAll() {
        return (List<Film>) filmRepository.findAll();
    }

    public List<Film> findAllFilmsByDirector(Director director) {
        return filmRepository.findByDirector(director);
    }

    //UPDATE
    public Film update(FilmDtoReceive filmDtoReceive) {
        return save(filmDtoReceive);
    }

    //DELETE
    public void delete(Film film) {

        filmRepository.delete(film);
    }

    public void delete(UUID id) {
        filmRepository.deleteById(id);
    }

    public boolean isExist(String name) {
        return filmRepository.existsByName(name);
    }
}
