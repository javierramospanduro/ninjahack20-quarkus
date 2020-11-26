package org.bbva.kidsbankingapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.mapper.PadreMapper;
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
	
	public Padre insertPadre(Padre padre) throws SQLException {
		LOG.info("Insert padre, data:" + padre);
		PreparedStatement st = padreMapper.mapFromDto(padre, usersDataSource.getConnection());		
		st.execute();
		st.close();
		return padre;
	}
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
}
