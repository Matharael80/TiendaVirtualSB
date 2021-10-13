<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                    <li class="nav-item">
                        <a href="Proveedores.jsp" target="_self" class="nav-link">Proveedores</a>
                    </li>
                    <li class="nav-item">
                        <a href="Productos.jsp" target="_self" class="nav-link">Productos</a>
                    </li>
                    <li class="nav-item active">
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
    <form class = "form-inline" role = "form"> 
        <div class = "form-group"> 
          <label for = "email"> Dirección de correo electrónico: </label> 
          <input type = "email" class = " form-control "id =" email "> 
        </div> 
        <div class =" form-group "> 
          <label for =" pwd "> Contraseña: </label> 
          <input type =" password "class =" form- control "id =" pwd "> 
        </div>         
        <button type =" submit "class = "btn btn-default"> Enviar </button>    
    
    <br><br> <br><br><hr>
    
        <a class="boton_personalizado" href="#">Consultar</a>
        <a class="boton_personalizado" href="#">Crear</a>
        <a class="boton_personalizado" href="#">Actualizar</a>
        <a class="boton_personalizado" href="#">Borrar</a>

    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    </form>
    
</body>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>