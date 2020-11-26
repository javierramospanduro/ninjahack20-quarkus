<?PHP


?>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" style="height: 254px; ">
	<head>
  		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet">
		<link rel='stylesheet' href = "css/Comun.css" type = "text/css">
		<link rel='stylesheet' href = "css/Registro.css" type = "text/css">
		<title>Datos Usuario</title>
	</head>
  <body>

		<div id="contenedorPeque">
		<div class="titulo"><img src=".\imagenes\LogoBBVA.png" class="LogoPeq"><h3>Creación Usuario Padre</h3></div>

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
							<label for="fname">Nombre</label>
							<input type="text" name="name" value ="">
							<label for="fname">Pass</label>
							<input type="Password" name="Contrasena" minlength="8" value ="">
							<label for="fname">DNI</label>
							<input type="text" name="DNI" required value ="" pattern="[0-9]{8}[A-Za-z]{1}">
							<label for="fname">Correo del usuario</label>
							<input type="email" name="mailUser" required value ="">
							</td>
						</tr>
						
					</table>
					<input type="submit" id="Crear" name="Crear" value="Siguiente" style="width: 100%;" onclick="location.href='./RegistroH.php';">

					</form>
			</div>
		</div>	
</body>
</html>