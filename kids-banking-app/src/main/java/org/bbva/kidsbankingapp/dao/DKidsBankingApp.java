package org.bbva.kidsbankingapp.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import org.bbva.kidsbankingapp.mapper.CuentaMapper;
import org.bbva.kidsbankingapp.mapper.HijoMapper;
import org.bbva.kidsbankingapp.mapper.MovimientoMapper;
import org.bbva.kidsbankingapp.mapper.NivelMapper;
import org.bbva.kidsbankingapp.mapper.ProductoMapper;
import org.bbva.kidsbankingapp.mapper.TarjetaMapper;
import org.bbva.kidsbankingapp.mapper.PadreMapper;
import org.bbva.kidsbankingapp.utils.Constants;
import org.bbva.kidsbankingapp.utils.Queries;
import org.bbva.kidsbankingapp.utils.ServiceException;
import org.jboss.logging.Logger;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@ApplicationScoped
public class DKidsBankingApp {
	private static final Logger LOG = Logger.getLogger(DKidsBankingApp.class);	
	
	@Inject
	@DataSource("kidsbankdb")
	AgroalDataSource usersDataSource;
	
	@Inject
	PadreMapper padreMapper;
	@Inject
	HijoMapper hijoMapper;
	@Inject
	CuentaMapper cuentaMapper;
	@Inject
	TarjetaMapper tarjetaMapper;
	@Inject
	ProductoMapper productoMapper;
	@Inject
	private NivelMapper nivelMapper;
	@Inject
	private MovimientoMapper movimientoMapper;
	
