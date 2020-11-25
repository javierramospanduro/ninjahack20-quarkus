package org.bbva.kidsbankingapp.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.bbva.kidsbankingapp.mappers.PadreMapper;
import org.bbva.kidsbankingapp.utils.Queries;
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
	public Hijo selectHijo(String hijoid) {
		LOG.info("Recuperando hijo:" + hijoid);
		return null;
	}
	public List<Cuenta> selectCuentas(String hijoid,String cuentaid) {
		return null;
	}
	public List<Tarjeta> selectTarjetas(String hijoid,String tarjetaid) {
		return null;
	}
	public List<Producto> selectProductos(String productoId) {
		return null;
	}
	public List<Nivel> selectNiveles() {
		return null;
	}
	public List<Movimiento> selectMovimientos(String cuentaid) {
		return null;
	}
	public Padre insertPadre(Padre padre) {
		return null;
	}
	public Hijo insertHijo(Hijo hijo) {
		return null;
	}
	public Cuenta insertCuenta(Cuenta cuenta) {
		return null;
	}
	public Movimiento insertMovimiento(Movimiento movimiento) {
		return null;
	}
	public Tarjeta insertTarjeta(Tarjeta tarjeta) {
		return null;
	}
	public Cuenta actualziarSaldo(Cuenta cuenta,BigDecimal importe) {
		return null;
	}
	
	
	
}
