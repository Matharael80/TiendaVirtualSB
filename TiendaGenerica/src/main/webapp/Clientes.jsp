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
                        <a href="Usuarios.jsp" target="_self" class="nav-link">Usuarios</a>
                    </li>
                    <li class="nav-item active">
                        <a href="Clientes.jsp" class="nav-link">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a href="Proveedores.jsp" target="_self" class="nav-link">Proveedores</a>
                    </li>
                    <li class="nav-item">
                        <a href="Productos.jsp" target="_self" class="nav-link">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a href="Ventas.html" target="_self" class="nav-link">Ventas</a>
                    </li>
                    <li class="nav-item">
                        <a href="Reportes.html" target="_self" class="nav-link">Reportes</a>
                    </li>

                </ul>

            </div>

        </div>

    </nav>
	<br>
	    
	
	<div class="row pt-4s" align="center">
	    
	    	<div class="col-sm-12">
	    		<form action="/servletClientes" method="get" >
	        		<div class="card" id="card-2">
	          		<div class="card-body">
						<div class="text-center">
							<div class="form-group">
								<label>Cédula</label>
								<%
									String cedula_cliente = (String)request.getAttribute("cedula_cliente");
									if(cedula_cliente == null)cedula_cliente = "";
								%>
								<input type="number" class="field"
									name="cedula_cliente" placeholder="Escribe tu cédula" required value="<%=cedula_cliente%>">
							</div>
							<div class="form-group">
								<label>Nombre Completo</label>
								<%
									String nombre_cliente = (String)request.getAttribute("nombre_cliente");
									if(nombre_cliente == null)nombre_cliente = "";
								%>
								<input type="text" pattern="[A-Za-z ]+" class="field"
									name="nombre_cliente" placeholder="Escribe tu nombre completo" value="<%=nombre_cliente%>"><br />	
							</div>
							<div class="form-group">
								<label>Dirección</label>
								<%
									String direccion_cliente = (String)request.getAttribute("direccion_cliente");
									if(direccion_cliente == null)direccion_cliente = "";
								%>
								<input type="text" class="field"
									name="direccion_cliente" placeholder="Escribe tu dirección" value="<%=direccion_cliente%>">
							</div>
							<div class="form-group">
								<label>Teléfono</label>
								<%
									String telefono_cliente = (String)request.getAttribute("telefono_cliente");
									if(telefono_cliente == null)telefono_cliente = "";
								%>
								<input type="number" class="field"
									name="telefono_cliente" placeholder="Escribe tu teléfono"
									class="form-control" value="<%=telefono_cliente%>">
							</div>
							<div class="form-group">
								<label>Correo Electrónico</label>
								<%
									String email_cliente = (String)request.getAttribute("email_cliente");
									if(email_cliente == null)email_cliente = "";
								%>
								<input type="email"
									class="field" name="email_cliente"
									placeholder="Escribe tu correo electrónico" value="<%=email_cliente%>"><br />
							</div>
						</div>
					</div>
                </div>
            
				<% 
                	if(request.getAttribute("validacion") != null) {
                		
					String validacion = (String)request.getAttribute("validacion");
					%>
					<p style="color:red;"> <%= validacion%> </p>
					<% 
				}
				%>
	    <hr>
	    	
	   	<input type="submit" class="boton_personalizado" name="botonConsultar" value="Consultar">
		<input type="submit" class="boton_personalizado" name="botonActualizar" value="Actualizar">
		<input type="submit" class="boton_personalizado" name="botonCrear" value="Crear">
		<input type="submit" class="boton_personalizado" name="botonBorrar" value="Borrar">
	
	    <script src="../js/jquery-3.5.1.min.js"></script>
	    <script src="../js/popper.min.js"></script>
	    <script src="../js/bootstrap.min.js"></script>
	    
		</form>
	</div>
	</div>
</body>

</html>