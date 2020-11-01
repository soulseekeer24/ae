//package com.example.agileengine.client;
//
//import com.example.agileengine.dto.AgileImageRequestDTO;
//import com.example.agileengine.model.AgileImage;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@SpringBootTest
//class BasicAgileEngineImagesClientTest {
//
//    @Autowired
//    BasicAgileEngineImagesClient basicAgileEngineImagesClient;
//
//
//    @BeforeAll
//    public void setUp() {
//        basicAgileEngineImagesClient.authenticate();
//    }
//
//    @Test
//    @DisplayName("Should fetch a page of agile engine image api")
//    public void testA() {
//        Optional<AgileImageRequestDTO> agileImageRequestDTO = basicAgileEngineImagesClient.fetchImage(1);
//        assertThat(agileImageRequestDTO.get().isHasMore()).isTrue();
//    }
//
//    @Test
//    @DisplayName("Should fetch a concrete image from the API")
//    public void testB() {
//        Optional<AgileImage> agileImageResponse = basicAgileEngineImagesClient.getImageDetail("1a5e86953ad5ac438130");
//        assertThat(agileImageResponse.isPresent()).isTrue();
//        agileImageResponse.ifPresent(agileImage -> {
//            assertThat(agileImage.getId()).isEqualTo("1a5e86953ad5ac438130");
//            assertThat(agileImage.getAuthor()).isNotEmpty();
//            assertThat(agileImage.getCamera()).isNotEmpty();
//            assertThat(agileImage.getCropped_picture()).isNotEmpty();
//            assertThat(agileImage.getFull_picture()).isNotEmpty();
//            assertThat(agileImage.getTags()).isNotEmpty();
//
//        });
//
//    }
//
//}