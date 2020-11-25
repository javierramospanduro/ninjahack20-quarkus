package org.bbva;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class kidsbankingappTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/kidsbankingapp")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}