package me.nerminsehic.controller;

import me.nerminsehic.entity.Movie;
import me.nerminsehic.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> listMovies() {
        return movieService.getMovies();
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void createMovie(@RequestBody Movie movie) {
        movieService.createMovie(movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @PutMapping("{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

}
