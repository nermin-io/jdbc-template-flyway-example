package me.nerminsehic.dao;

import me.nerminsehic.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface Movies {
    List<Movie> getAll();

    int persist(Movie movie);

    int deleteById(int id);

    Optional<Movie> getById(int id);
}
