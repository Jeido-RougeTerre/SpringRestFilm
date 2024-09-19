package com.jeido.film.services;

import com.jeido.film.dto.DirectorDtoReceive;
import com.jeido.film.entities.Director;
import com.jeido.film.repositories.IDirectorRepository;
import com.jeido.film.repositories.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DirectorService {
    private final IDirectorRepository directorRepository;

    @Autowired
    public DirectorService(IDirectorRepository directorRepository) {

        this.directorRepository = directorRepository;
    }

    //CREATE
    public Director save(DirectorDtoReceive directorDtoReceive) {
        Director director = Director.builder()
                .lastName(directorDtoReceive.getLastName())
                .firstName(directorDtoReceive.getFirstName())
                .birthDate(directorDtoReceive.getBirthDate())
                .nationality(directorDtoReceive.getNationality())
                .build();
        return directorRepository.save(director);
    }

    //READ
    public Director findById(UUID id) {
        return directorRepository.findById(id).orElseThrow();
    }

    public List<Director> findAll() {
        return (List<Director>) directorRepository.findAll();
    }

    //UPDATE
    public Director update(DirectorDtoReceive directorDtoReceive) {
        return save(directorDtoReceive);
    }

    //DELETE
    public void delete(Director director) {
        directorRepository.delete(director);
    }

    public void delete(UUID id) {
        directorRepository.deleteById(id);
    }
}
