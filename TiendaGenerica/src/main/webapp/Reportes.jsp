<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/estilos.css" />
    <title>Tienda Virtual</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Ranchers&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="../css/fontello.css" />
    <link rel="shortcut icon" href="img/icono.png" />
  </head>
  <body>
  
  	<%	
		String cedula = String.valueOf(session.getAttribute("cedula_usuario"));
		String name=(String)session.getAttribute("nombre_usuario");
        if(name != null) { 
        	System.out.println("Hola, "+name+" con cédula " + cedula +" a su perfil!");
        } else {  
		    System.out.println("Debe hacer login primero"); 
		    %><jsp:forward page="index.jsp" /><%
		}
    %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
      <h1 class="card-title">Tienda Genérica </h1>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbar"
          aria-controls="navbar"
          aria-expanded="false"
          aria-label="Menu Navegacion "
        >
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
            <li class="nav-item">
              <a href="Proveedores.jsp" target="_self" class="nav-link">Proveedores</a>
            </li>
            <li class="nav-item">
              <a href="Productos.jsp" target="_self" class="nav-link">Productos</a>
            </li>
            <li class="nav-item">
              <a href="Ventas.jsp" target="_self" class="nav-link">Ventas</a>
            </li>
            <li class="nav-item active">
              <a href="Reportes.jsp" target="_self" class="nav-link">Reportes</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <br />   
    <div class="text-center pt-4">
      <a class="boton_personalizado" href="ListadoUsuarios.jsp">Listado de Usuarios</a>
      <a class="boton_personalizado" href="ListadoClientes.jsp">Listado de Clientes</a>
      <a class="boton_personalizado" href="VentasCliente.jsp">Ventas por Cliente</a>
    </div>
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</body>
</html>