package com.moviesflix.watch.repository;

import com.moviesflix.watch.models.GenreEntity;
import com.moviesflix.watch.models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, UID> {

}
