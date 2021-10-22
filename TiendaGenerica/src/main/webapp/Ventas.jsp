<%@page import="com.BO.TiendaVirtualSB.VentaController"%>
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
    <form action="/servletVentas" method="get" class="col-sm-12">
    
		<div align="center">
         <table cellpadding="5">
           <tbody>
           	<tr>
               <td><label for="textfield">Cédula</label></td>
               <td>&nbsp;</td>
               <td><label for="textfield2">Cliente</label></td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td><label for="textfield3">Consecutivo</label></td>
             </tr>
             <tr>
               <td>
               		<%
						String cedula_cliente = (String)request.getAttribute("cedula_cliente");
						if(cedula_cliente == null)cedula_cliente = "";
					%>
               		<input type="number" class="field" name="cedula_cliente" placeholder="Cédula del cliente" required value="<%=cedula_cliente%>">
               </td>
               <td><input type="submit" class="btn btn-primary" value="Consultar" name="boton_cliente"></td>
               <%
					String nombre_cliente = (String)request.getAttribute("nombre_cliente");
					if(nombre_cliente == null)nombre_cliente = "";
				%>
               <td><input type="text" name="nombre_cliente" placeholder="Nombre de cliente" readonly value="<%=nombre_cliente%>"></td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <%
               		VentaController ventCtrl = new VentaController();
					int consecutivo = ventCtrl.consultarUltimaVenta() + 1;
				%>
               <td><input type="text" name="texto_consecutivo" readonly value="<%=consecutivo%>"></td>
             </tr>
           </tbody>
          </table>
     	<% 
         	if(request.getAttribute("validacion_usuario") != null) {
                		
				String validacion_usuario = (String)request.getAttribute("validacion_usuario");
			%>
			<p style="color:red;"> <%= validacion_usuario%> </p>
			<% 
			}
         	else {
         	%>
         		<div>
                	<label>&nbsp;</label>
              	</div>
             <%
         	}
		%>
       </div>
       
       <div align="center">
         <table border="0" cellpadding="5">
           <tbody>
             <tr align="center">
               <td>Cod. Producto</td>
               <td>&nbsp;</td>
               <td>Nombre Producto</td>
               <td>Valor Unitario</td>
               <td>Cantidad</td>
               <td>Valor Total</td>
             </tr>
             <tr>
               <td>
               <%
					String codigo_producto1 = (String)request.getAttribute("codigo_producto1");
					if(codigo_producto1 == null)codigo_producto1 = "";
				%>
               <input type="number" name="codigo_producto1" placeholder="Código de producto" value="<%=codigo_producto1%>"></td>
               <td><input type="submit" class="btn btn-primary" value="Consultar" name="boton_producto1"></td>
               <%
					String nombre_producto1 = (String)request.getAttribute("nombre_producto1");
					if(nombre_producto1 == null)nombre_producto1 = "";
				%>
               <td><input type="text" name="nombre_producto1" placeholder="Nombre de producto" readonly value="<%=nombre_producto1%>"></td>
               <%
					String precio_producto1 = (String)request.getAttribute("precio_producto1");
					if(precio_producto1 == null)precio_producto1 = "";
				%>
               <td><input type="number" name="precio_producto1" placeholder="Valor de producto" readonly value="<%=precio_producto1%>"></td>
               <%
					String cantidad_producto1 = (String)request.getAttribute("cantidad_producto1");
					if(cantidad_producto1 == null)cantidad_producto1 = "";
				%>
               <td><input type="number" name="cantidad_producto1" placeholder="Cantidad de productos" value="<%=cantidad_producto1%>"></td>
               <%
					String total_producto1 = (String)request.getAttribute("total_producto1");
					if(total_producto1 == null)total_producto1 = "";
				%>
               <td><input type="number" name="total_producto1" placeholder="Total de producto" readonly value="<%=total_producto1%>"></td>
             </tr>
             	<% 
         			if(request.getAttribute("validacion_producto1") != null) {
                		
					String validacion_producto1 = (String)request.getAttribute("validacion_producto1");
				%>
					<tr>
    					<td style="color:red;"> <%= validacion_producto1%> </td>
					</tr>
				<% 
         			}
				%>
             <tr>
               <td>
               <%
					String codigo_producto2 = (String)request.getAttribute("codigo_producto2");
					if(codigo_producto2 == null)codigo_producto2 = "";
				%>
               <input type="number" name="codigo_producto2" placeholder="Código de producto" value="<%=codigo_producto2%>"></td>
               <td><input type="submit" class="btn btn-primary" value="Consultar" name="boton_producto2"></td>
               <%
					String nombre_producto2 = (String)request.getAttribute("nombre_producto2");
					if(nombre_producto2 == null)nombre_producto2 = "";
				%>
               <td><input type="text" name="nombre_producto2" placeholder="Nombre de producto" readonly value="<%=nombre_producto2%>"></td>
               <%
					String precio_producto2 = (String)request.getAttribute("precio_producto2");
					if(precio_producto2 == null)precio_producto2 = "";
				%>
               <td><input type="number" name="precio_producto2" placeholder="Valor de producto" readonly value="<%=precio_producto2%>"></td>
               <%
					String cantidad_producto2 = (String)request.getAttribute("cantidad_producto2");
					if(cantidad_producto2 == null)cantidad_producto2 = "";
				%>
               <td><input type="number" name="cantidad_producto2" placeholder="Cantidad de productos" value="<%=cantidad_producto2%>"></td>
               <%
					String total_producto2 = (String)request.getAttribute("total_producto2");
					if(total_producto2 == null)total_producto2 = "";
				%>
               <td><input type="number" name="total_producto2" placeholder="Total de producto" readonly value="<%=total_producto2%>"></td>
             </tr>
             	<% 
         			if(request.getAttribute("validacion_producto2") != null) {
                		
					String validacion_producto2 = (String)request.getAttribute("validacion_producto2");
				%>
					<tr>
    					<td style="color:red;"> <%= validacion_producto2%> </td>
					</tr>
				<% 
         			}
				%>
             <tr>
               <td>
               <%
					String codigo_producto3 = (String)request.getAttribute("codigo_producto3");
					if(codigo_producto3 == null)codigo_producto3 = "";
				%>
               <input type="number" name="codigo_producto3" placeholder="Código de producto" value="<%=codigo_producto3%>"></td>
               <td><input type="submit" class="btn btn-primary" value="Consultar" name="boton_producto3"></td>
               <%
					String nombre_producto3 = (String)request.getAttribute("nombre_producto3");
					if(nombre_producto3 == null)nombre_producto3 = "";
				%>
               <td><input type="text" name="nombre_producto3" placeholder="Nombre de producto" readonly value="<%=nombre_producto3%>"></td>
               <%
					String precio_producto3 = (String)request.getAttribute("precio_producto3");
					if(precio_producto3 == null)precio_producto3 = "";
				%>
               <td><input type="number" name="precio_producto3" placeholder="Valor de producto" readonly value="<%=precio_producto3%>"></td>
               <%
					String cantidad_producto3 = (String)request.getAttribute("cantidad_producto3");
					if(cantidad_producto3 == null)cantidad_producto3 = "";
				%>
               <td><input type="number" name="cantidad_producto3" placeholder="Cantidad de productos" value="<%=cantidad_producto3%>"></td>
               <%
					String total_producto3 = (String)request.getAttribute("total_producto3");
					if(total_producto3 == null)total_producto3 = "";
				%>
               <td><input type="number" name="total_producto3" placeholder="Total de producto" readonly value="<%=total_producto3%>"></td>
             </tr>
             	<% 
         			if(request.getAttribute("validacion_producto3") != null) {
                		
					String validacion_producto3 = (String)request.getAttribute("validacion_producto3");
				%>
					<tr>
    					<td style="color:red;"> <%= validacion_producto3%> </td>
					</tr>
				<% 
         			}
				%>
             <tr>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td align="right">Total Venta</td>
               <%
					String total_venta = (String)request.getAttribute("total_venta");
					if(total_venta == null)total_venta = "";
				%>
               <td><input type="number" name="total_venta" placeholder="Total de la Venta" readonly value="<%=total_venta%>"></td>
             </tr>
             <tr>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td align="right">IVA</td>
               <%
					String iva_venta = (String)request.getAttribute("iva_venta");
					if(iva_venta == null)iva_venta = "";
				%>
               <td><input type="number" name="iva_venta" placeholder="IVA de la Venta" readonly value="<%=iva_venta%>"></td>
             </tr>
             <tr>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
               <td align="right"><h5><b>Total con IVA</b></h5></td>
               <%
					String total_final = (String)request.getAttribute("total_final");
					if(total_final == null)total_final = "";
				%>
               <td><input type="number" name="total_final" class="font-weight-bold" placeholder="Gran Total" readonly value="<%=total_final%>"></td>
             </tr>
           </tbody>
          </table>
          	<% 
       			if(request.getAttribute("mensaje_validacion") != null) {
              		
				String mensaje_validacion = (String)request.getAttribute("mensaje_validacion");
			%>
				<p style="color:red;"> <%= mensaje_validacion%> </p>
			<% 
	     		}
			%>
			
          <p class="lead">
     		<input type="submit" class="boton_personalizado" name="botonCalcular" value="Calcular">
     		<input type="submit" class="boton_personalizado" name="botonConfirmar" value="Confirmar">
    	</p>
       </div>
     </form>  
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
   
    
</body>

</html>