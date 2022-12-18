package me.nerminsehic.dao;

import me.nerminsehic.entity.Actor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorRowMapper implements RowMapper<Actor> {

    @Override
    public Actor mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Actor(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
    }
}
