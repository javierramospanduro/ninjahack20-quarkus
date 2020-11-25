package org.bbva.kidsbankingapp.mapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Compra;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;

@ApplicationScoped
public class CompraMapper {

	public Compra mapFromResultSet(final ResultSet in) throws SQLException {
		final Compra cmp = new Compra();

		Tarjeta tj = new Tarjeta();
		tj.setId(in.getString(1));
		cmp.setTarjeta(tj);

		Producto prd = new Producto();
		prd.setId(in.getString(2));
		cmp.setProducto(prd);

		cmp.setFechaCompra(new Date(in.getDate(3).getTime()));

		return cmp;

	}

	public PreparedStatement mapForQueryInsert(final Compra in, final Connection conexion) throws SQLException {

		// final Connection conexion = DriverManager.getConnection(
		// "j/dbc:mysql://servidor/basedatos?useServerPrepStmts=true",
		// "usuario", "password");

		final PreparedStatement psIns = conexion.prepareStatement("");

		psIns.setString(1, in.getTarjeta().getId());
		psIns.setString(2, in.getProducto().getId());
		psIns.setDate(3, new Date(in.getFechaCompra().getTime()));

		return psIns;
	}
}
