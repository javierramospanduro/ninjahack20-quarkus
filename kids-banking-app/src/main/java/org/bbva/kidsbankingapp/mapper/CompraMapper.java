package org.bbva.kidsbankingapp.dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import org.bbva.kidsbankingapp.dto.Compra;
import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import org.acme.getting.dto.Compra;

@ApplicationScoped
public class CompraMapper {

    public Compra mapFromResultSet (final ResultSet in) throws SQLException {
        final Compra cmp = new Compra();
       
        Tarjeta tj = new Tarjeta();
        tj.setId(in.getString(1));
        cmp.setTarjeta(tj);

        Producto prd = new Producto();
        prd.setId(in.getString(2));
        tj.setProducto(prd);

        tj.setFechaCompra(ing.getDate(3));
        
        return tj;

        }
    public PreparedStatement mapForQueryInsert (final Compra in, final Connection conexion) throws SQLException {
        
      //  final Connection conexion = DriverManager.getConnection(
      //"j/dbc:mysql://servidor/basedatos?useServerPrepStmts=true",
      //"usuario", "password");



        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1,in.getTarjeta(().getId());
        psIns.setString(2,in.getProducto().getId());
        psIns.setDate(3,in.getFechaCompra());

        return psIns;
}
