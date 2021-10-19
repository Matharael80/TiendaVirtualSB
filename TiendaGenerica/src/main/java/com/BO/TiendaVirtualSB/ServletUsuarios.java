package com.BO.TiendaVirtualSB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DTO.TiendaVirtualSB.UsuarioVO;

@WebServlet("/servletUsuarios")
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletUsuarios() {
        //super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("botonConsultar") != null) {
			
			System.out.println("Boton Consultar");
			
			UsuarioController cte = new UsuarioController();
			String cedula = request.getParameter("cedula_usuario");
			
			
			UsuarioVO resultado = cte.consultar(Integer.parseInt(cedula));
			
	        if (resultado != null) {
	        	System.out.println("Usuario Encontrado!!");
	        	request.setAttribute("cedula_usuario", cedula);
	        	request.setAttribute("nombre_usuario", resultado.getNombre_usuario());
	        	request.setAttribute("email_usuario", resultado.getEmail_usuario());
	        	request.setAttribute("usuario", resultado.getUsuario());
	        	request.setAttribute("password", resultado.getPassword());
	        	request.setAttribute("validacion", "");
	        	request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
	        } else {
				request.setAttribute("validacion", "Usuario Inexistente");
				request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
			}
		}

		if (request.getParameter("botonActualizar") != null) {
			System.out.println("Boton Actualizar");
			
			UsuarioController userCtrl = new UsuarioController();
			String cedula = request.getParameter("cedula_usuario");
			String nombre_usuario = request.getParameter("nombre_usuario");
			String email_usuario = request.getParameter("email_usuario");
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			UsuarioVO user = new UsuarioVO();
			
	        if (cedula != "" && nombre_usuario != "" && email_usuario != "" && usuario  != "" && password   != "") {
	        	System.out.println("Campos actualizar llenos!!");
	        	user.setCedula_usuario(Integer.parseInt(cedula));
	        	user.setNombre_usuario(nombre_usuario);
	        	user.setEmail_usuario(email_usuario);
	        	user.setUsuario(usuario);
	        	user.setPassword(password);
	        	
	        	if(userCtrl.actualizar(user)) {
	        		request.setAttribute("validacion", "Datos del Usuario Actualizados");
		        	request.getRequestDispatcher("Usuarios.jsp").forward(request, response);	        		
	        	}
	        	else {
	        		request.setAttribute("validacion", "Cédula de Usuario no existe");
		        	request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Datos faltantes");
				request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
			}
		}	
		
		if (request.getParameter("botonCrear") != null) {
			System.out.println("Boton Crear");
			UsuarioController userCtrl = new UsuarioController();
			String cedula = request.getParameter("cedula_usuario");
			String nombre_usuario = request.getParameter("nombre_usuario");
			String email_usuario = request.getParameter("email_usuario");
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			UsuarioVO user = new UsuarioVO();
			
	        if (cedula != "" && nombre_usuario != "" && email_usuario != "" && usuario  != "" && password   != "") {
	        	System.out.println("Campos a crear llenos!!");
	        	user.setCedula_usuario(Integer.parseInt(cedula));
	        	user.setNombre_usuario(nombre_usuario);
	        	user.setEmail_usuario(email_usuario);
	        	user.setUsuario(usuario);
	        	user.setPassword(password);
	        	
	        	if(userCtrl.crear(user)) {
	        		request.setAttribute("validacion", "Usuario Creado");
		        	request.getRequestDispatcher("Usuarios.jsp").forward(request, response);	        		
	        	}
	        	else {
	        		request.setAttribute("validacion", "Cédula de Usuario ya existe");
		        	request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Faltan datos del usuario");
				request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
			}
		}
		
		if (request.getParameter("botonBorrar") != null) {
			System.out.println("Boton Borrar");
			
			UsuarioController userCtrl = new UsuarioController();
			String cedula = request.getParameter("cedula_usuario");
			String nombre_usuario = request.getParameter("nombre_usuario");
			String email_usuario = request.getParameter("email_usuario");
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			UsuarioVO user = new UsuarioVO();
			
	        if (cedula != "" && nombre_usuario != "" && email_usuario != "" && usuario  != "" && password   != "") {
	        	System.out.println("Campos a eliminar llenos!!");
	        	user.setCedula_usuario(Integer.parseInt(cedula));
	        	user.setNombre_usuario(nombre_usuario);
	        	user.setEmail_usuario(email_usuario);
	        	user.setUsuario(usuario);
	        	user.setPassword(password);
	        	
	        	if(userCtrl.borrar(user)) {
	        		request.setAttribute("validacion", "Datos del Usuario Borrados");
		        	request.getRequestDispatcher("Usuarios.jsp").forward(request, response);	        		
	        	}
	        	else {
	        		request.setAttribute("validacion", "Cédula Errada");
		        	request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
	        	}
	        } else {
				request.setAttribute("validacion", "Faltan datos del usuario");
				request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
