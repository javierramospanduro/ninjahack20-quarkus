package org.bbva.kidsbankingapp.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import org.bbva.kidsbankingapp.utils.Mocker;
import org.jboss.logging.Logger;

@ApplicationScoped
public class BKidsBankingApp {
	private static final Logger LOG = Logger.getLogger(BKidsBankingApp.class);
	@Inject
	DKidsBankingApp dao;
	
	public boolean login(String user,String password) throws SQLException  {
		Padre padre = dao.selectPadre(user);
		if (padre!=null) {
			if (padre.getPassword().equals(password)) {
				return true;
			}
		}		
		return false;
	}
	public Padre registrarPadre(Padre padre) throws SQLException  {
		padre.setFechaAlta(new Date());
		return dao.insertPadre(padre);
	}
	public Hijo registrarHijo(Hijo hijo)  {
		return Mocker.mockHijo();
	}
	public Padre getPadre(String padreid) {
		return Mocker.mockPadre();
	}
	public Hijo getHijo(String hijoid)  {
		return Mocker.mockHijo();
	}
	public List<Cuenta> getCuentas(String hijoid,String cuentaid)  {
		List<Cuenta> out = new ArrayList<Cuenta>();
		out.add(Mocker.mockCuenta());
		return out;
	}
	public List<Tarjeta> getTarjetas(String hijoid,String tarjetaid)  {
		List<Tarjeta> out = new ArrayList<Tarjeta>();
		out.add(Mocker.mockTarjeta());
		return out;
	}
	public List<Movimiento> getMovimientosCuenta(String cuentaid)  {
		return Mocker.mockMovimientos();
	}
	public List<Producto> getProductos(String nivelid)  {
		return Mocker.mockListaProductos();
	}
	public Movimiento postCompra(Compra compra)  {
		return Mocker.mockMovimientos().get(0);
	}
	public Movimiento postIngreso(Movimiento movimiento)  {
		return Mocker.mockMovimientos().get(0);
	}
	public Cuenta postCuenta(String padreid, String hijoid, Cuenta cuenta) {
		return Mocker.mockCuenta();
	}
	public Tarjeta postTarjeta(String padreid, String hijoid, Tarjeta tarjeta) {
		// TODO Auto-generated method stub
		return Mocker.mockTarjeta();
	}
}
