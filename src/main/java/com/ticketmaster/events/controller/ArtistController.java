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

    /**
     * @GetMapping (" / artists / { artistId } ") specifies that this method will handle GET requests to /artists/{artistId},
     *  Endpoint to get artist information for a specific artistId
     *  and contain all fields of given artist and all the events the artist will perform at.
     * Spring Boot invokes that method and returns the data that is returned by the method as an HTTP response.
     * @author Divya Venkatesh
     * @date 21/03/2023
     * @see Object
     */

    @GetMapping("/artists/{artistId}")
    public ResponseEntity<ArtistResponse> getArtist(@PathVariable String artistId) throws Exception {
        try {
            // find artist by id
           Optional<Artist> artist = dataServiceImpl.getArtist(artistId);
            // get events for the artist
           List<Event> eventsByArtist = new ArrayList<>();
            if (artist.isPresent()) {
                eventsByArtist = dataServiceImpl.getEventsForArtist(artistId);
            }
            return new ResponseEntity<>(new ArtistResponse(artist, eventsByArtist), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


