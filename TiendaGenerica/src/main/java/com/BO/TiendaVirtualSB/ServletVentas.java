package com.BO.TiendaVirtualSB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.DTO.TiendaVirtualSB.ClienteVO;
import com.DTO.TiendaVirtualSB.ProductoVO;
import com.DTO.TiendaVirtualSB.VentaVO;

@WebServlet("/servletVentas")
public class ServletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String cedula_cliente ="";
	String nombre_cliente ="";
	String codigo_producto1 ="";
	String codigo_producto2 ="";
	String codigo_producto3 ="";
	String nombre_producto1 ="";
	String nombre_producto2 ="";
	String nombre_producto3 ="";
	String precio_producto1 ="";
	String precio_producto2 ="";
	String precio_producto3 ="";
	String cantidad_producto1 ="";
	String cantidad_producto2 ="";
	String cantidad_producto3 ="";
	String mensaje_validacion ="";
	HttpServletRequest request;
	HttpServletResponse response;
       
    public ServletVentas() {
        //super();
    }
	
	protected void doGet(HttpServletRequest requestJsp, HttpServletResponse responseJsp) throws ServletException, IOException {
		
		request = requestJsp;
		response = responseJsp;
		mensaje_validacion = "";
		
		ProductoVO product;
		ClienteVO client = new ClienteVO();
		ClienteController clientCtrl = new ClienteController();
		VentaController ventaCtrl = new VentaController();
		ProductoController productCtrl = new ProductoController();
		
		getParametrosRequest();
		
		if (request.getParameter("boton_cliente") != null) {
			
			System.out.println("Boton Cliente");
			
			client = clientCtrl.consultar(Integer.parseInt(cedula_cliente));
			
	        if (client != null) {
	        	System.out.println("Cliente Encontrado!!");
	        	nombre_cliente = client.getNombre_cliente();
	        } else request.setAttribute("validacion_usuario", "Cliente Inexistente");
		}

		else if (request.getParameter("boton_producto1") != null) {
			
			System.out.println("Boton Producto 1");
			
			if(codigo_producto1.equals(""))
			{
				nombre_producto1 = "";
				precio_producto1 = "";
	        	request.setAttribute("validacion_producto1", "Debe ingresar un código");
			}
			else {
				product = new ProductoVO();
				product = productCtrl.consultar(Integer.parseInt(codigo_producto1));
				
		        if (product != null) {
		        	System.out.println("Producto Encontrado!!");
		        	nombre_producto1 = product.getNombre_producto();
		        	precio_producto1 = String.valueOf(product.getPrecio_venta());
		        } else request.setAttribute("validacion_producto1", "Producto Inexistente");
			}
		}
		
		else if (request.getParameter("boton_producto2") != null) {
			
			System.out.println("Boton Producto 2");
			
			if(codigo_producto2.equals(""))
			{
				nombre_producto2 = "";
				precio_producto2 = "";
	        	request.setAttribute("validacion_producto2", "Debe ingresar un código");
			}
			else {
				product = new ProductoVO();
				product = productCtrl.consultar(Integer.parseInt(codigo_producto2));
				
		        if (product != null) {
		        	System.out.println("Producto Encontrado!!");
		        	nombre_producto2 = product.getNombre_producto();
		        	precio_producto2 = String.valueOf(product.getPrecio_venta());
		        } else request.setAttribute("validacion_producto2", "Producto Inexistente");
			}
		}
		
		else if (request.getParameter("boton_producto3") != null) {
			
			System.out.println("Boton Producto 3");
			
			if(codigo_producto3.equals(""))
			{
				nombre_producto3 = "";
				precio_producto3 = "";
	        	request.setAttribute("validacion_producto3", "Debe ingresar un código");
			}
			else {
				product = new ProductoVO();
				product = productCtrl.consultar(Integer.parseInt(codigo_producto3));
				
		        if (product != null) {
		        	System.out.println("Producto Encontrado!!");
		        	nombre_producto3 = product.getNombre_producto();
		        	precio_producto3 = String.valueOf(product.getPrecio_venta());
		        } else request.setAttribute("validacion_producto3", "Producto Inexistente");
			}
		}
		
		else if (request.getParameter("botonCalcular") != null) {
			
			System.out.println("Boton Calcular");
			double total = 0;
			double total_venta = 0;
			double iva = 0;
			double total_iva = 0;
			double total_final = 0;
			
			if(!precio_producto1.equals("") && !cantidad_producto1.equals("")) {
				System.out.println("Calculo de Producto 1");
	        	if(Double.parseDouble(cantidad_producto1)>0) {
	        		total = Double.parseDouble(precio_producto1) * Double.parseDouble(cantidad_producto1);
		        	request.setAttribute("total_producto1", String.valueOf(total));
		        	total_venta = total_venta + total;
		        	iva = total*0.19;
		        	total_iva = total_iva + iva;
	        	}
	        	else mensaje_validacion = "La cantidad del producto 1 debe ser mayor a 0";
			}
			
			else if(!precio_producto1.equals("") && cantidad_producto1.equals("")) {
				mensaje_validacion = "Ingrese la cantidad del producto 1";
			}
			
			if(!precio_producto2.equals("") && !cantidad_producto2.equals("")) {
				System.out.println("Calculo de Producto 2");
	        	if(Double.parseDouble(cantidad_producto2)>0) {
	        		total = Double.parseDouble(precio_producto2)*Double.parseDouble(cantidad_producto2);
		        	request.setAttribute("total_producto2", String.valueOf(total));
		        	total_venta = total_venta + total;
		        	iva = total*0.19;
		        	total_iva = total_iva + iva;
	        	}
	        	else mensaje_validacion = "La cantidad del producto 2 debe ser mayor a 0";
			}
			
			else if(!precio_producto2.equals("") && cantidad_producto2.equals("")) {
				mensaje_validacion = "Ingrese la cantidad del producto 2";
			}
			
			if(!precio_producto3.equals("") && !cantidad_producto3.equals("")) {
				System.out.println("Calculo de Producto 3");
	        	if(Double.parseDouble(cantidad_producto3)>0) {
	        		total = Double.parseDouble(precio_producto3)*Double.parseDouble(cantidad_producto3);
		        	request.setAttribute("total_producto3", String.valueOf(total));
		        	total_venta = total_venta + total;
		        	iva = total*0.19;
		        	total_iva = total_iva + iva;
	        	}
	        	else mensaje_validacion = "La cantidad del producto 3 debe ser mayor a 0";
			}
			
			else if(!precio_producto3.equals("") && cantidad_producto3.equals("")) {
				mensaje_validacion = "Ingrese la cantidad del producto 3";
			}
			
			if(precio_producto1.equals("") && precio_producto2.equals("") && precio_producto3.equals("")) {
	        	System.out.println("No se consulto producto!");
	        	mensaje_validacion = "Debe ingresar por lo menos un producto";
			}
			
			if(total_venta != 0) {
	        	System.out.println("Si hubo productos de venta");
	        	total_venta = Math.round(total_venta*100.0)/100.0;
	        	total_iva = Math.round(total_iva*100.0)/100.0;
	        	total_final = Math.round(((total_venta + total_iva)*100.0)/100.0);
	        	
	        	request.setAttribute("total_venta", String.valueOf(total_venta));
	        	request.setAttribute("iva_venta", String.valueOf(total_iva));
	        	request.setAttribute("total_final", String.valueOf(total_final));
			}
		}
		
		else if (request.getParameter("botonConfirmar") != null) {
			
			System.out.println("Boton Confirmar");
			VentaVO venta = new VentaVO();
			HttpSession session = request.getSession(false);
			String cedula_usuario = String.valueOf(session.getAttribute("cedula_usuario"));
			int consecutivo = ventaCtrl.consultarUltimaVenta() + 1;
			String total_iva = request.getParameter("iva_venta");
			String total_venta = request.getParameter("total_venta");
			String total_final = request.getParameter("total_final");
			
	        if (cedula_usuario != "" && cedula_cliente != "" && nombre_cliente != "" && total_iva != "" && total_venta != "" && total_final  != "") {
	        	System.out.println("Campos completos!!");
	        	
	        	venta.setCodigo(consecutivo);
	        	venta.setCedula_cliente(Integer.parseInt(cedula_cliente));
	        	venta.setCedula_usuario(Integer.parseInt(cedula_usuario));
	        	venta.setIVA_venta(Double.parseDouble(total_iva));
	        	venta.setTotal_venta(Double.parseDouble(total_venta));
	        	venta.setValor_venta(Double.parseDouble(total_final));
			
		        if (ventaCtrl.crear(venta)) {
		        	
		        	System.out.println("Venta registrada!!");
		        	mensaje_validacion = "Venta registrada";
		        	limpiarParametros();
		        	
		        } else {
		        	mensaje_validacion = "No se pudo registrar la venta";
				}
	        }
	        else {
	        	mensaje_validacion = "Primero debe calcular la venta";
	        }
		}
		setAtributosRequest();
		responseRequest();
	}
	
	private void getParametrosRequest() {
		cedula_cliente = request.getParameter("cedula_cliente");
		nombre_cliente = request.getParameter("nombre_cliente");
		codigo_producto1 = request.getParameter("codigo_producto1");
		codigo_producto2 = request.getParameter("codigo_producto2");
		codigo_producto3 = request.getParameter("codigo_producto3");
		nombre_producto1 = request.getParameter("nombre_producto1");
		nombre_producto2 = request.getParameter("nombre_producto2");
		nombre_producto3 = request.getParameter("nombre_producto3");
		precio_producto1 = request.getParameter("precio_producto1");
		precio_producto2 = request.getParameter("precio_producto2");
		precio_producto3 = request.getParameter("precio_producto3");
		cantidad_producto1 = request.getParameter("cantidad_producto1");
		cantidad_producto2 = request.getParameter("cantidad_producto2");
		cantidad_producto3 = request.getParameter("cantidad_producto3");
	}
	
	private void setAtributosRequest() {
		request.setAttribute("cedula_cliente", cedula_cliente);
		request.setAttribute("nombre_cliente", nombre_cliente);
		request.setAttribute("codigo_producto1", codigo_producto1);
		request.setAttribute("codigo_producto2", codigo_producto2);
		request.setAttribute("codigo_producto3", codigo_producto3);
		request.setAttribute("nombre_producto1", nombre_producto1);
		request.setAttribute("nombre_producto2", nombre_producto2);
		request.setAttribute("nombre_producto3", nombre_producto3);
		request.setAttribute("precio_producto1", precio_producto1);
		request.setAttribute("precio_producto2", precio_producto2);
		request.setAttribute("precio_producto3", precio_producto3);
		request.setAttribute("cantidad_producto1", cantidad_producto1);
		request.setAttribute("cantidad_producto2", cantidad_producto2);
		request.setAttribute("cantidad_producto3", cantidad_producto3);
		request.setAttribute("mensaje_validacion", mensaje_validacion);
	}
	
	private void limpiarParametros() {
		cedula_cliente = "";
		nombre_cliente = "";
		codigo_producto1 = "";
		codigo_producto2 = "";
		codigo_producto3 = "";
		nombre_producto1 = "";
		nombre_producto2 = "";
		nombre_producto3 = "";
		precio_producto1 = "";
		precio_producto2 = "";
		precio_producto3 = "";
		cantidad_producto1 = "";
		cantidad_producto2 = "";
		cantidad_producto3 = "";
	}
	
	private void responseRequest() throws ServletException, IOException {
		request.getRequestDispatcher("Ventas.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
