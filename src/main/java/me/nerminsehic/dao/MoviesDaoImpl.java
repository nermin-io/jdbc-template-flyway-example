package me.nerminsehic.dao;

import me.nerminsehic.entity.Movie;
import me.nerminsehic.entity.MovieActor;
import me.nerminsehic.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MoviesDaoImpl implements Movies {

    private final JdbcTemplate jdbc;

    public MoviesDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Movie> getAll() {
        String sql = """
                SELECT movie.id AS movie_id, movie.name AS movie_name, movie.release_date AS movie_release_date, actor.id AS actor_id, actor.name AS actor_name
                FROM movie
                LEFT JOIN movie_actor ON movie_actor.movie_id = movie.id
                FULL JOIN actor ON actor.id = movie_actor.actor_id;
                """;

        Map<Movie, List<MovieActor>> result = jdbc.query(sql, new MovieActorRowMapper())
                .stream()
                .collect(Collectors.groupingBy(MovieActor::movie));

        Set<Movie> movies = result.keySet();

        movies.forEach(movie -> {
           result.get(movie)
                   .stream()
                   .map(MovieActor::actor)
                   .filter(Objects::nonNull)
                   .forEach(movie::addActor);
        });

        return movies.stream().toList();
    }

    @Override
    public boolean persist(Movie movie) {
        String sql = """
                INSERT INTO movie(name, release_date)
                VALUES (?, ?)
                """;
        int result = jdbc.update(sql, movie.name(), movie.releaseDate());
        return result == 1;
    }

    @Override
    public boolean deleteById(long id) {
        String sql = """
                DELETE FROM movie
                WHERE id = ?
                """;
        int result = jdbc.update(sql, id);
        return result == 1;
    }

    @Override
    public Optional<Movie> getById(long id) {
        String sql = """
                SELECT id, name, release_date
                FROM movie
                WHERE id = ?
                LIMIT 1;
                """;

        return jdbc.query(sql, new MovieRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public boolean updateMovieById(long id, Movie newMovie) {
        Movie movie = getById(id).orElseThrow(() -> new NotFoundException(Movie.class, id));
        String sql = """
                UPDATE movie
                SET name = ?,
                    release_date = ?
                WHERE id = ?;
                """;

        int result = jdbc.update(sql, newMovie.name(), newMovie.releaseDate(), id);
        return result == 1;
    }
    
}
