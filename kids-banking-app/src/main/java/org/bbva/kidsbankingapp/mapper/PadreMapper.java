package org.bbva.kidsbankingapp.mapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.utils.Queries;
import org.jboss.logging.Logger;

@ApplicationScoped
public class PadreMapper {
	
	private static final Logger LOG = Logger.getLogger(PadreMapper.class);
	
	public Padre mapFromResultSet(final ResultSet in) throws SQLException {
		final Padre padreOut = new Padre();
		
		padreOut.setId(in.getString(1).trim());
		padreOut.setNombre(in.getString(2).trim());
		padreOut.setFechaAlta(in.getDate(3));
		padreOut.setFechaBaja(in.getDate(4));		
		padreOut.setActivo(in.getBoolean(5));		
		padreOut.setPassword(in.getString(6).trim());
		padreOut.setMail(in.getString(7).trim());
		LOG.info("Padre mapped: " + padreOut);
		return padreOut;

	}

	public PreparedStatement mapFromDto(final Padre in, final Connection conexion) throws SQLException {

		final PreparedStatement psIns = conexion.prepareStatement(Queries.INSERT_PADRE);

		psIns.setString(1, in.getId());
		psIns.setString(2, in.getNombre());
		psIns.setDate(3, new java.sql.Date(in.getFechaAlta().getTime()));
		psIns.setDate(4, new java.sql.Date(in.getFechaBaja().getTime()));
		psIns.setBoolean(5, in.isActivo());	
		psIns.setString(6, in.getPassword());		
		psIns.setString(7, in.getMail());

		return psIns;

	}

}
