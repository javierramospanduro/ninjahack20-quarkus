package org.bbva.kidsbankingapp.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class Mocker {

	private static final PodamFactory factory = new PodamFactoryImpl();
	
	public static final Padre mockPadre() {
		Padre padre = new Padre();
		padre.setId("gepetto");
		padre.setNombre("Geppeto");
		padre.setFechaAlta(new Date());
		padre.setMail("geppeto@bankingapp.com");
		padre.setPassword("pass");
		padre.setActivo(true);
		return padre;		
	}
	public static final Hijo mockHijo() {
		Hijo hijo = new Hijo();
		hijo.setPadre(Mocker.mockPadre());
		hijo.setId("pinocho");
		hijo.setNombre("Pinocho");
		hijo.setFechaAlta(new Date());
		hijo.setMail("pinocho@bankingapp.com");
		hijo.setPassword("pass");
		hijo.setActivo(true);
		return hijo;		
	}
	public static final Cuenta mockCuenta() {
		Cuenta cuenta = new Cuenta();
		cuenta.setId("0000000001");
		cuenta.setHijo(Mocker.mockHijo());
		cuenta.setFechaAlta(new Date());
		cuenta.setIngresoMensual(new BigDecimal((double) 450));
		cuenta.setPadre(Mocker.mockPadre());
		cuenta.setSaldo(new BigDecimal((double) 650));
		cuenta.setActivo(true);
		return cuenta;
	}
	public static Tarjeta mockTarjeta() {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setActivo(true);
		tarjeta.setCuenta(Mocker.mockCuenta());
		tarjeta.setFechaAlta(new Date());
		tarjeta.setHijo(Mocker.mockHijo());
		tarjeta.setId("1321564654324654");
		tarjeta.setTipoTarjeta("Debito");
		return tarjeta;
	}
	public static Producto mockProducto() {
		return factory.manufacturePojo(Producto.class); 
	}
	public static List<Producto> mockListaProductos() {
		return factory.manufacturePojo(ArrayList.class, Producto.class);
	}
	public static Nivel mockNivel() {
		Nivel out = new Nivel();
		out.setId("01");
		out.setDescription("INICIADO");
		return out;
	}
	public static List<Movimiento> mockMovimientos() {
		List<Movimiento> out = factory.manufacturePojo(ArrayList.class, Movimiento.class);
		for (Movimiento elem:out) {
			elem.setCuenta(Mocker.mockCuenta());
			elem.setTarjeta(Mocker.mockTarjeta());
		}
		return out;
	}
	
	

}
