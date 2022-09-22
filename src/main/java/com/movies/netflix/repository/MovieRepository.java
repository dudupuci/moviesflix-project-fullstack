package com.movies.netflix.repository;

import com.movies.netflix.models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, UID> {

}
