package me.nerminsehic.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record Movie(
        @JsonProperty("id") Long id,
        @JsonProperty("name") String name,
        @JsonProperty("actors") List<Actor> actors,
        @JsonProperty("release_date") LocalDate releaseDate
) {
    public void addActor(Actor actor) {
        this.actors.add(actor);
    }
}
