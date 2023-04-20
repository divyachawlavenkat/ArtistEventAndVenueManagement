package com.ticketmaster.events.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Artist model
 * JSON return params
 *
 * @author divyavenkatesh
 * @date 20/04/2023
 */

@Data
@NoArgsConstructor
public class Artist {

    private String name;
    private String id;
    private String imgSrc;
    private String url;
    private int rank;
    @JsonCreator
    public Artist(@JsonProperty("name") String name,
                  @JsonProperty("id") String id,
                  @JsonProperty("imgSrc") String imgSrc,
                  @JsonProperty("url") String url,
                  @JsonProperty("rank") int rank) {
        this.name = name;
        this.id = id;
        this.imgSrc = imgSrc;
        this.url = url;
        this.rank = rank;
    }


}
