package me.nerminsehic.dao;


import me.nerminsehic.entity.Actor;
import me.nerminsehic.entity.Movie;
import me.nerminsehic.entity.MovieActor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieActorRowMapper implements RowMapper<MovieActor> {

    @Override
    public MovieActor mapRow(ResultSet resultSet, int i) throws SQLException {
        Actor actor = null;

        if (resultSet.getLong("actor_id") != 0) {
            actor = new Actor(
                    resultSet.getLong("actor_id"),
                    resultSet.getString("actor_name")
            );
        }

        Movie movie = new Movie(
                resultSet.getLong("movie_id"),
                resultSet.getString("movie_name"),
                new ArrayList<>(),
                resultSet.getDate("movie_release_date").toLocalDate()
        );

        return new MovieActor(actor, movie);
    }
}
