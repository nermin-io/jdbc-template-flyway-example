package me.nerminsehic.dao;

import me.nerminsehic.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;


public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Movie(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                Collections.emptyList(),
                resultSet.getDate("release_date").toLocalDate()
        );
    }
}
