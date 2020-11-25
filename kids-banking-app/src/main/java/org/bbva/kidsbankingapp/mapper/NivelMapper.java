package org.bbva.kidsbankingapp.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;

import org.bbva.kidsbankingapp.dto.Nivel;

@ApplicationScoped
public class NivelMapper {

    public Nivel mapFromResultSet (final ResultSet in) throws SQLException {
        final Nivel nv = new Nivel();
        nv.setId(in.getString(1));
        nv.setDescription(in.getString(2));

        
        return nv;

        }
    public PreparedStatement mapForQueryInsert (final Nivel in, final Connection conexion) throws SQLException {
        
      //  final Connection conexion = DriverManager.getConnection(
      //"j/dbc:mysql://servidor/basedatos?useServerPrepStmts=true",
      //"usuario", "password");



        final PreparedStatement  psIns = conexion.prepareStatement("");

        psIns.setString(1,in.getId());
        psIns.setString(2, in.getDescription());



        return psIns;

    }
}