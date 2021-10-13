package com.BO.TiendaVirtualSB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DTO.TiendaVirtualSB.ClienteVO;
//import java.util.ArrayList;
//import java.io.PrintWriter;

@WebServlet("/servletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletClientes() {
        //super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteVO client = new ClienteVO();
		ClienteController clientCtrl = new ClienteController();
		
		if (request.getParameter("botonConsultar") != null) {
			
			System.out.println("Boton Consultar");
			String cedula = request.getParameter("cedula_cliente");
			
			client = clientCtrl.consultar(Integer.parseInt(cedula));
			
	        if (client != null) {
	        	System.out.println("Cliente Encontrado!!");
	        	request.setAttribute("cedula_cliente", cedula);
	        	request.setAttribute("direccion_cliente", client.getDireccion());
	        	request.setAttribute("email_cliente", client.getEmail());
	        	request.setAttribute("nombre_cliente", client.getNombre_cliente());
	        	request.setAttribute("telefono_cliente", client.getTelefono());
	        	request.setAttribute("validacion", "");
	        	request.getRequestDispatcher("Clientes.jsp").forward(request, response);
	        } else {
				request.setAttribute("validacion", "Cliente Inexistente");
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}
		}

		else if (request.getParameter("botonActualizar") != null) {
			
			System.out.println("Boton Actualizar");
			client = validarCampos(request);
			
	        if (client != null) {
	        	
	        	if(clientCtrl.actualizar(client)) {
	        		request.setAttribute("validacion", "Datos del Cliente Actualizados");
		        	request.getRequestDispatcher("Clientes.jsp").forward(request, response);	        		
	        	} else {
	        		request.setAttribute("validacion", "Cédula de Cliente no existe");
		        	request.getRequestDispatcher("Clientes.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Datos faltantes");
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}
		}	
		
		else if (request.getParameter("botonCrear") != null) {
			
			System.out.println("Boton Crear");
			client = validarCampos(request);
			
	        if (client != null) {	        	
	        	if(clientCtrl.crear(client)) {
	        		request.setAttribute("validacion", "Cliente Creado");
		        	request.getRequestDispatcher("Clientes.jsp").forward(request, response);	        		
	        	} else {
	        		request.setAttribute("validacion", "Cédula de Cliente ya existe");
		        	request.getRequestDispatcher("Clientes.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Faltan datos del cliente");
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}
		}
		
		else if (request.getParameter("botonBorrar") != null) {
			
			System.out.println("Boton Borrar");
			client = validarCampos(request);
			
	        if (client != null) {
	        	
	        	if(clientCtrl.borrar(client)) {
	        		request.setAttribute("validacion", "Datos del Cliente Borrados");
		        	request.getRequestDispatcher("Clientes.jsp").forward(request, response);	        		
	        	} else {
	        		request.setAttribute("validacion", "Cédula Errada");
		        	request.getRequestDispatcher("Clientes.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Faltan datos del cliente");
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}
		}
	}
	
	public ClienteVO validarCampos ( HttpServletRequest request ) {
		
		ClienteVO client = new ClienteVO();
		String cedula = request.getParameter("cedula_cliente");
		String direccion_cliente = request.getParameter("direccion_cliente");
		String email_cliente = request.getParameter("email_cliente");
		String nombre_cliente = request.getParameter("nombre_cliente");
		String telefono_cliente = request.getParameter("telefono_cliente");
		
        if (cedula != "" && direccion_cliente != "" && email_cliente != "" && nombre_cliente  != "" && telefono_cliente   != "") {
        	System.out.println("Campos completos!!");
        	client.setCedula(Integer.parseInt(cedula));
        	client.setDireccion(direccion_cliente);
        	client.setEmail(email_cliente);
        	client.setNombre_cliente(nombre_cliente);
        	client.setTelefono(telefono_cliente);
        	
        	return client;
        } else return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
