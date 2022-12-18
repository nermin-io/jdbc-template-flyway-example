package me.nerminsehic.service;

import me.nerminsehic.dao.Actors;
import me.nerminsehic.entity.Actor;
import me.nerminsehic.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final Actors actors;

    public ActorService(Actors actors) {
        this.actors = actors;
    }

    public List<Actor> getActors() {
        return actors.getAll();
    }

    public void createActor(Actor actor) {
        boolean created = actors.persist(actor);
        if(!created)
            throw new RuntimeException("Something went wrong. Please try again later.");
    }

    public void deleteActorById(long id) {
        Actor actor = actors.getById(id).orElseThrow(() -> new NotFoundException(Actor.class, id));
        boolean deleted = actors.deleteById(id);
        if(!deleted)
            throw new RuntimeException("Something went wrong. Please try again later.");
    }

    public Actor getActorById(long id) {
        return actors.getById(id)
                .orElseThrow(() -> new NotFoundException(Actor.class, id));
    }

    public Actor updateActorById(long id, Actor actor) {
        boolean updated = actors.updateById(id, actor);
        if(updated) return actor;

        throw new RuntimeException("Something went wrong. Please try again later.");
    }
}
