# ArtistEventAndVenueManagement

Tech :

Version - Java 17
Framework - Spring Boot
Intetrgatuon and unit test cases are included 
Controller,Model,Service Interface and Service Implementation included 


Designed a RESTful API for data regarding events, venues and artists. 

Given the following endpoints:

1. `https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/events.json` -> contains data for events. It links to artists and venues via ids
2. `https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/artists.json` -> contains data for artists.
3. `https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/venues.json` -> contains data for venues

Requirements:

    Demonstrated of REST conventions
    Create route or End Point to:
        Get artist information for a specific artistId. This should contain all fields of given artist and all the events the artist will perform at.
        
        Solution Explanation:

The events collection is converted to a stream using the stream() method.
The filter() method is used to filter the events that have an artist with the specified artistId. The anyMatch() method is used to check if any of the artists in the event's artists list has an id equal to the artistId.
The filtered events are added to the eventsByArtistId list using the forEach() method and the method reference eventsByArtistId::add.


To convert the response body into a List of Artists, you will need to first parse the JSON string using a JSON parser such as Jackson or Gson. Here's an example using Jackson:

Add the Jackson dependency to your project. For Maven, add the following to your pom.xml:
php
Copy code
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.0</version>
</dependency>

Used HttpClient to fetch data from artistsEndpoint and convert to List<Artist>

  // Use HttpClient to fetch data from artistsEndpoint and convert to List<Artist>
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(eventsEndpoint))
            .GET()
            .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    // Parse JSON string into a List of Artists using Jackson
    ObjectMapper mapper = new ObjectMapper();
    List<Artist> artists = mapper.readValue(response.body(), new TypeReference<List<Artist>>(){});

    return artists;
    
    
    Note that in the above code, ObjectMapper is used to parse the JSON string into a List of Artists. 
    The readValue() method is used to deserialize the JSON string into a Java object of the specified type, in this case, a List of Artists. 
    The TypeReference class is used to specify the generic type of the List.
    
    To run and test please use your local host server like below attached 
    
    Sample End Point - GET request :
    http://localhost:8080/artists/24
    
    24 is a path variable {artistId} this end point will return rtist information for a specific artistId. 
    This should contain all fields of given artist and all the events the artist will perform at.
    
    <img width="1017" alt="Screenshot 2023-04-20 at 11 11 59" src="https://user-images.githubusercontent.com/16776911/233335765-f0587e9b-097d-4a0d-8df7-93a8a08c565a.png">


Please find the below sample json response bosy which contain artist information for a specific artistId. 
    This should contain all fields of given artist and all the events the artist will perform at.
    
    
    {
    "Artist": {
        "name": "The Enid",
        "id": "24",
        "imgSrc": "//some-base-url/the-enid.jpg",
        "url": "/the-enid-tickets/artist/24",
        "rank": 4
    },
    "Events": [
        {
            "title": "Jazz Live",
            "id": "3",
            "dateStatus": "singleDate",
            "timeZone": null,
            "startDate": null,
            "artists": [
                {
                    "name": null,
                    "id": "24",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                },
                {
                    "name": null,
                    "id": "28",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                },
                {
                    "name": null,
                    "id": "29",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                }
            ],
            "venue": {
                "name": null,
                "url": null,
                "city": null,
                "id": "43"
            },
            "hiddenFromSearch": true
        },
        {
            "title": "Metal Event",
            "id": "4",
            "dateStatus": "multiDate",
            "timeZone": null,
            "startDate": null,
            "artists": [
                {
                    "name": null,
                    "id": "24",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                }
            ],
            "venue": {
                "name": null,
                "url": null,
                "city": null,
                "id": "44"
            },
            "hiddenFromSearch": false
        },
        {
            "title": "An Event",
            "id": "10",
            "dateStatus": "multiDate",
            "timeZone": null,
            "startDate": null,
            "artists": [
                {
                    "name": null,
                    "id": "24",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                }
            ],
            "venue": {
                "name": null,
                "url": null,
                "city": null,
                "id": "42"
            },
            "hiddenFromSearch": false
        },
        {
            "title": "Harisson Live",
            "id": "11",
            "dateStatus": "singleDate",
            "timeZone": null,
            "startDate": null,
            "artists": [
                {
                    "name": null,
                    "id": "22",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                },
                {
                    "name": null,
                    "id": "23",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                },
                {
                    "name": null,
                    "id": "24",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                }
            ],
            "venue": {
                "name": null,
                "url": null,
                "city": null,
                "id": "44"
            },
            "hiddenFromSearch": false
        },
        {
            "title": "Huge Live",
            "id": "13",
            "dateStatus": "multiDate",
            "timeZone": null,
            "startDate": null,
            "artists": [
                {
                    "name": null,
                    "id": "21",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                },
                {
                    "name": null,
                    "id": "22",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                },
                {
                    "name": null,
                    "id": "24",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                },
                {
                    "name": null,
                    "id": "28",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                },
                {
                    "name": null,
                    "id": "29",
                    "imgSrc": null,
                    "url": null,
                    "rank": 0
                }
            ],
            "venue": {
                "name": null,
                "url": null,
                "city": null,
                "id": "41"
            },
            "hiddenFromSearch": false
        }
    ]
}
