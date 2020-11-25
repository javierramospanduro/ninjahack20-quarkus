package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
    public PreparedStatement mapForQueryInsert (final Cuenta in, final Connection conexion) throws SQLException {
        
      //  final Connection conexion = DriverManager.getConnection(
      //"j/dbc:mysql://servidor/basedatos?useServerPrepStmts=true",
      //"usuario", "password");



        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1, in.getId());
        psIns.setString(2,in.getHijo().getId());
        psIns.setBigDecimal(3, in.getSaldo());
        psIns.setBigDecimal(4,in.getIngresoMensual());
        psIns.setDate(5, in.getFechaAlta());
        psIns.setDate(6, in.getFechaBaja());
        psIns.setBoolean(7,in.isActivo());


        return psIns;

    }


}
