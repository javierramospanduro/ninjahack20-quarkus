
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" style="height: 254px; ">
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet">
	<link rel='stylesheet' href = "css/Comun.css" type = "text/css">
	<link rel='stylesheet' href = "css/Principal.css" type = "text/css">
	<link rel="shortcut icon" href=".\imagenes\N.png" />
	<script type="text/javascript" src="js/popUps.js"></script>
    <title>BBVA</title>
  </head>

  <body>
 	<p class="BBVA"><b>BBVA<b></p>
	<div id="contenedor1">
			
		<?PHP
			if(empty($_SESSION["nombre_usuario"])){
			print '
			<div id="contenedor1">
				<img src=".\imagenes\NFQNegativo.png" >
				<form id = "formulario" method = "post">
					<div id="acceso">
						<p class = "acceso">Login</p>
						<input id = "DNIUsuario" type = "text" name = "DNIuser" placeholder = "DNI de Usuario" onfocus = "this.placeholder = \'\'" onblur = "this.placeholder =\'DNI del Usuario\'"><br><br>
						<input id = "contraUsuario" type = "password" name = "password" minlength="8" placeholder = "Contraseña" onfocus = "this.placeholder = \'\'" onblur = "this.placeholder =\'Contraseña\'" required> <br><br>
						<input type="submit" name = "login" value="Acceder" style="width: 100%;">
						<p class="NewUser"> <a href="./Registro.php">*Registrate si no lo estas </a></p>
					</div>
				</form>
			</div>';
			} 
		?>

	</div>
</body>
</html>