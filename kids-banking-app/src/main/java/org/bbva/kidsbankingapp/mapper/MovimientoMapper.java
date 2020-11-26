package org.bbva.kidsbankingapp.mapper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Cuenta;
import org.bbva.kidsbankingapp.dto.Hijo;
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
        Hijo hj = new Hijo();
    	
        
        mov.setId(in.getString(1)); 
        cnt.setId(in.getString(2));
        trj.setId(in.getString(3));
        mov.setCuenta(cnt);
        mov.setTarjeta(trj);
        
        mov.setImporte(in.getBigDecimal(4));
        mov.setFechaMovimiento(in.getDate(5));
        
        mov.setDescripcion(in.getString(6));
        mov.setSaldoResultante(in.getBigDecimal(7));
        
        prd.setId(in.getString(8));     
        mov.setProducto(prd);
        
        hj.setId(in.getString(9));
        mov.setHijo(hj);     



        return mov;

        }
    public PreparedStatement mapFromDto (final Movimiento in, final Connection conexion) throws SQLException {
        


        final PreparedStatement  psIns = conexion.prepareStatement(Queries.INSERT_MOVIMIENTO);

        
        psIns.setString(1,in.getId());       
        psIns.setString(2,in.getCuenta().getId());
        psIns.setString(3,in.getTarjeta().getId());
        psIns.setBigDecimal(4, in.getImporte());
        psIns.setDate(5, new java.sql.Date(in.getFechaMovimiento().getTime()));
        psIns.setString(6,in.getDescripcion());
        psIns.setBigDecimal(7,in.getSaldoResultante());    
        psIns.setString(8, in.getProducto().getId());
        psIns.setString(9, in.getHijo().getId());


        return psIns;

    }

}
