package org.bbva.kidsbankingapp.mapper;

import java.io.Serializable;
import java.util.Date;

import org.acme.getting.dto.Hijo;
import org.acme.getting.dto.Padre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bbva.kidsbankingapp.dto.Compra;
import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Nivel;
import org.bbva.kidsbankingapp.dto.Padre;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;

import javax.enterprise.context.ApplicationScoped;
import javax.management.Query;
import io.quarkus.runtime.annotations.RegisterForReflection;

@ApplicationScoped
public class HijoMapper {

    public Hijo mapFromResultSet (final ResultSet in) throws SQLException {
        final Hijo ho = new Hijo();
        ho.setId(in.getString(1));
        ho.setNombre(in.getString(2));
        ho.setEmail(in.getString(3));
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
    public PreparedStatement mapForQueryInsert (final Hijo in, final Connection conexion) throws SQLException {
        
      //  final Connection conexion = DriverManager.getConnection(
      //"j/dbc:mysql://servidor/basedatos?useServerPrepStmts=true",
      //"usuario", "password");



        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1,in.getId());
        psIns.setString(2, in.getNombre());
        psIns.setString(3,in.getEmail());
        psIns.setString(4,in.getPassword());
        psIns.setDate(5, (Date) in.getFechaAlta());
        psIns.setDate(6, (Date)in.getFechaBaja());
        psIns.setString(7,in.getPadre().getId());
        psIns.setString(8,in.getNivel().getId());


        return psIns;

    }

}
