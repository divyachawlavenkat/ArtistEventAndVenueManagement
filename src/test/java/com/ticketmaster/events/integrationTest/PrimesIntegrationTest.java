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
                .andExpect(jsonPath("$.Events[0].title", equalTo("Jazz Live")));
    }

}
