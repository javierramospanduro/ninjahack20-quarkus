package org.bbva.kidsbankingapp.facade;


import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bbva.kidsbankingapp.business.BKidsBankingApp;
import org.bbva.kidsbankingapp.dto.Compra;
import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/mocked/kidsbanking-app")
public class SKidsBankingApp {

	private static final Logger LOG = Logger.getLogger(SKidsBankingApp.class);
	
	@Inject
	BKidsBankingApp business;
	
	@GET
	@Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response test() {
    	return Response.ok("Hello world!").build();
    }

	
    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("userid") String user,@QueryParam("password") String password) throws SQLException {
    	LOG.info("Entrando en login, user:" + user);    	
    	if (business.login(user, password)) {
    		LOG.info("Log ok");
    		return Response.ok().build();
    	} 
    	LOG.info("Log error");
    	return Response.serverError().build();    		
    }
    
    @POST
    @Path("/padres")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarPadre(Padre padre) throws SQLException  {
    	LOG.info("Alta de padre: " + padre);
    	Padre res = business.registrarPadre(padre);
    	return Response.ok(res).build();
    }
    @POST
    @Path("/padres/{padreid}/hijos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarHijo(@PathParam String padreid,Hijo hijo)  {
    	LOG.info("Alta hijo " + hijo);
    	Hijo res = business.registrarHijo(hijo);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/padres/{padreid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPadre(@PathParam("padreid") String padreid)  {
    	LOG.info("Get padre " + padreid);
    	Padre res = business.getPadre(padreid);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/padres/{padreid}/hijos/{hijoid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getHijo(@PathParam("padreid") String padreid,@PathParam("hijoid") String hijoid)  {
    	LOG.info("Get padre " + padreid + " hijo " + hijoid);
    	Hijo res = business.getHijo(hijoid);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCuentas(@PathParam("padreid") String padreid,@PathParam("hijoid") String hijoid,@QueryParam("cuentaid") String cuentaid)  {
    	LOG.info("Get getCuentas " + padreid + " hijo " + hijoid + " cuenta " + cuentaid);
    	List<Cuenta> res = business.getCuentas(hijoid, cuentaid);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/padres/{padreid}/hijos/{hijoid}/tarjetas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTarjetas(@PathParam("padreid") String padreid,@PathParam("hijoid") String hijoid,@QueryParam("tarjetaid") String tarjetaid)  {
    	LOG.info("Get getTarjetas " + padreid + " hijo " + hijoid + " cuenta " + tarjetaid);
    	List<Tarjeta> res = business.getTarjetas(hijoid, tarjetaid);
    	return Response.ok(res).build();
    }
    
    @GET
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas/{cuentaid}/movimientos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovimientos(@PathParam("padreid") String padreid,@PathParam("hijoid") String hijoid,@PathParam("cuentaid") String cuentaid)  {
    	LOG.info("Get getMovimientos " + padreid + " hijo " + hijoid + " cuenta " + cuentaid);
    	List<Movimiento> res = business.getMovimientosCuenta(cuentaid);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/productos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovimientos(@QueryParam("nivelid") String nivelid)  {
    	LOG.info("Get productos " + nivelid);
    	List<Producto> res = business.getProductos(nivelid);
    	return Response.ok(res).build();
    }
    @POST
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCuenta(@PathParam("padreid") String padreid,@PathParam("hijoid") String hijoid,Cuenta cuenta)  {
    	LOG.info("postCuenta " + padreid + " hijoid " + hijoid + " cuenta " + cuenta);
    	Cuenta res = business.postCuenta(padreid,hijoid,cuenta);
    	return Response.ok(res).build();
    }
    @POST
    @Path("/padres/{padreid}/hijos/{hijoid}/tarjetas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postTarjeta(@PathParam("padreid") String padreid,@PathParam("hijoid") String hijoid,Tarjeta tarjeta)  {
    	LOG.info("aktaTarj " + padreid + " hijoid " + hijoid + " cuenta " + tarjeta);
    	Tarjeta res = business.postTarjeta(padreid,hijoid,tarjeta);
    	return Response.ok(res).build();
    }

    @POST
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas/{cuentaid}/movimientos/compras")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCompra(@PathParam("padreid") String padreid,@PathParam("hijoid") String hijoid,@PathParam("cuentaid") String cuentaid,Compra compra)  {
    	LOG.info("compra " + padreid + " hijoid " + hijoid + " cuenta " + cuentaid + " compra " + compra);
    	Movimiento res = business.postCompra(compra);
    	return Response.ok(res).build();
    }
    @POST
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas/{cuentaid}/movimientos/ingreso")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postIngreso(@PathParam("padreid") String padreid,@PathParam("hijoid") String hijoid,@PathParam String cuentaid,Movimiento ingreso)  {
    	LOG.info("ingreso " + padreid + " hijoid " + hijoid + " cuenta " + cuentaid + " compra " + ingreso);
    	Movimiento res = business.postIngreso(ingreso);
    	return Response.ok(res).build();
    }
	
}