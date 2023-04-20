package com.ticketmaster.events.unitTest;

import static org.junit.jupiter.api.Assertions.*;


import java.util.*;

import com.ticketmaster.events.model.Artist;
import com.ticketmaster.events.model.Event;
import com.ticketmaster.events.service.DataServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ArtistControllerTest {

    private DataServiceImpl dataServiceImpl;

    @BeforeEach
    public void setUp() {
        dataServiceImpl = new DataServiceImpl();
    }

    @Test
    public void testGetEventsForArtistAvailable() throws Exception {
        //given
        String inputNumberToCheckPrimes = "24";
        assertDoesNotThrow(() -> {
            //when
            List<Event> response = dataServiceImpl.getEventsForArtist(inputNumberToCheckPrimes);

            //then
            assertNotNull(response);
            assertEquals(5, response.size());
        });
    }

    @Test
    public void testGetEventsForArtistUnAvailable() throws Exception {
        //given
        String inputNumberToCheckPrimes = "2";

        //when
        assertDoesNotThrow(() -> {
            List<Event> response = dataServiceImpl.getEventsForArtist(inputNumberToCheckPrimes);

            //then
            assertNotNull(response);
            assertEquals(0, response.size());
            assertEquals(response, Collections.emptyList());
        });
    }

    @Test
    public void testGetEventsForArtistAvailableTwo() throws Exception {
        //given
        String inputNumberToCheckPrimes = "25";

        //when
        assertDoesNotThrow(() -> {
            List<Event> response = dataServiceImpl.getEventsForArtist(inputNumberToCheckPrimes);

            //then
            assertNotNull(response);
            assertEquals(2, response.size());
        });

    }

    @Test
    public void testGetEventsForArtistAvailableTwentySix() throws Exception {
        //given
        String inputNumberToCheckPrimes = "26";

        //when
        assertDoesNotThrow(() -> {
            List<Event> response = dataServiceImpl.getEventsForArtist(inputNumberToCheckPrimes);

            //then
            assertNotNull(response);
            assertEquals(2, response.size());
        });

    }


    @Test
    public void testGetArtistAvailable() throws Exception {
        //given
        String inputNumberToCheckPrimes = "24";

        assertDoesNotThrow(() -> {
            //when
           Optional<Artist> response = dataServiceImpl.getArtist(inputNumberToCheckPrimes);

            //then
            assertNotNull(response);
        });
    }


    @Test
    public void testGetAllArtistAvailable() throws Exception {

        assertDoesNotThrow(() -> {
            //when
            List<Artist> response = dataServiceImpl.getAllArtists();

            //then
            assertNotNull(response);
        });
    }


    @Test
    public void testGetAllEventsAvailable() throws Exception {

        assertDoesNotThrow(() -> {
            //when
            List<Event> response = dataServiceImpl.getAllEvents();

            //then
            assertNotNull(response);
        });
    }



}
