package org.bbva.kidsbankingapp.business;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.bbva.kidsbankingapp.dao.DKidsBankingApp;
import org.bbva.kidsbankingapp.dto.Compra;
import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import org.bbva.kidsbankingapp.utils.Constants;
import org.bbva.kidsbankingapp.utils.ServiceException;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@ApplicationScoped
public class BKidsBankingApp {
	private static final Logger LOG = Logger.getLogger(BKidsBankingApp.class);
	
	@Inject
	DKidsBankingApp dao;
	
	public boolean login(@QueryParam("user") String user, @QueryParam("password") String password) throws ServiceException, SQLException {
		LOG.info("Recuperando usuario");
		Padre padre = dao.selectPadre(user);
		if (padre!=null) {
			if (!padre.getPassword().equals(password)) {
				throw new ServiceException(Constants.ERROR_CONTRASENYA);
			} else {
				return true;
			}
		}
		Hijo hijo = dao.selectHijo(user);
		if (hijo!=null) {
			if (!hijo.getPassword().equals(password)) {
				throw new ServiceException(Constants.ERROR_CONTRASENYA);
			} else {
				return true;
			}
		}
		throw new ServiceException(Constants.ERROR_USUARIO);
	}
	public Padre registrarPadre(Padre padre) throws ServiceException, SQLException {
		if (StringUtils.isBlank(padre.getId())
				|| StringUtils.isBlank(padre.getNombre())
				|| StringUtils.isBlank(padre.getMail())
				|| StringUtils.isBlank(padre.getPassword())) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		return dao.insertPadre(padre);
	}
	public Hijo registrarHijo(Hijo hijo) throws ServiceException, SQLException {
		if (StringUtils.isBlank(hijo.getId())
				|| hijo.getPadre()==null 
				|| StringUtils.isBlank(hijo.getNombre())
				|| StringUtils.isBlank(hijo.getMail())
				|| StringUtils.isBlank(hijo.getPassword())) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		return dao.insertHijo(hijo);

	}
	public Padre getPadre(String padreid) throws ServiceException, SQLException {
		if (StringUtils.isBlank(padreid)) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		return dao.selectPadre(padreid);
	}
	public Hijo getHijo(String hijoid) throws ServiceException, SQLException {
		if (StringUtils.isBlank(hijoid)) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		return dao.selectHijo(hijoid);
	}
	public List<Cuenta> getCuentas(String hijoid,String cuentaid) throws ServiceException, SQLException {
		if (StringUtils.isBlank(hijoid)) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		return dao.selectCuentas(hijoid, cuentaid);
	}
	public List<Tarjeta> getTarjetas(String hijoid,String tarjetaid) throws ServiceException, SQLException {
		if (StringUtils.isBlank(hijoid)) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		return dao.selectTarjetas(hijoid, tarjetaid);
	}
	public List<Movimiento> getMovimientosCuenta(String cuentaid) throws ServiceException, SQLException {
		if (StringUtils.isBlank(cuentaid)) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		return dao.selectMovimientos(cuentaid);
		
	}
	public List<Producto> getProductos(String nivelid) throws ServiceException, SQLException {
		if (StringUtils.isBlank(nivelid)) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		return dao.selectProductos(nivelid);
	}
	public Movimiento postCompra(Compra compra) throws ServiceException, SQLException {
		// Validaciones de campos de entrada
		if (compra.getProducto()!=null && !StringUtils.isBlank(compra.getProducto().getId())) {} else {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		if (compra.getTarjeta()!=null && !StringUtils.isBlank(compra.getTarjeta().getId())) {} else {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		if (compra.getFechaCompra()==null) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		// Logica negocio - La tarjeta y cuenta existen
		List<Tarjeta> tarj = dao.selectTarjetas(compra.getTarjeta().getId(), null);
		if (tarj != null && !tarj.isEmpty()) {} else {
			throw new ServiceException(Constants.ERROR_OPERACION);
		}
		List<Cuenta> cuen = dao.selectCuentas(compra.getTarjeta().getCuenta().getId(), null);
		if (cuen != null && !cuen.isEmpty()) {} else {
			throw new ServiceException(Constants.ERROR_OPERACION);
		}
		// Cuenta tiene saldo
		if (compra.getProducto().getPrecio().compareTo(cuen.get(0).getSaldo()) == 1) {
			throw new ServiceException(Constants.SALDO_INSUFICIENTE);			
		}
		// Hasta aquí ok, insertamos movimiento
		Movimiento mov = new Movimiento();
		mov.setCuenta(cuen.get(0));
		mov.setDescripcion("COMPRA EFECTUADA");
		mov.setFechaMovimiento(new Date());
		mov.setImporte(compra.getProducto().getPrecio());
		mov.setProducto(compra.getProducto());
		mov.setSaldoResultante(dao.actualizarSaldoCuenta(cuen.get(0), compra.getProducto().getPrecio()).getSaldo());
		mov.setTarjeta(compra.getTarjeta());
		return dao.insertMovimiento(mov);
	}
	public Movimiento postIngreso(Movimiento movimiento) throws ServiceException, SQLException {
		// 
		if (movimiento.getCuenta() != null && !StringUtils.isBlank(movimiento.getCuenta().getId())) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		if (movimiento.getImporte().compareTo(Constants.IMPORTE_MINIMO_INGRESO) < 1) {
			throw new ServiceException(Constants.MANDATORY_PARAMETERS_MISSING);
		}
		// Insertamos movimiento
		movimiento.setSaldoResultante(dao.actualizarSaldoCuenta(movimiento.getCuenta(), movimiento.getImporte()).getSaldo());
		dao.insertMovimiento(movimiento);		
		return null;
	}
}
