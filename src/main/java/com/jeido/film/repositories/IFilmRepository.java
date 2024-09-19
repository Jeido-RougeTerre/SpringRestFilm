package com.jeido.film.repositories;

import com.jeido.film.entities.Film;
import com.jeido.film.entities.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IFilmRepository extends CrudRepository<Film, UUID> {
    List<Film> findByDirector(Director director);

    boolean existsByName(String name);
}
