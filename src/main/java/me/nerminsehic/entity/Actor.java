package me.nerminsehic.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Actor(
        @JsonProperty("id") Long id,
        @JsonProperty("name") String name
) {}
