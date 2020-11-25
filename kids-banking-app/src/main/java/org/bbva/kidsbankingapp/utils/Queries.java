package org.bbva.kidsbankingapp.utils;

public class Queries {
	public static final String SELECT_PADRE 
		= "SELECT ID_PADRE,NOMBRE,FEC_ALTA,FEC_BAJA,ACTIVO,PASSWORD FROM T_PADRES WHERE ID_PADRE=? AND ACTIVO=TRUE";
}
