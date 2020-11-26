package org.bbva.kidsbankingapp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.mapper.PadreMapper;
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
		
	
}
