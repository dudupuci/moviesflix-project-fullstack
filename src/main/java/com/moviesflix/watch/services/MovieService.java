package com.moviesflix.watch.services;

import com.moviesflix.watch.exceptions.*;
import com.moviesflix.watch.models.MovieEntity;
import com.moviesflix.watch.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService implements Serializable {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieEntity> findAll() {
        return movieRepository.findAll();
    }

    public MovieEntity findMovieById(UID id) {
       return movieRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("ENTITY_NOT_FOUND"));
    }

    public MovieEntity insertMovie(MovieEntity newMovie) {
        try {
           return movieRepository.save(newMovie);
        } catch (Exception err) {
            throw new DuplicatedDataException(newMovie);
        }
    }

    public void deleteMovieById(UID id) {
        try {
            movieRepository.deleteById(id);
        } catch (Exception err) {
            throw new EntityNotFoundException("ENTITY_NOT_FOUND");
        }
    }

    public void deleteAllMovies(List<MovieEntity> list) {
        movieRepository.deleteAll(list);
    }

    public void updateData(MovieEntity oldMovie, MovieEntity newMovie) {
        oldMovie.setId(newMovie.getId());
        oldMovie.setName(newMovie.getName());
        oldMovie.setDuration(newMovie.getDuration());
        oldMovie.setDescription(newMovie.getDescription());
        oldMovie.setDirector(newMovie.getDirector());
        oldMovie.setMainAuthors(newMovie.getMainAuthors());
        oldMovie.setProductionDate(newMovie.getProductionDate());
        oldMovie.setReleaseDateOf(newMovie.getReleaseDateOf());
        oldMovie.setSceneryCountries(newMovie.getSceneryCountries());
        oldMovie.setParentalRating(newMovie.getParentalRating());
        oldMovie.setGenre(newMovie.getGenre());
    }

    public MovieEntity updateAndSaveData(UID id, MovieEntity newMovie) {
        try {
            MovieEntity oldMovie = movieRepository.findById(id).get();
            updateData(oldMovie, newMovie);
            updateAndSaveData(oldMovie.getId(), newMovie);
            return movieRepository.save(newMovie);
        } catch (Exception err) {
           throw new UpdateDataException(newMovie);
        }
    }
}
