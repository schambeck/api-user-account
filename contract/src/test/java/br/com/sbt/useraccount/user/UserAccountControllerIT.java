package br.com.sbt.useraccount.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.mockMvc;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = UserAccountController.class)
class UserAccountControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserAccountService service;

    @BeforeEach
    void setUp() {
        mockMvc(mvc);
    }

    @Test
    void create() {
        UserAccount toCreate = UserAccount.builder()
            .username("user01")
            .build();
        UserAccount created = UserAccount.builder()
            .username("user01")
            .build();
        when(service.create(toCreate)).thenReturn(created);

        UserAccountRequestWeb payload = UserAccountRequestWeb.builder()
            .username("user01")
            .build();
        given().
                contentType(JSON).
                body(payload).
        when().
                post("/users").
        then().
                statusCode(200).
                body("username", is("user01"));
    }

}