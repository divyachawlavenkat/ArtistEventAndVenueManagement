package com.ticketmaster.events.model;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class Event {

    private String title;
    private String id;
    private String dateStatus;
    private String timeZone;
    private String startDate;
    private List<Artist> artists;
    private Venue venue;
    private Boolean hiddenFromSearch;

    @JsonCreator
    public Event(@JsonProperty("title") String title,
                  @JsonProperty("id") String id,
                  @JsonProperty("dateStatus") String dateStatus,
                  @JsonProperty("timeZone") String timeZone,
                  @JsonProperty("startDate") String startDate,
                  @JsonProperty("artists") List<Artist> artists,
                  @JsonProperty("venue") Venue venue,
                  @JsonProperty("hiddenFromSearch") Boolean hiddenFromSearch
                 ) {
        this.title = title;
        this.id = id;
        this.dateStatus = dateStatus;
        this.timeZone = timeZone;
        this.startDate = startDate;
        this.artists = artists;
        this.venue = venue;
        this.hiddenFromSearch = hiddenFromSearch;
    }
}
