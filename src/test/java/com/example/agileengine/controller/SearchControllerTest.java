//package com.example.agileengine.controller;
//
//
//import com.example.agileengine.dto.SearchResultDTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class SearchControllerTest {
//
//    @LocalServerPort
//    private int port;
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void greetingShouldReturnDefaultMessage() throws Exception {
//        Map<String, Object> params = new HashMap<>();
//        params.put("author", "Agile Engine");
//        params.put("camera", "Xiaomi Pro 8");
//        params.put("tags", "#test");
//        SearchResultDTO result = this.restTemplate.getForObject("http://localhost:" + port + "/search", SearchResultDTO.class);
//
//        assertThat(result.getImages().size()).isEqualTo(3);
//    }
//}
