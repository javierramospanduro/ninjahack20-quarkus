package org.bbva.kidsbankingapp.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.utils.Queries;

@ApplicationScoped
public class HijoMapper {

	public Hijo mapFromResultSet(final ResultSet in) throws SQLException {
		final Hijo ho = new Hijo();
		ho.setId(in.getString(1));
		ho.setNombre(in.getString(2));
		ho.setMail(in.getString(3));
		ho.setPassword(in.getString(4));
		ho.setFechaAlta(in.getDate(5));
		ho.setFechaBaja(in.getDate(6));
		Padre p = new Padre();
		p.setId(in.getString(7));
		ho.setPadre(p);
		Nivel nv = new Nivel();
		nv.setId(in.getString(8));
		ho.setNivel(nv);

		return ho;

	}

	public PreparedStatement mapFromDto(final Hijo in, final Connection conexion) throws SQLException {

		final PreparedStatement psIns = conexion.prepareStatement(Queries.INSERT_HIJO);

		psIns.setString(1, in.getId());
		psIns.setString(2, in.getNombre());
		psIns.setString(3, in.getMail());
		psIns.setString(4, in.getPassword());
		psIns.setDate(5, new java.sql.Date(in.getFechaAlta().getTime()));
		psIns.setDate(6, new java.sql.Date(in.getFechaBaja().getTime()));
		psIns.setString(7, in.getPadre().getId());
		psIns.setString(8, in.getNivel().getId());

		return psIns;

	}

}
