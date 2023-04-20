package com.ticketmaster.events.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ticketmaster.events.controller.ArtistController;
import com.ticketmaster.events.model.Artist;
import com.ticketmaster.events.model.ArtistResponse;
import com.ticketmaster.events.model.Event;
import com.ticketmaster.events.model.Venue;
import com.ticketmaster.events.service.DataServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ArtistControllerTest {

    @Autowired
    private DataServiceImpl dataServiceImpl;

    @Autowired
    private ArtistController artistController;

    @BeforeEach
    void setUp() {
        dataServiceImpl = mock(DataServiceImpl.class);
        artistController = mock(ArtistController.class);

    }

    @Test
    void testGetArtistWithValidArtistId() throws Exception {
        String artistId = "24";

        List<Artist> artists = new ArrayList<>();
        Artist artist = new Artist();
        artist.setId("1");
        artist.setName("John Doe");
        artists.add(artist);

        List<Event> events = new ArrayList<>();
        Event event1 = new Event();
        event1.setId("1");
        event1.setArtists(artists);
        events.add(event1);

        Venue venue = new Venue();
        venue.setId("1");
        venue.setName("Venue 1");

        when(dataServiceImpl.getAllArtists()).thenReturn(artists);
        when(dataServiceImpl.getAllEvents()).thenReturn(events);
        when(dataServiceImpl.getAllVenues()).thenReturn(List.of(venue));

        ResponseEntity<ArtistResponse> responseEntity = artistController.getArtist(artistId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ArtistResponse artistResponse = responseEntity.getBody();
        assert artistResponse != null;
        Optional<Artist> optionalArtist = artistResponse.getArtist();
        List<Event> eventsByArtistId = artistResponse.getEvents();

        assertTrue(optionalArtist.isPresent());
        Artist artistResponseData = optionalArtist.get();
        assertEquals(artist, artistResponseData);

        assertEquals(1, eventsByArtistId.size());
        Event eventResponseData = eventsByArtistId.get(0);
        assertEquals(event1, eventResponseData);
    }

}
