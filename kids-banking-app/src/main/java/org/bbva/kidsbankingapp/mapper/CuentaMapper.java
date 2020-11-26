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
        Padre pd = new Padre();

        cnt.setId(in.getString(1));
        hj.setId(in.getString(2));
        cnt.setHijo(hj);
        cnt.setSaldo(in.getBigDecimal(3));

        cnt.setFechaAlta(in.getDate(4));
        cnt.setFechaBaja(in.getDate(5));
        cnt.setActivo(in.getBoolean(6));
 
        pd.setId(in.getString(7));
        cnt.setPadre(pd);
        
        cnt.setIngresoMensual(in.getBigDecimal(8));

        
        return cnt;

        }
    public PreparedStatement mapFromDto (final Cuenta in, final Connection conexion) throws SQLException {
        

        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1, in.getId());
        psIns.setString(2,in.getHijo().getId());
        psIns.setBigDecimal(3, in.getSaldo());

        psIns.setDate(4, new Date(in.getFechaAlta().getTime()));
        psIns.setDate(5, new Date(in.getFechaBaja().getTime()));
        psIns.setBoolean(6,in.isActivo());
        
        psIns.setString(7,in.getHijo().getId());     
        psIns.setBigDecimal(8,in.getIngresoMensual());
        
        return psIns;

    }


}
