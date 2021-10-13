package com.BO.TiendaVirtualSB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DTO.TiendaVirtualSB.ProveedorVO;
//import java.util.ArrayList;
//import java.io.PrintWriter;

@WebServlet("/servletProveedores")
public class ServletProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletProveedores() {
        //super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedorVO prov = new ProveedorVO();
		ProveedorController provCtrl = new ProveedorController();
		
		if (request.getParameter("botonConsultar") != null) {
			
			System.out.println("Boton Consultar");
			String nit = request.getParameter("nit_proveedor");
			
			prov = provCtrl.consultar(Integer.parseInt(nit));
			
	        if (prov != null) {
	        	System.out.println("Proveedor Encontrado!!");
	        	request.setAttribute("nit_proveedor", nit);
	        	request.setAttribute("direccion_proveedor", prov.getDireccion());
	        	request.setAttribute("ciudad_proveedor", prov.getCiudad());
	        	request.setAttribute("nombre_proveedor", prov.getNombre_proveedor());
	        	request.setAttribute("telefono_proveedor", prov.getTelefono());
	        	request.setAttribute("validacion", "");
	        	request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
	        } else {
				request.setAttribute("validacion", "Proveedor Inexistente");
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			}
		}

		else if (request.getParameter("botonActualizar") != null) {
			
			System.out.println("Boton Actualizar");
			prov = validarCampos(request);
			
	        if (prov != null) {
	        	
	        	if(provCtrl.actualizar(prov)) {
	        		request.setAttribute("validacion", "Datos del Proveedor Actualizados");
		        	request.getRequestDispatcher("Proveedores.jsp").forward(request, response);	        		
	        	} else {
	        		request.setAttribute("validacion", "Cédula de Proveedor no existe");
		        	request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Datos faltantes");
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			}
		}	
		
		else if (request.getParameter("botonCrear") != null) {
			
			System.out.println("Boton Crear");
			prov = validarCampos(request);
			
	        if (prov != null) {	        	
	        	if(provCtrl.crear(prov)) {
	        		request.setAttribute("validacion", "Proveedor Creado");
		        	request.getRequestDispatcher("Proveedores.jsp").forward(request, response);	        		
	        	} else {
	        		request.setAttribute("validacion", "Nit de Proveedor ya existe");
		        	request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Faltan datos del proveedor");
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			}
		}
		
		else if (request.getParameter("botonBorrar") != null) {
			
			System.out.println("Boton Borrar");
			prov = validarCampos(request);
			
	        if (prov != null) {
	        	
	        	if(provCtrl.borrar(prov)) {
	        		request.setAttribute("validacion", "Datos del Proveedor Borrados");
		        	request.getRequestDispatcher("Proveedores.jsp").forward(request, response);	        		
	        	} else {
	        		request.setAttribute("validacion", "Nit Inexistente");
		        	request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Faltan datos del proveedor");
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			}
		}
	}
	
	public ProveedorVO validarCampos ( HttpServletRequest request ) {
		
		ProveedorVO prov = new ProveedorVO();
		String nit = request.getParameter("nit_proveedor");
		String direccion_proveedor = request.getParameter("direccion_proveedor");
		String ciudad_proveedor = request.getParameter("ciudad_proveedor");
		String nombre_proveedor = request.getParameter("nombre_proveedor");
		String telefono_proveedor = request.getParameter("telefono_proveedor");
		
        if (nit != "" && direccion_proveedor != "" && ciudad_proveedor != "" && nombre_proveedor  != "" && telefono_proveedor   != "") {
        	System.out.println("Campos completos!!");
        	prov.setNIT(Integer.parseInt(nit));
        	prov.setDireccion(direccion_proveedor);
        	prov.setCiudad(ciudad_proveedor);
        	prov.setNombre_proveedor(nombre_proveedor);
        	prov.setTelefono(telefono_proveedor);
        	
        	return prov;
        } else return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
