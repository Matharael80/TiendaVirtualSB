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
    <title>Tienda Virtual</title>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Ranchers&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="shortcut icon" href="img/icono.png" />
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
        		<h1 class="card-title">Tienda Genérica </h1>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar"
                aria-controls="navbar" aria-expanded="false" aria-label="Menu Navegacion ">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a href="Usuarios.jsp" class="nav-link">Usuarios</a>
                    </li>
                    <li class="nav-item ">
                        <a href="Clientes.jsp" target="_self" class="nav-link">Clientes</a>
                    </li>
                    <li class="nav-item ">
                        <a href="Proveedores.jsp" target="_self" class="nav-link">Proveedores</a>
                    </li>
                    <li class="nav-item active">
                        <a href="Productos.jsp" target="_self" class="nav-link">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a href="Ventas.jsp" target="_self" class="nav-link">Ventas</a>
                    </li>
                    <li class="nav-item">
                        <a href="Reportes.jsp" target="_self" class="nav-link">Reportes</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <div class="row pt-4">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <br><br><br>
                    <form action="/servletArchivo" method="post" enctype="multipart/form-data">
                        <div class="text-center">
                            <div class="form-group">
                                    <label>Nombre del Archivo</label>
	                        </div>
	                            <div class="col-auto">
	                                <input type="file" name="archivo" accept=".csv" class="btn btn-primary mb-2">
	                            </div>
	                            <% 
				                	if(request.getAttribute("validacion") != null) {
				                		
									String validacion = (String)request.getAttribute("validacion");
									%>
									<p style="color:red;"> <%= validacion%> </p>
									<% 
									}
								%>
	                            <div class="col-auto">
	                                <input type="submit" value="Cargar" class="boton_personalizado">
	                            </div>
                        	</div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>