package me.nerminsehic.dao;

import me.nerminsehic.entity.Movie;
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
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public int persist(Movie movie) {
        String sql = """
                INSERT INTO movie(name, release_date)
                VALUES (?, ?)
                """;
        return jdbc.update(sql, movie.name(), movie.releaseDate());
    }

    @Override
    public int deleteById(int id) {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public Optional<Movie> getById(int id) {
        throw new UnsupportedOperationException("not implemented");
    }
    
}
