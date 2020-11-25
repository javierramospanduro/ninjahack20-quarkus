package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.util.Date;


import org.bbva.kidsbankingapp.dto.Compra;
import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.management.Query;
import io.quarkus.runtime.annotations.RegisterForReflection;

@ApplicationScoped
public class TarjetaMapper {

    public Tarjeta mapFromResultSet (final ResultSet in) throws SQLException {
        final Tarjeta trj = new Tarjeta();
        trj.setId(in.getString(1));
        Hijo hj = new Hijo();
        hj.setId(in.getString(2))
        trj.setHijo(hj);
        trj.setFechaAlta(in.getDate(3));
        trj.setFechaBaja(in.getDate(4));
        trj.setActivo(in.getBoolean(5));

        Cuenta cnt = new Cuenta();
        hj.setId(in.getString(6))
        trj.setCuenta(cnt);

        trj.setTipoTarjeta(in.getString(7))

        return trj;

        }
    public PreparedStatement mapForQueryInsert (final Tarjeta in, final Connection conexion) throws SQLException {
        
      //  final Connection conexion = DriverManager.getConnection(
      //"j/dbc:mysql://servidor/basedatos?useServerPrepStmts=true",
      //"usuario", "password");



        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1,in.getId());
        psIns.setString(2,in.getHijo().getId());
        psIns.setDate(3, in.getFechaAlta());
        psIns.setDate(4, in.getFechaBaja());
        psIns.setBoolean(5, in.isActivo());
        psIns.setString(6,in.getCuenta().getId());
        psIns.setString(7,in.getTipoTarjeta());


        return psIns;

    }

	

}
