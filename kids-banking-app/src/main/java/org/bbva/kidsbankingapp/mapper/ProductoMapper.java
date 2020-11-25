package org.bbva.kidsbankingapp.mapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Producto;

@ApplicationScoped
public class ProductoMapper {

    public Producto mapFromResultSet (final ResultSet in) throws SQLException {
        final Producto prd = new Producto();
        prd.setId(in.getString(1));
        prd.setDescripcion(in.getString(2));
        Nivel nv = new Nivel();
        nv.setId(in.getString(3));
        prd.setNivel(nv);
        prd.setPrecio(in.getBigDecimal(4));
        prd.setFechaAlta(in.getDate(5));
        prd.setFechaBaja(in.getDate(6));
        prd.setActivo(in.getBoolean(7));

        return prd;

        }
    public PreparedStatement mapForQueryInsert (final Producto in, final Connection conexion) throws SQLException {
        
      //  final Connection conexion = DriverManager.getConnection(
      //"j/dbc:mysql://servidor/basedatos?useServerPrepStmts=true",
      //"usuario", "password");



        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1,in.getId());
        psIns.setString(2,in.getDescripcion());
        psIns.setString(3,in.getNivel().getId());
        psIns.setBigDecimal(4,in.getPrecio());
        psIns.setDate(5, new java.sql.Date(in.getFechaAlta().getTime()));
        psIns.setDate(6, new java.sql.Date(in.getFechaBaja().getTime()));
        psIns.setBoolean(7, in.isActivo());

        return psIns;

    }

}