package com.movies.netflix.services;

import com.movies.netflix.exceptions.EntityNotFoundException;
import com.movies.netflix.models.MovieEntity;
import com.movies.netflix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieEntity> findAll() {
        return movieRepository.findAll();
    }

    public MovieEntity findbyId(UID id) {
        MovieEntity movie = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ENTITY_NOT_FOUND"));
        return movie;
    }

    public MovieEntity insertMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }
}
