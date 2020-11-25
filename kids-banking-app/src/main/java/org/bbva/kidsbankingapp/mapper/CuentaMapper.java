package org.bbva.kidsbankingapp.mapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;

@ApplicationScoped
public class CuentaMapper {

    public Cuenta mapFromResultSet (final ResultSet in) throws SQLException {
        final Cuenta cnt = new Cuenta();
        Hijo hj = new Hijo();

        cnt.setId(in.getString(1));
        hj.setId(in.getString(2));
        cnt.setHijo(hj);
        cnt.setSaldo(in.getBigDecimal(3));
        cnt.setIngresoMensual(in.getBigDecimal(4));
        cnt.setFechaAlta(in.getDate(5));
        cnt.setFechaBaja(in.getDate(6));
        cnt.setActivo(in.getBoolean(7));

        
        return cnt;

        }
    public PreparedStatement mapFromDto (final Cuenta in, final Connection conexion) throws SQLException {
        

        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1, in.getId());
        psIns.setString(2,in.getHijo().getId());
        psIns.setBigDecimal(3, in.getSaldo());
        psIns.setBigDecimal(4,in.getIngresoMensual());
        psIns.setDate(5, new Date(in.getFechaAlta().getTime()));
        psIns.setDate(6, new Date(in.getFechaBaja().getTime()));
        psIns.setBoolean(7,in.isActivo());

        return psIns;

    }


}
