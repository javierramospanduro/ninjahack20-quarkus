<?php
	// Archivo de propiedades .json
	$propiedades     = 		file_get_contents("Config/host-properties.json"); 
	// Se cargan los datos del json en un array
	$jsonPropiedades = 		json_decode($propiedades, true);
	// Se usan los datos del array $jsonPropiedades para configurar la conexión. Sirve para en caso de necesitar cambiar los datos de conexión, se cambie un único archivo, en vez de cambiar todos los archivos .php del proyecto

	$host            = 		$jsonPropiedades['host']; 
	$hostUser        = 		$jsonPropiedades['hostUser']; 
	$hostPasswd      = 		$jsonPropiedades['hostPasswd'];
	$hostDb          = 		$jsonPropiedades['hostDb'];
	
	// Conexión a la base de datos con las variables de arriba
	$conexion        = 		mysqli_connect($host, $hostUser, $hostPasswd) or die (header("Location: error.html"));
	mysqli_set_charset 		($conexion, "utf8");
	mysqli_select_db 		($conexion, $hostDb) or die (header("Location: error.html"));
	
	// Conexión a la base de datos con las variables de arriba
	$conexion2        = 		mysqli_connect($host, $hostUser, $hostPasswd) or die (header("Location: error.html"));
	mysqli_set_charset 		($conexion2, "utf8");
	mysqli_select_db 		($conexion2, $hostDb) or die (header("Location: error.html"));
?>
 
 
