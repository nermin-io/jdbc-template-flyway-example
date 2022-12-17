package me.nerminsehic.service;

import me.nerminsehic.dao.Movies;
import me.nerminsehic.entity.Movie;
import me.nerminsehic.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final Movies movies;

    public MovieService(Movies movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies.getAll();
    }

    public void addNewMovie(Movie movie) {
        // TODO: check if movie exists
        int result = movies.persist(movie);
        if (result != 1)
            throw new IllegalStateException("oops something went wrong");
    }

    public void deleteMovie(Integer id) {
        Optional<Movie> movieOptional = movies.getById(id);
        movieOptional.ifPresentOrElse(movie -> {
            int result = movies.deleteById(id);
            if (result != 1)
                throw new IllegalStateException("oops could not delete movie");
        }, () -> {
            throw new NotFoundException(String.format("Movie with id %s not found", id));
        });
    }

    public Movie getMovie(int id) {
        return movies.getById(id)
                .orElseThrow(() -> new NotFoundException(Movie.class, id));
    }
}
