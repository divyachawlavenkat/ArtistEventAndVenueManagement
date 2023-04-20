//package com.ticketmaster.events.integrationTest;
//
//
//import com.ticketmaster.events.model.Artist;
//import com.ticketmaster.events.service.DataService;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.hamcrest.Matchers.containsInAnyOrder;
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import java.util.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ArtistControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DataService dataService;
//
//    @Test
//    public void testGetArtist() throws Exception {
//        String artistId = "1";
//        List<Artist> artists = new ArrayList<>();
////        Artist artist = new Artist("1", "John");
////        artists.add(artist);
////        List<Event> events = new ArrayList<>();
////        Event event = new Event("1", "Concert", LocalDateTime.now());
////        event.setArtists(Collections.singletonList(artist));
////        events.add(event);
//
////        given(dataService.getAllArtists()).willReturn(artists);
////        given(dataService.getAllEvents()).willReturn(events);
////        given(dataService.getAllVenues()).willReturn(Collections.emptyList());
//
//        mockMvc.perform(get("/artists/{artistId}", artistId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.Artist.id", equalTo(artistId)))
//                .andExpect(jsonPath("$.Artist.name", equalTo("John")))
//                .andExpect(jsonPath("$.Events[0].id", equalTo("1")))
//                .andExpect(jsonPath("$.Events[0].name", equalTo("Concert")));
//    }
//}
