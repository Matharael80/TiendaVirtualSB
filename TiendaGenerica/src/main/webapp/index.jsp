<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilos.css">
    <title>Inicio Sesion | Tienda Virtual</title>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Ranchers&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="shortcut icon" href="img/icono.png" />
</head>

<body>

	<%//@ page import = "com.BO.TiendaVirtualSB.*" %>
	
    <div class="container">
        <div class="row pt-4">
            <div class="col">
                <div class="card">
                    <div class="card-body text-center">
                        <H1 class="text-center"><img src="img/icono.png" alt="" width="150" height="150"
                         	class="center"><b>Tienda Virtual</b></H1>
                    </div>
                </div>
            </div>
        </div>
        <div class="row pt-4 ">
            <div class="col-12 text-justify">
                <div class="card">
                    <div class="card-body text-center">
                        <h1>Bienvenidos a la Tienda Genérica</h1><br>
                         <!--Formulario-->
                         <div class="text-center">
                         
                         
                            <form action="/servletlogin" method="get">
                                <div class="form-group">
                                    <label>Usuario</label>
                                    <input type="text" class="field" name="usuario" placeholder="Escribe tu usuario" required>
                                </div>
                                
                                <div class="form-group">
                                    <label>Contraseña</label>
                                    <input type="password" class="field" name="password" placeholder="Escribe tu contraseña" required class="form-control"><br />
                                </div>
                                
                                <% 
                                	if(request.getAttribute("usuario") != null) {
                                		//out.println(usuario);
                                		//out.println(password);

								//String usuario = (String)request.getAttribute("usuario");
								//String password = (String)request.getAttribute("password");
								String validacion = (String)request.getAttribute("validacion");
								%>
								<p style="color:red;"> <%= validacion%> </p>
								<% 
								}
								%>

                                <a class="text-decoration-underline" href="">Olvidaste tu contraseña?</a><br><br />

                                <input type="submit" class="btn btn-primary" name="aceptar" value="Aceptar">
                                <input type="submit" class="btn btn-primary" name="cancelar" value="Cancelar">
                                
                            </form>
                    </div>
                </div>
            </div>
        </div>   
    
            </div>
        </div>

       

   

    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
</body>

</html>