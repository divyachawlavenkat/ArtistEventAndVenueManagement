package com.ticketmaster.events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

/**
 * ArtistResponse  to return artist information for a specific artistId
 * and contain all fields of given artist and all the events the artist will perform at.
 * JSON return params
 *
 * @author divyavenkatesh
 * @date 20/04/2023
 */
@Data
@AllArgsConstructor
public class ArtistResponse {

    @JsonProperty("Artist")
    private final Optional<Artist> artist;
    @JsonProperty("Events")
    private final List<Event> events;
}
