<?PHP

	// ---------------------------- //
	// Configuración de la conexión //
	// ---------------------------- //
	
	// Archivo de propiedades .json
	$propiedades     = 		file_get_contents("Config/host-properties.json"); 
	// Se cargan los datos del json en un array
	$jsonPropiedades = 		json_decode($propiedades, true);
	// Se usan los datos del array $jsonPropiedades para configurar la conexión. Sirve para en caso de necesitar cambiar los datos de conexión, se cambie un único archivo, en vez de cambiar todos los archivos .php del proyecto
	$rutaInclude     = 		$jsonPropiedades['Rol'];
	set_include_path 		($rutaInclude);

	// ----------------------------------------- //
	// Acción ejecutada por el botón Registrarse //
	// ------------------------------------------//
	
	if(isset($_REQUEST['Crear'])){

		$username = $_REQUEST['Usuario'];
		$DNI = $_REQUEST['DNI'];

		$queryEmpl = "select count(*) as ExistDNI FROM t0001_User WHERE s_DNI = '". $DNI ."'" ;
		$resultadoConsulta = mysqli_query($conexion, $queryEmpl , MYSQLI_STORE_RESULT) or die (header("Location: error.html"));
		$fila = mysqli_fetch_array($resultadoConsulta);
		$DNIExist= $fila['ExistDNI'];

		if($DNIExist==0){

			$pass = $_REQUEST['Contrasena'];
			$passRep = $_REQUEST['RContrasena'];
			
			if($pass==$passRep){
				$mailUser = $_REQUEST['mailUser'];
				$SolicPerm = $_REQUEST['roles'];
				
				//aqui va la query de insercion
				$query="Insert into t0001_User(s_User,s_Pass,s_DNI,s_MailUser,id_Rol,s_Comentario,id_SuperAdmin) VALUES ('".$username."','".md5($pass)."','".$DNI."', '".$mailUser."','".$SolicPerm ."', '".$SolicPerm."', '".$IdUSer ."')";							
				$resultadoConsulta = mysqli_query($conexion,$query , MYSQLI_USE_RESULT) or die (header("Location: error.html")); 
				echo '
				<div class="alert success">
					<span class="closebtn">&times;</span>  
					<strong>Success!</strong> Usuario creado y puesto a la espera de confirmación por el administrador.
				</div>			
				';
			}
			else{
			echo '
				<div class="alert warning">
  					<span class="closebtn">&times;</span>  
  					<strong>Warning!</strong> Las contraseñas no coinciden.
				</div>			
			';
			}
		}else{
			echo '
				<div class="alert">
  					<span class="closebtn">&times;</span>  
  					<strong>Danger!</strong> El DNI esta en uso, comprueba el DNI antes de introducirlo.
				</div>
			';
		}
	}
	
?>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" style="height: 254px; ">
	<head>
  		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet">
		<link rel='stylesheet' href = "css/Comun.css" type = "text/css">
		<link rel='stylesheet' href = "css/Registro.css" type = "text/css">
		<script type="text/javascript" src="js/popUps.js"></script>
		<link rel="shortcut icon" href=".\imagenes\N.png" />
		<title>Datos Usuario</title>
	</head>
  <body>

		<div id="contenedorPeque">
		<div class="titulo"><img src=".\imagenes\LogoBBVA.png" class="LogoPeq"><h3>Creación Usuario</h3></div>

		<form id="back" name="back" method="post" action="Index1.php">
			<input id="imgEdit" type="image" src=".\imagenes\Back01.png" alt="Smiley face">Atras
		</form>

						<div id ="Cuerpo">
				<form action="" method="POST"> 
					<table>
						<tr>
							<td>
								<label for="fname">Usuario</label>
								<input type="text" name="Usuario" value ="">
							</td>
						</tr>
						<tr>
							<td colspan="2">
							<label for="fname">Pass</label>
							<input type="Password" name="Contrasena" minlength="8" value ="">
							
							<label for="fname">Repita la Pass</label>
							<input type="Password" name="RContrasena" minlength="8" value ="">
							<label for="fname">DNI</label>
							<input type="text" name="DNI" required value ="" pattern="[0-9]{8}[A-Za-z]{1}">
							<label for="fname">Correo del usuario</label>
							<input type="email" name="mailUser" required value ="">
							</td>
						</tr>
						
					</table>
					<input type="submit" id="Crear" name="Crear" value="Crear" style="width: 100%;">
				</form>
			</div>
		</div>	
</body>
</html>