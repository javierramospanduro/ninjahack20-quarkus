package org.bbva.kidsbankingapp.facade;

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
import org.bbva.kidsbankingapp.utils.ServiceException;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/kids-banking-app")
public class SKidsBankingApp {
	
	private static final Logger LOG = Logger.getLogger(SKidsBankingApp.class);
	
	@Inject
	BKidsBankingApp business;
	
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam String user,@QueryParam String password) throws ServiceException {
    	business.login(user, password);
    	return Response.ok().build();
    }
    
    @POST
    @Path("/padres")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarPadre(Padre padre) throws ServiceException {
    	Padre res = business.registrarPadre(padre);
    	return Response.ok(res).build();
    }
    @POST
    @Path("/padres/{padreid}/hijos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarHijo(@PathParam String padreid,Hijo hijo) throws ServiceException {
    	if (!padreid.equals(hijo.getPadre().getId())) {
    		throw new  ServiceException("id padre no concuerda");
    	}    		
    	Hijo res = business.registrarHijo(hijo);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/padres/{padreid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPadre(@PathParam String padreid) throws ServiceException {
    	Padre res = business.getPadre(padreid);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/padres/{padreid}/hijos/{hijoid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getHijo(@PathParam String padreid,@PathParam String hijoid) throws ServiceException {
    	Hijo res = business.getHijo(hijoid);
    	if (!hijoid.equals(res.getId())) {
    		throw new  ServiceException("id padre no concuerda");
    	}
    	return Response.ok(res).build();
    }
    @GET
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCuentas(@PathParam String padreid,@PathParam String hijoid,@QueryParam String cuentaid) throws ServiceException {
    	List<Cuenta> res = business.getCuentas(hijoid, cuentaid);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/padres/{padreid}/hijos/{hijoid}/tarjetas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTarjetas(@PathParam String padreid,@PathParam String hijoid,@QueryParam String tarjetaid) throws ServiceException {
    	List<Tarjeta> res = business.getTarjetas(hijoid, tarjetaid);
    	return Response.ok(res).build();
    }
    
    @GET
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas/{cuentaid}/movimientos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovimientos(@PathParam String padreid,@PathParam String hijoid,@PathParam String cuentaid) throws ServiceException {
    	List<Movimiento> res = business.getMovimientosCuenta(cuentaid);
    	return Response.ok(res).build();
    }
    @GET
    @Path("/productos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovimientos(@QueryParam String nivelid) throws ServiceException {
    	List<Producto> res = business.getProductos(nivelid);
    	return Response.ok(res).build();
    }
    @POST
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas/{cuentaid}/movimientos/compras")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovimientos(@PathParam String padreid,@PathParam String hijoid,@PathParam String cuentaid,Compra compra) throws ServiceException {
    	Movimiento res = business.postCompra(compra);
    	return Response.ok(res).build();
    }
    @POST
    @Path("/padres/{padreid}/hijos/{hijoid}/cuentas/{cuentaid}/movimientos/ingreso")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovimientos(@PathParam String padreid,@PathParam String hijoid,@PathParam String cuentaid,Movimiento ingreso) throws ServiceException {
    	Movimiento res = business.postIngreso(ingreso);
    	return Response.ok(res).build();
    }    
}