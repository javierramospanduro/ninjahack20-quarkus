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

@ApplicationScoped
public class PadreMapper {

    public Padre mapFromResultSet (final ResultSet in) throws SQLException {
        final Padre padreOut = new Padre();
        padreOut.setId(in.getString(1));
        padreOut.setNombre(in.getString(2));
        padreOut.setMail(in.getString(3));
        padreOut.setPassword(in.getString((4));
        padreOut.setFechaAlta(in.getDate(5));
        padreOut.setFechaBaja(in.getDate(6));
        padreOut.setActivo(in.getBoolean(7));
        
        return padreOut;

        }
    public PreparedStatement mapForQueryInsert (final Padre in, final Connection conexion) throws SQLException {
        
      //  final Connection conexion = DriverManager.getConnection(
      //"j/dbc:mysql://servidor/basedatos?useServerPrepStmts=true",
      //"usuario", "password");



        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1,in.getId());
        psIns.setString(2, in.getNombre());
        psIns.setString(3,in.getMail());
        psIns.setString(4,in.getPassword());
        psIns.setDate(5, (Date) in.getFechaAlta());
        psIns.setDate(6, (Date)in.getFechaBaja());
        psIns.setBoolean(7, in.isActivo());

        return psIns;

    }

}
