package es.unizar.murcy.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld() throws Exception {
        mockMvc.perform(get("/test")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("Hello world"));
    }
}