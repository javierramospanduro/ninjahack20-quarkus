package org.bbva.kidsbankingapp.mapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.management.Query;

import org.bbva.kidsbankingapp.dto.Compra;
import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import org.bbva.kidsbankingapp.utils.Queries;

@ApplicationScoped
public class PadreMapper {

	public Padre mapFromResultSet(final ResultSet in) throws SQLException {
		final Padre padreOut = new Padre();
		padreOut.setId(in.getString(1));
		padreOut.setNombre(in.getString(2));
		padreOut.setFechaAlta(in.getDate(3));
		padreOut.setFechaBaja(in.getDate(4));		
		padreOut.setActivo(in.getBoolean(5));		
		padreOut.setPassword(in.getString(6));
		padreOut.setMail(in.getString(7));

		return padreOut;

	}

	public PreparedStatement mapFromDto(final Padre in, final Connection conexion) throws SQLException {

		final PreparedStatement psIns = conexion.prepareStatement(Queries.INSERT_PADRE);

		psIns.setString(1, in.getId());
		psIns.setString(2, in.getNombre());
		psIns.setDate(3, (Date) in.getFechaAlta());
		psIns.setDate(4, (Date) in.getFechaBaja());

		psIns.setBoolean(5, in.isActivo());	
		psIns.setString(6, in.getPassword());		
		psIns.setString(7, in.getMail());

		return psIns;

	}

}
