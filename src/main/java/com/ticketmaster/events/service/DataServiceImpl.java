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
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    private final String eventsEndpoint = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/events.json";
    private final String artistsEndpoint = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/artists.json";
    private final String venuesEndpoint = "https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/venues.json";



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


}
