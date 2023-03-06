package com.example.etr407.controller;

import com.example.etr407.domain.Toll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainRestControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void getOne() throws Exception {
        Toll qewToll = new Toll();
        qewToll.setId(Long.valueOf(1));
        qewToll.setName("QEW");



        assertThat(this.restTemplate.getForObject("http://localhost:8080/toll/1",
                Toll.class)).isEqualTo(qewToll);

    }
}