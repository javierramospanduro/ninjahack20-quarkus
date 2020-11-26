package org.bbva;

import static io.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;

import org.bbva.kidsbankingapp.dto.Padre;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class kidsbankingappTest {
	
	PodamFactory factory = new PodamFactoryImpl();
	
    @Test
    public void testGetPadre() {
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .queryParams("userid", "PADRE1", "password","PASSWORD")
         .when()
         .post("/kids-banking-app/login")
         .then()
             .statusCode(200);
    }
    @Test
    public void testPostPadre() {
    	Padre padre = factory.manufacturePojo(Padre.class);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(padre)
         .when()
         .post("/kids-banking-app/padres")
         .then()
             .statusCode(200);
    }

}