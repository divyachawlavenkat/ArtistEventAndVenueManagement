package com.ticketmaster.events.controller;


import com.ticketmaster.events.model.Artist;
import com.ticketmaster.events.model.ArtistResponse;
import com.ticketmaster.events.model.Event;
import com.ticketmaster.events.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ArtistController {

    @Autowired
    DataServiceImpl dataServiceImpl;

    // Endpoint to get artist information for a specific artistId
    // and contain all fields of given artist and all the events the artist will perform at.
    @GetMapping("/artists/{artistId}")
    public ResponseEntity<ArtistResponse> getArtist(@PathVariable String artistId) throws Exception {
        try {
            // fetch artists data
            List<Artist> artists = dataServiceImpl.getAllArtists();

            // find artist by id
            Optional<Artist> artist = artists.stream()
                    .filter(a -> a.getId().equals(artistId))
                    .findFirst();

            List<Event> eventsByArtistId = new ArrayList<>();
            if (artist.isPresent()) {
                // fetch events data
                List<Event> events = dataServiceImpl.getAllEvents();

                // get events for the artist
                events.stream()
                        .filter(event -> event.getArtists().stream()
                                .anyMatch(art -> art.getId().equals(artistId)))
                        .forEach(eventsByArtistId::add);
            }
            return new ResponseEntity<>(new ArtistResponse(artist, eventsByArtistId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


