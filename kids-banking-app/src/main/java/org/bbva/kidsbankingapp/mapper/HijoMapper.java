package org.bbva.kidsbankingapp.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.utils.Queries;

@ApplicationScoped
public class HijoMapper {

	public Hijo mapFromResultSet(final ResultSet in) throws SQLException {
		final Hijo ho = new Hijo();
		
		Padre p = new Padre();
		p.setId(in.getString(1));
		ho.setPadre(p);
		
		ho.setId(in.getString(2));
		ho.setNombre(in.getString(3));
		ho.setFechaAlta(in.getDate(4));
		ho.setFechaBaja(in.getDate(5));
		ho.setActivo(in.getBoolean(6));
		Nivel nv = new Nivel();
		nv.setId(in.getString(7));
		ho.setNivel(nv);
		ho.setPassword(in.getString(8));		
		ho.setMail(in.getString(9));

		return ho;

	}

	public PreparedStatement mapFromDto(final Hijo in, final Connection conexion) throws SQLException {

		final PreparedStatement psIns = conexion.prepareStatement(Queries.INSERT_HIJO);
		
		psIns.setString(1, in.getPadre().getId());
		psIns.setString(2, in.getId());
		psIns.setString(3, in.getNombre());
		psIns.setDate(4, new java.sql.Date(in.getFechaAlta().getTime()));
		psIns.setDate(5, new java.sql.Date(in.getFechaBaja().getTime()));		
		psIns.setBoolean(6, in.isActivo());
		psIns.setString(7, in.getNivel().getId());
		psIns.setString(8, in.getPassword());
		psIns.setString(9, in.getMail());





		return psIns;

	}

}
