CREATE TABLE actor (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    unique (name)
);

CREATE TABLE movie_actor (
    movie_id BIGINT REFERENCES movie(id),
    actor_id BIGINT REFERENCES actor(id),
    PRIMARY KEY (movie_id, actor_id)
);