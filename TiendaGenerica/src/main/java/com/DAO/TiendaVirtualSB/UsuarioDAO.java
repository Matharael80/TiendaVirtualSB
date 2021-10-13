package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.DTO.TiendaVirtualSB.UsuarioVO;

public class UsuarioDAO {

	public boolean Crear(UsuarioVO usu) {
		 
		Conexion conex= new Conexion();
  
			try {
				Statement estatuto = conex.getConnection().createStatement();
				int resultado = estatuto.executeUpdate("INSERT INTO usuarios (cedula_usuario, email_usuario, nombre_usuario, password, usuario) VALUES ("+usu.getCedula_usuario()+", '"+usu.getEmail_usuario()+"', '"+usu.getNombre_usuario()+"', '"+usu.getPassword()+"', '"+usu.getUsuario()+"')");
				System.out.println(resultado);
				estatuto.close();
				conex.desconectar();
				if (resultado == 1)return true;
 				else return false;
   
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("No se creo el Usuario");
				return false;
			}
	} 	
	
	public boolean Actualizar(UsuarioVO usu) {
		 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				
 				int resultado = estatuto.executeUpdate("UPDATE usuarios SET email_usuario='"+usu.getEmail_usuario()+"', nombre_usuario='"+usu.getNombre_usuario()+"', password='"+usu.getPassword()+"', usuario='"+usu.getUsuario()+"' WHERE cedula_usuario= " + usu.getCedula_usuario());
 				System.out.println(resultado);
 				estatuto.close();
 				conex.desconectar();
 				if (resultado == 1)return true;
 				else return false;
 				
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            System.out.println("No se actualizo el Usuario");
	            return false;
 			}
	 }
		
	public boolean Borrar(UsuarioVO usu) {
		 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				int resultado = estatuto.executeUpdate("DELETE FROM usuarios WHERE cedula_usuario= "+usu.getCedula_usuario());
 				System.out.println(resultado);
 				estatuto.close();
 				conex.desconectar();
 				if (resultado == 1)return true;
 				else return false;
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            System.out.println("No se borro el Usuario");
	            return false;
 			}
	 }
	
	public UsuarioVO Consultar(int documento) {
		UsuarioVO usu= new UsuarioVO();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario= " + documento);
 				//consulta.setInt(1, documento);
 				ResultSet res = consulta.executeQuery();
   
 				if(res.next()){
 					usu.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
 					usu.setEmail_usuario(res.getString("email_usuario"));
 					usu.setNombre_usuario(res.getString("nombre_usuario"));
 					usu.setPassword(res.getString("password"));
 					usu.setUsuario(res.getString("usuario"));
 				}
 				else usu=null;
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				System.out.println("no se pudo consultar el Usuario\n"+e);
 		}
 		return usu;
	}
	
 	public ArrayList<UsuarioVO> listarUsuario() {
 		ArrayList<UsuarioVO> miUsuario = new ArrayList<UsuarioVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
 				ResultSet res = consulta.executeQuery();
 				while(res.next()){
 					UsuarioVO usu= new UsuarioVO();
 					usu.setCedula_usuario(Integer.parseInt(res.getString("Cedula Usuario")));
 					usu.setEmail_usuario(res.getString("Correo Electronico"));
 					usu.setNombre_usuario(res.getString("Nombre Completo"));
 					usu.setPassword(res.getString("Contraseña"));
 					usu.setUsuario(res.getString("Usuario"));
  
 					miUsuario.add(usu);
 				}
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				JOptionPane.showMessageDialog(null, "no se pudo listar Usuarios\n"+e);
 		}
 		return miUsuario;
 	}
 	
 	public boolean validarUsuario(String user, String pass) {
 		Conexion conex= new Conexion();
 		String sql = "SELECT * FROM usuarios WHERE usuario = '" + user + "' AND password = '" + pass + "'";
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
 				//consulta.setInt(1, documento);
 				System.out.println(sql);
 				ResultSet res = consulta.executeQuery();
   
 				if (res != null && res.next() )
 				{
 					return true;
 				}
 					else return false;
   
 			} catch (Exception e) {
 				System.out.println("Excepcion en clase clienteDAO metodo consultarUsuario\n"+e);
 				return false;
 		}
 	}
}
