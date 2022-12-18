package me.nerminsehic.service;

import me.nerminsehic.dao.Movies;
import me.nerminsehic.entity.Movie;
import me.nerminsehic.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final Movies movies;

    public MovieService(Movies movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies.getAll();
    }

    public void createMovie(Movie movie) {
        boolean persisted = movies.persist(movie);
        if(!persisted)
            throw new RuntimeException("Something went wrong. Please try again later.");
    }

    public void deleteMovie(long id) {
        Movie movie = movies.getById(id).orElseThrow(() -> new NotFoundException(Movie.class, id));
        boolean deleted = movies.deleteById(id);
        if(!deleted)
            throw new RuntimeException("Something went wrong. Please try again later.");
    }

    public Movie getMovie(long id) {
        return movies.getById(id)
                .orElseThrow(() -> new NotFoundException(Movie.class, id));
    }

    public Movie updateMovie(long id, Movie movie) {
        boolean updated = movies.updateMovieById(id, movie);
        if(updated) return movie;

        throw new RuntimeException("Something went wrong. Please try again later.");
    }
}
