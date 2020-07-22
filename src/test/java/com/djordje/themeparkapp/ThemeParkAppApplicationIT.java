package com.djordje.themeparkapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ThemeParkAppApplicationIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllRides() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    void getSingleRide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    void returnsNotFoundForInvalidSingleRide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/4")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }


    @Test
    void addsNewRide() throws Exception {
        String newRide = "{\"name\":\"Monorail\",\"description\":\"Sedate traveling ride.\",\"thrillFactor\":2,\"vomitFactor\":3}";
        mockMvc.perform(MockMvcRequestBuilders.post("/ride")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newRide)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}