package me.nerminsehic.dao;

import me.nerminsehic.entity.Actor;
import me.nerminsehic.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorsDaoImpl implements Actors {

    private final JdbcTemplate jdbc;

    public ActorsDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Actor> getAll() {
        String sql = """
                SELECT id, name
                FROM actor
                LIMIT 100;
                """;

        return jdbc.query(sql, new ActorRowMapper());
    }

    @Override
    public boolean persist(Actor actor) {
        String sql = """
                INSERT INTO actor (name)
                VALUES (?);
                """;

        int result = jdbc.update(sql, actor.name());

        return result == 1;
    }

    @Override
    public boolean deleteById(long id) {
        String sql = """
                DELETE FROM actor
                WHERE id = ?;
                """;

        int result = jdbc.update(sql, id);
        return result == 1;
    }

    @Override
    public boolean updateById(long id, Actor newActor) {
        Actor actor = getById(id).orElseThrow(() -> new NotFoundException(Actor.class, id));
        String sql = """
                UPDATE actor
                SET name = ?
                WHERE id = ?;
                """;

        int result = jdbc.update(sql, newActor.name(), id);
        return result == 1;
    }

    @Override
    public Optional<Actor> getById(long id) {
        String sql = """
                SELECT id, name
                FROM actor
                WHERE id = ?
                LIMIT 1;
                """;

        return jdbc.query(sql, new ActorRowMapper(), id)
                .stream()
                .findFirst();
    }
}
