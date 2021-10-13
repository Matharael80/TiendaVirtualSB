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
                    <li class="nav-item">
                        <a href="Clientes.jsp" target="_self" class="nav-link">Clientes</a>
                    </li>
                    <li class="nav-item active">
                        <a href="Proveedores.jsp" class="nav-link">Proveedores</a>
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
	    		<form action="/servletProveedores" method="get" >
	        		<div class="card" id="card-2">
	          		<div class="card-body">
						<div class="text-center">
							<div class="form-group">
								<label>NIT</label>
								<%
									String nit_proveedor = (String)request.getAttribute("nit_proveedor");
									if(nit_proveedor == null)nit_proveedor = "";
								%>
								<input type="number" class="field"
									name="nit_proveedor" placeholder="Escribe tu NIT" required value="<%=nit_proveedor%>">
							</div>
							<div class="form-group">
								<label>Nombre Proveedor</label>
								<%
									String nombre_proveedor = (String)request.getAttribute("nombre_proveedor");
									if(nombre_proveedor == null)nombre_proveedor = "";
								%>
								<input type="text" pattern="[A-Za-z ]+" class="field"
									name="nombre_proveedor" placeholder="Escribe tu nombre" value="<%=nombre_proveedor%>"><br />	
							</div>
							<div class="form-group">
								<label>Dirección</label>
								<%
									String direccion_proveedor = (String)request.getAttribute("direccion_proveedor");
									if(direccion_proveedor == null)direccion_proveedor = "";
								%>
								<input type="text" class="field"
									name="direccion_proveedor" placeholder="Escribe tu dirección" value="<%=direccion_proveedor%>">
							</div>
							<div class="form-group">
								<label>Teléfono</label>
								<%
									String telefono_proveedor = (String)request.getAttribute("telefono_proveedor");
									if(telefono_proveedor == null)telefono_proveedor = "";
								%>
								<input type="number" class="field"
									name="telefono_proveedor" placeholder="Escribe tu teléfono"
									class="form-control" value="<%=telefono_proveedor%>">
							</div>
							<div class="form-group">
								<label>Ciudad</label>
								<%
									String ciudad_proveedor = (String)request.getAttribute("ciudad_proveedor");
									if(ciudad_proveedor == null)ciudad_proveedor = "";
								%>
								<input type="text"
									class="field" name="ciudad_proveedor"
									placeholder="Escribe tu ciudad" value="<%=ciudad_proveedor%>"><br />
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