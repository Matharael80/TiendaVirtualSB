<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.BO.TiendaVirtualSB.UsuarioController"%>
<%@page import="com.DTO.TiendaVirtualSB.UsuarioVO"%>
   
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilos.css">
    <title>Listado de Usuarios | Tienda Virtual</title>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Ranchers&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="shortcut icon" href="img/icono.png" />
</head>
<body>
    <div class="container">
        <div class="row pt-4">
            <div class="col">
                <div class="card">
                    <div class="card-body text-center">
                        <H1 class="text-center"><img src="img/usuario.png" alt="" width="150" height="150"
                                class="center"><b>Listado de Usuarios</b></H1>
                    </div>
                </div>
            </div>
        </div>
        <div class="row pt-4 ">
        <% 
        ArrayList<UsuarioVO> ListaUsuarios = new ArrayList<UsuarioVO>();      
        UsuarioController usuCtrl = new UsuarioController();
        ListaUsuarios = usuCtrl.listarUsuario();                
        %>
            <div class="col-12 text-justify">
                <div class="card">
                    <div class="card-body text-center">
                        <table class="table table-hover table-dark">
                            <thead>
                              <tr>
                                <th scope="col">#</th>
                                <th scope="col">Cédula</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Correo Electrónico</th>
                                <th scope="col">Usuario</th>
                                <th scope="col">Password</th>
                              </tr>
                            </thead>                                                    
	                            <tbody>
	                            <%
	                            
	                            for (int i=0;i<ListaUsuarios.size();i++) {
	                                UsuarioVO usuario = new UsuarioVO();
	                                usuario = ListaUsuarios.get(i);	                                                  
	                            
	                            %>
	                              <tr>
	                                <th scope="row"><%out.print(i+1); %></th>
	                                <td><%out.print(String.valueOf(usuario.getCedula_usuario()));%></td>
	                                <td><%out.print(usuario.getNombre_usuario());%></td>
	                                <td><%out.print(usuario.getEmail_usuario());%></td>
	                                <td><%out.print(usuario.getUsuario());%></td>
	                                <td><%out.print(usuario.getPassword());%></td>    
	                              </tr>
	                              <%
	                              
	                                }
	                            
	                              %>
	                              
	                            </tbody>                            
                    	</table>
                    </div>
                </div>
            </div>
        </div>    
    </div>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
</body>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</body>
</html>