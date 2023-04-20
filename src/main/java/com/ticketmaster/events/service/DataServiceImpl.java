package com.ticketmaster.events.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketmaster.events.model.Artist;
import com.ticketmaster.events.model.Event;
import com.ticketmaster.events.model.Venue;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *  data service implementation
 * @author divyavenkatesh
 * @date 20/04/2023
 *
 */
@Service
public class DataServiceImpl implements DataService {
    private final String eventsEndpoint = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/events.json";
    private final String artistsEndpoint = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/artists.json";
    private final String venuesEndpoint = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/venues.json";


    /**
     * Get all artists data from S3
     *
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    @Override
    public List<Artist> getAllArtists() throws Exception {
        // Use HttpClient to fetch data from artistsEndpoint and convert to List<Artist>
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(artistsEndpoint))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Artist> artists = objectMapper.readValue(response.body(), new TypeReference<>() {
        });

        return artists;
    }

    /**
     * Get all events data from S3
     *
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    @Override
    public List<Event> getAllEvents() throws Exception{
        // Use HttpClient to fetch data from eventsEndpoint and convert to List<Event>
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(eventsEndpoint))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the response body into a List<Artist> using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        List<Event> events = objectMapper.readValue(response.body(), new TypeReference<>() {});

        return events;
    }

    /**
     * Get all venues data from S3
     *
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    @Override
    public List<Venue> getAllVenues() throws Exception{
        // Use HttpClient to fetch data from venuesEndpoint and convert to List<Venue>
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(venuesEndpoint))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the response body into a List<Artist> using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        List<Venue> venues = objectMapper.readValue(response.body(), new TypeReference<>() {});

        return venues;
    }

    /**
     * Get Artist data by artistId
     *
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    @Override
    public Optional<Artist> getArtist(String artistId) throws Exception {
        // find artist by id
        Optional<Artist> artist = getAllArtists().stream()
                .filter(a -> a.getId().equals(artistId))
                .findFirst();
        return artist;
    }

    /**
     * Get Events data for specific artistId
     *
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    @Override
    public List<Event> getEventsForArtist(String artistId) throws Exception {
        List<Event> eventsByArtist = new ArrayList<>();
        // get events for the artist
        getAllEvents().stream()
                .filter(event -> event.getArtists().stream()
                        .anyMatch(art -> art.getId().equals(artistId)))
                .forEach(eventsByArtist::add);
        return eventsByArtist;
    }


}
