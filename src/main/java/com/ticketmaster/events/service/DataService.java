package com.ticketmaster.events.service;

import com.ticketmaster.events.model.Artist;
import com.ticketmaster.events.model.Event;
import com.ticketmaster.events.model.Venue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DataService {

    List<Artist> getAllArtists() throws Exception;

    List<Event> getAllEvents() throws Exception;

    List<Venue> getAllVenues() throws Exception;
}
