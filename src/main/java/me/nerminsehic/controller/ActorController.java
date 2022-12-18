package me.nerminsehic.controller;

import me.nerminsehic.entity.Actor;
import me.nerminsehic.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> listActors() {
        return actorService.getActors();
    }

    @GetMapping("{id}")
    public Actor getById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public void createActor(@RequestBody Actor actor) {
        actorService.createActor(actor);
    }

    @DeleteMapping("{id}")
    public void deleteActor(@PathVariable Long id) {
        actorService.deleteActorById(id);
    }

    @PutMapping("{id}")
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor actor) {
        return actorService.updateActorById(id, actor);
    }

}