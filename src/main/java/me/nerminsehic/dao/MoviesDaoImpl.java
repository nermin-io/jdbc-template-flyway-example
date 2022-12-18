package me.nerminsehic.dao;

import me.nerminsehic.entity.Movie;
import me.nerminsehic.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MoviesDaoImpl implements Movies {

    private final JdbcTemplate jdbc;

    public MoviesDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Movie> getAll() {
        String sql = """
                SELECT id, name, release_date
                FROM movie
                LIMIT 100;
                """;

        return jdbc.query(sql, new MovieRowMapper());
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
