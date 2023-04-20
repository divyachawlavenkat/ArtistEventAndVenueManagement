package com.ticketmaster.events.service;

import com.ticketmaster.events.model.Artist;
import com.ticketmaster.events.model.Event;
import com.ticketmaster.events.model.Venue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Data service Interface to declare methods without implementation.
 * Reason Default methods in interfaces allow new methods to be added to an interface without breaking existing code that implements that interface.
 *
 * @author Divya Venkatesh
 * @author Divya Venkatesh
 * @date 21/03/2023
 */
@Service
public interface DataService {

    List<Artist> getAllArtists() throws Exception;

    List<Event> getAllEvents() throws Exception;

    List<Venue> getAllVenues() throws Exception;

    Optional<Artist> getArtist(String artistId) throws Exception;

    List<Event> getEventsForArtist(String artistId) throws Exception;
}
