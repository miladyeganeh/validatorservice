package com.company.validator.controller;

import com.company.validator.model.request.RequestDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class RequestHandlerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private Gson gson;
    private static String VALID_URL = "/api/v1/requests";

    @BeforeEach
    void prepare() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        gson = new GsonBuilder()
                .serializeNulls()
                .create();
    }

    @Test
    public void success_post_request_getRateWithBaseAndTarget() throws Exception {
        RequestDTO requestDTO = createRequestDTO();
        this.mockMvc
                .perform(post(VALID_URL)
                        .flashAttr("requestDTO", requestDTO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                )
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();
        System.out.println("");
    }

    private RequestDTO createRequestDTO(){
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setCustomerID(1L);
        requestDTO.setTagID(2);
        requestDTO.setUserID("aaaaaaaa-bbbb-cccc-1111-222222222222");
        requestDTO.setRemoteIP("123.234.56.78");
        requestDTO.setTimestamp(1500000000L);
        return requestDTO;
    }
}