	public Padre selectPadre(String padreid) throws SQLException {
		LOG.info("Recuperando padre:" + padreid);
		PreparedStatement st = usersDataSource.getConnection().prepareStatement(Queries.SELECT_PADRE);
		st.setString(1, padreid);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {			
			Padre res = padreMapper.mapFromResultSet(rs);
			st.close();
			return res;
		}
		LOG.info(" No data from padre : " + padreid);
		return null;
	}
	public Hijo selectHijo(String hijoid) throws SQLException {
		LOG.info("Recuperando hijo:" + hijoid);
		PreparedStatement st = usersDataSource.getConnection().prepareStatement(Queries.SELECT_PADRE);
		st.setString(1, hijoid);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {			
			Hijo res = hijoMapper.mapFromResultSet(rs);
			st.close();
			return res;
		}
		LOG.info(" No data from padre : " + hijoid);
		return null;
	}
	public List<Cuenta> selectCuentas(String hijoid,String cuentaid) throws ServiceException, SQLException {
		LOG.info("Recuperando cuentas:" + hijoid + "," + cuentaid);
		String query;
		String key;
		if (cuentaid != null) {
			query = Queries.SELECT_CUENTA_FROM_CUENTA_ID;
			key = cuentaid;
		} else if (hijoid != null) {
			query = Queries.SELECT_CUENTAS_FROM_HIJO;
			key = hijoid;
		} else {
			throw new ServiceException(Constants.ERROR_OPERACION);
		}
		PreparedStatement st = usersDataSource.getConnection().prepareStatement(query);
		st.setString(1, key);
		ResultSet rs = st.executeQuery();
		List<Cuenta> res = new ArrayList<>();
		while (rs.next()) {			
			res.add(cuentaMapper.mapFromResultSet(rs));
		}		
		st.close();
		return res;

	}
	public List<Tarjeta> selectTarjetas(String hijoid,String tarjetaid) throws ServiceException, SQLException {
		LOG.info("Recuperando tarjetas:" + hijoid + "," + tarjetaid);
		String query;
		String key;
		if (tarjetaid != null) {
			query = Queries.SELECT_CUENTA_FROM_CUENTA_ID;
			key = tarjetaid;
		} else if (hijoid != null) {
			query = Queries.SELECT_CUENTAS_FROM_HIJO;
			key = hijoid;
		} else {
			throw new ServiceException(Constants.ERROR_OPERACION);
		}
		PreparedStatement st = usersDataSource.getConnection().prepareStatement(query);
		st.setString(1, key);
		ResultSet rs = st.executeQuery();
		List<Tarjeta> res = new ArrayList<>();
		while (rs.next()) {			
			res.add(tarjetaMapper.mapFromResultSet(rs));
		}		
		st.close();
		return res;

	}
	public List<Producto> selectProductos(String productoId) throws SQLException {
		LOG.info("Recuperando productos: " + productoId);
		String query;
		String key;
		PreparedStatement st = null;
		if (productoId != null) {
			query = Queries.SELECT_PRODUCTOS;
			key = productoId;
			st = usersDataSource.getConnection().prepareStatement(query);
			st.setString(1, key);
		} if (productoId != null) {
			query = Queries.SELECT_PRODUCTO;
			st = usersDataSource.getConnection().prepareStatement(query);
		}		
		ResultSet rs = st.executeQuery();
		List<Producto> res = new ArrayList<>();
		while (rs.next()) {			
			res.add(productoMapper.mapFromResultSet(rs));
		}		
		st.close();
		return res;

	}
	public List<Nivel> selectNiveles() throws SQLException {
		LOG.info("Recuperando niveles:");
		PreparedStatement st = usersDataSource.getConnection().prepareStatement(Queries.SELECT_NIVELES);
		ResultSet rs = st.executeQuery();
		List<Nivel> res = new ArrayList<>();
		while (rs.next()) {			
			res.add(nivelMapper.mapFromResultSet(rs));
		}		
		st.close();
		return res;
	}
	public List<Movimiento> selectMovimientos(String cuentaid) throws SQLException {
		LOG.info("Recuperando movimientos:");
		PreparedStatement st = usersDataSource.getConnection().prepareStatement(Queries.SELECT_MOVIMIENTOS);
		st.setString(1, cuentaid);
		ResultSet rs = st.executeQuery();
		List<Movimiento> res = new ArrayList<>();
		while (rs.next()) {			
			res.add(movimientoMapper.mapFromResultSet(rs));
		}		
		st.close();		
		return res;
	}
	public Padre insertPadre(Padre padre) throws SQLException {
		LOG.info("Insert padre, data:" + padre);
		PreparedStatement st = padreMapper.mapFromDto(padre, usersDataSource.getConnection());		
		st.execute();
		st.close();
		return padre;
	}
	public Hijo insertHijo(Hijo hijo) throws SQLException {
		LOG.info("Insert padre, data:" + hijo);
		PreparedStatement st = hijoMapper.mapFromDto(hijo, usersDataSource.getConnection());		
		st.execute();
		st.close();
		return hijo;
	}
	public Cuenta insertCuenta(Cuenta cuenta) throws SQLException {
		LOG.info("Insert padre, data:" + cuenta);
		PreparedStatement st = cuentaMapper.mapFromDto(cuenta, usersDataSource.getConnection());		
		st.execute();
		st.close();
		return cuenta;
	}
	public Movimiento insertMovimiento(Movimiento movimiento) throws SQLException {
		LOG.info("Insert padre, data:" + movimiento);
		PreparedStatement st = movimientoMapper.mapFromDto(movimiento, usersDataSource.getConnection());		
		st.execute();
		st.close();
		return movimiento;
	}
	public Tarjeta insertTarjeta(Tarjeta tarjeta) throws SQLException {
		LOG.info("Insert padre, data:" + tarjeta);
		PreparedStatement st = tarjetaMapper.mapFromDto(tarjeta, usersDataSource.getConnection());		
		st.execute();
		st.close();
		return tarjeta;
	}
	public Cuenta actualizarSaldoCuenta(Cuenta cuenta,BigDecimal importe) throws SQLException {
		LOG.info("Recuperando niveles:");
		PreparedStatement st = usersDataSource.getConnection().prepareStatement(Queries.ACTUALIZAR_SALDO);
		st.setBigDecimal(1, importe);
		st.setString(2, cuenta.getId());
		st.execute();
		cuenta.setSaldo(importe);
		return cuenta;
	}
	
	
	
}
