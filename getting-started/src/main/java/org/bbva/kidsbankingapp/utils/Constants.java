package org.bbva.kidsbankingapp.utils;

import java.math.BigDecimal;

public class Constants {
	public static final String ERROR_CONTRASENYA= "Contraseña incorrecta";
	public static final String ERROR_USUARIO= "Usuario no existe";
	public static final String ERROR_ALTA = "Usuario ya existe";
	public static final String MANDATORY_PARAMETERS_MISSING = "Parametros obligatorios no informados";
	public static final String ERROR_OPERACION = "Se ha producido un error tecnico al realizar la operacion";
	public static final String SALDO_INSUFICIENTE = "La cuenta no dispone de saldo suficiente";
	public static final BigDecimal IMPORTE_MINIMO_INGRESO = new BigDecimal((double)0);
}

