package org.bbva;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class kidsbankingappTest {

    @Test
    public void testLogin() {
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .queryParams("user", "padre1", "password","password")
         .when()
         .post("/kids-banking-app/login")
         .then()
             .statusCode(200);
    }
    @Test
    public void testLoginKO() {
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .queryParams("user", "patata", "password","pascual")
         .when()
         .post("/kids-banking-app/login")
         .then()
             .statusCode(500);
    }
    @Test
    public void testGetPadres() {
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .when()
        .get("/kids-banking-app/padres/12345")
        .then()
             .statusCode(200);
    }
    @Test
    public void testGetPadresNoExiste() {
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .when()
        .get("/kids-banking-app/padres/adfaf")
        .then()
             .statusCode(204);
    }
}