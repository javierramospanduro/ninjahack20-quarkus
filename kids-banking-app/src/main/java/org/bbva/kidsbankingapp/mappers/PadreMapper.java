package org.bbva.kidsbankingapp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Padre;

@ApplicationScoped
public class PadreMapper {
	public Padre mapFromResultSet(ResultSet rs) throws SQLException {
		Padre out = new Padre();
		out.setId(rs.getString(1));
		out.setNombre(rs.getString(2));
		out.setFechaAlta(rs.getDate(3));
		out.setFechaBaja(rs.getDate(4));
		out.setActivo(rs.getBoolean(5));
		out.setPassword(rs.getString(6));
		return out;
	}
}
