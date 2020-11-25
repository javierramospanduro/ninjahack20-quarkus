package org.bbva.kidsbankingapp.mapper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Movimiento;
import org.bbva.kidsbankingapp.dto.Producto;
import org.bbva.kidsbankingapp.dto.Tarjeta;
import org.bbva.kidsbankingapp.utils.Queries;

@ApplicationScoped
public class MovimientoMapper {
	Cuenta cuenta;
	Tarjeta tarjeta;
	Date fechaMovimiento;
	BigDecimal importe;
	BigDecimal saldoResultante;
	String descripcion;
	Producto producto;
    public Movimiento mapFromResultSet (final ResultSet in) throws SQLException {
        
    	
    	final Movimiento mov = new Movimiento();
        Cuenta cnt = new Cuenta();
        Tarjeta trj = new Tarjeta();
        Producto prd = new Producto();
    	
        cnt.setId(in.getString(1));

        trj.setId(in.getString(2));
        prd.setId(in.getString(3));
        
        mov.setCuenta(cnt);
        mov.setTarjeta(trj);
        mov.setProducto(prd);
        
        mov.setFechaMovimiento(in.getDate(4));
        mov.setImporte(in.getBigDecimal(5));
        mov.setSaldoResultante(in.getBigDecimal(6));
        mov.setDescripcion(in.getString(7));

        return mov;

        }
    public PreparedStatement mapFromDto (final Movimiento in, final Connection conexion) throws SQLException {
        


        final PreparedStatement  psIns = conexion.prepareStatement(Queries.INSERT_MOVIMIENTO);

        psIns.setString(1,in.getCuenta().getId());
        psIns.setString(2,in.getTarjeta().getId());
        psIns.setString(3, in.getProducto().getId());
        psIns.setDate(4, new java.sql.Date(in.getFechaMovimiento().getTime()));
        psIns.setBigDecimal(5, in.getImporte());
        psIns.setBigDecimal(6,in.getSaldoResultante());
        psIns.setString(7,in.getDescripcion());

        return psIns;

    }

}
