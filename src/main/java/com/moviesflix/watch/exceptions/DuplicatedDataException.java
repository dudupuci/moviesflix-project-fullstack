package com.moviesflix.watch.exceptions;

import com.moviesflix.watch.models.MovieEntity;

import java.util.Optional;

public class DuplicatedDataException extends RuntimeException {

    public DuplicatedDataException(MovieEntity obj) {
        super("Error trying to create object ID:"+obj.getId());
    }

    // anothers
}
