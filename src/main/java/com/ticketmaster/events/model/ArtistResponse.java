package com.ticketmaster.events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class ArtistResponse {

    @JsonProperty("Artist")
    private final Optional<Artist> artist;
    @JsonProperty("Events")
    private final List<Event> events;
}
