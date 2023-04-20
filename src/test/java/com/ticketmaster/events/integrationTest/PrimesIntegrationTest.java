package com.ticketmaster.events.integrationTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * integration test cases
 * Testcases for all valid and invalid input number
 * Test cases for Objective 1 --> REST API service to calculate and returns all the prime numbers up to and including a valid input number provided.
 * Test Cases for Objective 2 --->REST API service will throw custom ResponseEntity message for invalid input number like 1,0, negative integers
 *
 * @author divyavenkatesh
 * @date 21/03/2023
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PrimesIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void testGetPrimesForNumberTen() throws Exception {
        //given
        String requestUrl = "/artists/24";

        //when
        mockMvc.perform(MockMvcRequestBuilders.get(requestUrl))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Events", hasSize(5)))
                .andExpect(jsonPath("$.Artist").isNotEmpty())
                .andExpect(jsonPath("$.Artist.id", equalTo("24")))
                .andExpect(jsonPath("$.Artist.name", equalTo("The Enid")))
                .andExpect(jsonPath("$.Events[0].id", equalTo("3")))
                .andExpect(jsonPath("$.Events[0].title", equalTo("Jazz Live")))
                .andExpect(jsonPath("$.Events[0].dateStatus", equalTo("singleDate")))
                .andExpect(jsonPath("$.Events[0].artists", hasSize(3)))
                .andExpect(jsonPath("$.Events[0].venue").isNotEmpty())
                .andExpect(jsonPath("$.Events[0].hiddenFromSearch", equalTo(true)))

                .andExpect(jsonPath("$.Events[1].id", equalTo("4")))
                .andExpect(jsonPath("$.Events[1].title", equalTo("Metal Event")))
                .andExpect(jsonPath("$.Events[1].dateStatus", equalTo("multiDate")))
                .andExpect(jsonPath("$.Events[1].artists", hasSize(1)))
                .andExpect(jsonPath("$.Events[1].venue").isNotEmpty())
                .andExpect(jsonPath("$.Events[1].hiddenFromSearch", equalTo(false)))

                .andExpect(jsonPath("$.Events[2].id", equalTo("10")))
                .andExpect(jsonPath("$.Events[2].title", equalTo("An Event")))
                .andExpect(jsonPath("$.Events[2].dateStatus", equalTo("multiDate")))
                .andExpect(jsonPath("$.Events[2].artists", hasSize(1)))
                .andExpect(jsonPath("$.Events[2].venue").isNotEmpty())
                .andExpect(jsonPath("$.Events[2].hiddenFromSearch", equalTo(false)))

                .andExpect(jsonPath("$.Events[3].id", equalTo("11")))
                .andExpect(jsonPath("$.Events[3].title", equalTo("Harisson Live")))
                .andExpect(jsonPath("$.Events[3].dateStatus", equalTo("singleDate")))
                .andExpect(jsonPath("$.Events[3].artists", hasSize(3)))
                .andExpect(jsonPath("$.Events[3].venue").isNotEmpty())
                .andExpect(jsonPath("$.Events[3].hiddenFromSearch", equalTo(false)))

                .andExpect(jsonPath("$.Events[4].id", equalTo("13")))
                .andExpect(jsonPath("$.Events[4].title", equalTo("Huge Live")))
                .andExpect(jsonPath("$.Events[4].dateStatus", equalTo("multiDate")))
                .andExpect(jsonPath("$.Events[4].artists", hasSize(5)))
                .andExpect(jsonPath("$.Events[4].venue").isNotEmpty())
                .andExpect(jsonPath("$.Events[4].hiddenFromSearch", equalTo(false)));
    }

}
