package org.bbva.kidsbankingapp.facade;

import static io.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;

import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@QuarkusTest
public class BKidsBankingAppTest {
	PodamFactory factory = new PodamFactoryImpl();
    @Test
    public void testLogin() {
        given()          
          .queryParam("userid", "pepito","password","password")
          .when().get("/mocked/kidsbanking-app/login")          
          .then()
             .statusCode(500);
    }
    @Test
    public void registrarPadre() {
    	Padre padre = factory.manufacturePojo(Padre.class);
    	padre.setFechaAlta(null);
    	padre.setFechaBaja(null);
        given()        
          .contentType(MediaType.APPLICATION_JSON)
          .body(padre)          
          .when().post("/mocked/kidsbanking-app/padres");
    }
    @Test
    public void registrarHijo()  {
    	Hijo hijo = factory.manufacturePojo(Hijo.class);
    	hijo.setFechaAlta(null);
    	hijo.setFechaBaja(null);
        given()        
        .contentType(MediaType.APPLICATION_JSON)
        .body(hijo)          
        .when().post("/mocked/kidsbanking-app/padres/geppeto/hijos")
        .then()
           .statusCode(200);
    }
    @Test
    public void getPadre()  {
        given()
        .contentType(MediaType.APPLICATION_JSON)        
        .when().get("/mocked/kidsbanking-app/padres/geppeto")          
        .then()
           .statusCode(500);
    }
    @Test
    public void getHijo()  {
        given()
        .contentType(MediaType.APPLICATION_JSON)        
        .when().get("/mocked/kidsbanking-app/padres/geppeto/hijos/pinocho")          
        .then()
           .statusCode(200);
    }
    @Test
    public void getCuentas()  {
        given()
        .contentType(MediaType.APPLICATION_JSON)        
        .when().get("/mocked/kidsbanking-app/padres/geppeto/hijos/pinocho")          
        .then()
           .statusCode(200);
    }
    @Test
    public void getTarjetas()  {
        given()
        .contentType(MediaType.APPLICATION_JSON)        
        .when().get("/mocked/kidsbanking-app/padres/geppeto/hijos/pinocho")          
        .then()
           .statusCode(200);
    }
    @Test
    public void getMovimientos()  {
        given()
        .contentType(MediaType.APPLICATION_JSON)        
        .when().get("/mocked/kidsbanking-app/padres/gepetto/hijos/pinocho/cuentas/C01000001/movimientos")          
        .then()
           .statusCode(200);
    }
    @Test
    public void getProductos()  {
        given()
        .contentType(MediaType.APPLICATION_JSON)        
        .when().get("/mocked/kidsbanking-app/productos")          
        .then()
           .statusCode(200);
    }
    @Test
    public void postCompra()  {
    	Movimiento movimiento = factory.manufacturePojo(Movimiento.class);
    	given()        
        	.contentType(MediaType.APPLICATION_JSON)
        	.body(movimiento)          
        	.when().post("/mocked/kidsbanking-app/padres/geppeto/hijos/pinocho/cuentas/0123456789/movimientos/compras")
        	.then()
        		.statusCode(200);

    }
    @Test
    public void postIngreso()  {
    	Movimiento movimiento = factory.manufacturePojo(Movimiento.class);
    	movimiento.setFechaMovimiento(null);
        given()        
        	.contentType(MediaType.APPLICATION_JSON)
        	.body(movimiento)          
        	.when().post("/mocked/kidsbanking-app/padres/gepetto/hijos/pinocho/cuentas/C01000001/movimientos/ingreso")
        	.then()
        		.statusCode(200);
    }
    @Test
    public void postTarjeta()  {
    	Tarjeta tarjeta = factory.manufacturePojo(Tarjeta.class);
    	tarjeta.setFechaAlta(null);
    	tarjeta.setFechaBaja(null);
        given()        
        	.contentType(MediaType.APPLICATION_JSON)
        	.body(tarjeta)          
        	.when().post("/mocked/kidsbanking-app/padres/gepetto/hijos/pinocho/tarjetas")
        	.then()
        		.statusCode(200);
    }
    @Test
    public void postCuenta()  {
    	Cuenta cuenta = factory.manufacturePojo(Cuenta.class);
    	cuenta.setFechaAlta(null);
    	cuenta.setFechaBaja(null);
        given()        
        	.contentType(MediaType.APPLICATION_JSON)
        	.body(cuenta)          
        	.when().post("/mocked/kidsbanking-app/padres/gepetto/hijos/pinocho/cuentas")
        	.then()
        		.statusCode(200);
    }
}