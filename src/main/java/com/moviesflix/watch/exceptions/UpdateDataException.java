package com.moviesflix.watch.exceptions;

import com.moviesflix.watch.models.MovieEntity;

public class UpdateDataException extends RuntimeException {

    public UpdateDataException(MovieEntity obj) {
        super("Error trying to update data! ID: "+obj.getId());
    }
}
