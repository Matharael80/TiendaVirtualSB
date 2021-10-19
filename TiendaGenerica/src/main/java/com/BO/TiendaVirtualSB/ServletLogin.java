package com.BO.TiendaVirtualSB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletlogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        //super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		//PrintWriter writer = response.getWriter();
		if(usuario != null && password != null) {
			
			UsuarioController cte = new UsuarioController();
			
			if(cte.validarUsuario(usuario,password)) {
				System.out.println("Usuario y contraseña existe!!");
				String redirectURL = "Usuarios.jsp";
			    response.sendRedirect(redirectURL);
			}
			else {
				request.setAttribute("usuario", usuario); //envia 
				request.setAttribute("password", password);
				request.setAttribute("validacion", "Usuario o contraseña errados, intente de nuevo");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				//writer.println("Bienvenido " + usuario + " con contraseña " + password);
			}
		}
		else {
			//writer.println("Error: Usuario o contraseña vacio!");
			//writer.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
