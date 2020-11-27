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
	
	$user = $hostUser; 
    $password = $hostPasswd;
	
    $ODBCConnection = odbc_connect("DRIVER={Devart ODBC Driver for PostgreSQL};Server='http://database';Database=" . $hostDb . ";Port=5432;String Types=Unicode", $user, $password);
?>
 
 
