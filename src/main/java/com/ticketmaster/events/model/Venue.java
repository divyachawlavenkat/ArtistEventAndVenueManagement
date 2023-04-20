package com.ticketmaster.events.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Venue {
    private String name;
    private String url;
    private String city;
    private String id;

    @JsonCreator
    public Venue(@JsonProperty("name") String name,
                  @JsonProperty("url") String url,
                  @JsonProperty("city") String city,
                  @JsonProperty("id") String id) {
        this.name = name;
        this.url = url;
        this.city = city;
        this.id = id;

    }
}
