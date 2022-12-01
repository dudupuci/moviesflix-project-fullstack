package com.moviesflix.watch.controller;

import com.moviesflix.watch.dto.MovieEntityDTO;

import com.moviesflix.watch.models.MovieEntity;
import com.moviesflix.watch.services.MovieService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/movies")
@CrossOrigin("*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MovieEntity>> findAll() {
        List<MovieEntity> list = movieService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieEntity> findById(@PathVariable UID movieId) {
        MovieEntity movie = movieService.findMovieById(movieId);
        return ResponseEntity.ok().body(movie);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MovieEntity> insertMovie(@RequestBody MovieEntity newMovie) {
        movieService.insertMovie(newMovie);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newMovie.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newMovie);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MovieEntity> updateMovie(@PathVariable UID oldMovieId, @RequestBody MovieEntity newMovie) {
       MovieEntity oldMovie = movieService.findMovieById(oldMovieId);
       movieService.updateData(oldMovie, newMovie);
       movieService.updateAndSaveData(oldMovieId, newMovie);
       return ResponseEntity.ok().body(newMovie);
    }

    public ResponseEntity<Void> deleteMovieById(@PathVariable UID id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> deleteAllMovies(){
        List<MovieEntity> list = movieService.findAll();
        movieService.deleteAllMovies(list);
        return ResponseEntity.noContent().build();
    }


}
