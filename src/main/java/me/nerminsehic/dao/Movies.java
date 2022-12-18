package me.nerminsehic.dao;

import me.nerminsehic.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface Movies {
    List<Movie> getAll();

    boolean persist(Movie movie);

    boolean deleteById(long id);

    boolean updateMovieById(long id, Movie movie);

    Optional<Movie> getById(long id);
}
