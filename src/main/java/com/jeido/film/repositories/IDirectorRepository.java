package com.jeido.film.repositories;

import com.jeido.film.entities.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IDirectorRepository extends CrudRepository<Director, UUID> {

}
