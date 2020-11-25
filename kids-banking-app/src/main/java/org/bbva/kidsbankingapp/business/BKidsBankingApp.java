package org.bbva.kidsbankingapp.business;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bbva.kidsbankingapp.dao.DKidsBankingApp;
import org.bbva.kidsbankingapp.dto.Compra;
import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import org.jboss.logging.Logger;

@ApplicationScoped
public class BKidsBankingApp {
	private static final Logger LOG = Logger.getLogger(BKidsBankingApp.class);
	
	@Inject
	DKidsBankingApp dao;
	
	public boolean login(String user, String password) {
		
	}
	public Padre registrarPadre(Padre padre) {
		return padre;
	}
	public Hijo registrarHijo(Hijo hijo) {
		return hijo;
	}
	public Padre getPadre(String padreid) {
		return null;
	}
	public Hijo getHijo(String hijoid) {
		return null;
	}
	public List<Cuenta> getCuentas(String hijoid,String cuentaid) {
		return null;
	}
	public List<Tarjeta> getTarjetas(String hijoid,String tarjetaid) {
		return null;
	}
	public List<Movimiento> getMovimientosCuenta(String cuentaid) {
		return null;
	}
	public List<Producto> getProductos(String nivelid) {
		return null;
	}
	public Movimiento postCompra(Compra compra) {
		return null;
	}
	public Movimiento postIngreso(Movimiento movimiento) {
		return null;
	}
}
