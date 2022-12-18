package me.nerminsehic.dao;

import me.nerminsehic.entity.Actor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorsDaoImpl implements Actors {

    @Override
    public List<Actor> getAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean persist(Actor actor) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean deleteById(long id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean updateById(long id, Actor actor) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<Actor> getById(long id) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
