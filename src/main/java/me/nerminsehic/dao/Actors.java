package me.nerminsehic.dao;

import me.nerminsehic.entity.Actor;

import java.util.List;
import java.util.Optional;

public interface Actors {
    List<Actor> getAll();

    boolean persist(Actor actor);

    boolean deleteById(long id);

    boolean updateById(long id, Actor actor);

    Optional<Actor> getById(long id);
}


