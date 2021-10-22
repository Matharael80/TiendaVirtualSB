<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.BO.TiendaVirtualSB.ClienteController"%>
<%@page import="com.DTO.TiendaVirtualSB.ClienteVO"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilos.css">
    <title>Ventas por Cliente | Tienda Virtual</title>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&family=Ranchers&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="../css/fontello.css">
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
                        <a href="Clientes.jsp" class="nav-link">Clientes</a>
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
	<br>
	
    <div class="container">
        <div class="row pt-4">
            <div class="col">
                <div class="card">
                    <div class="card-body text-center">
                        <H1 class="text-center"><img src="img/ventas.png" alt="" width="150" height="150"
                                class="center"><b>Total de ventas por cliente</b></H1>
                    </div>
                </div>
            </div>
        </div>
        <div class="row pt-4 ">
        	<% 
		        ArrayList<ClienteVO> ListaCliente = new ArrayList<ClienteVO>();      
		        ClienteController cliCtrl = new ClienteController();
		        ListaCliente = cliCtrl.ventasCliente();                
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
                                <th scope="col">Valor Total Ventas</th>
                              </tr>
                            </thead>
                            <tbody>
                              <%
	                            double total_ventas = 0;
                              
	                            for (int i=0;i<ListaCliente.size();i++) {
	                                ClienteVO cliente = new ClienteVO();
	                                cliente = ListaCliente.get(i);	                                                  
	                            	total_ventas = total_ventas + cliente.getValorVentas();
	                            %>
	                              <tr>
	                                <th scope="row"><%out.print(i+1); %></th>
	                                <td><%out.print(String.valueOf(cliente.getCedula()));%></td>
	                                <td><%out.print(cliente.getNombre_cliente());%></td>
	                                <td><%out.print(String.valueOf(cliente.getValorVentas()));%></td>
	                              </tr>
	                              <%
	                              
	                                }
                              
	                              %>     
                            </tbody>
                          </table>
                          <form action="">
                            <div class="">
                                <label>Total Ventas $</label>
                                <input type="number" class="field" name="ventas" placeholder="ventas" readonly value="<%=total_ventas%>">
                            </div>
                        </form>
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