package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.DTO.TiendaVirtualSB.UsuarioVO;

public class UsuarioDAO {

	public void Crear(UsuarioVO usu) {
		 
		Conexion conex= new Conexion();
  
			try {
				Statement estatuto = conex.getConnection().createStatement();
				estatuto.executeUpdate("INSERT INTO usuarios VALUES ('"+usu.getCedula_usuario()+"', '"+usu.getEmail_usuario()+"', '"+usu.getNombre_usuario()+"', '"+usu.getPassword()+"', '"+usu.getUsuario()+"')");
				JOptionPane.showMessageDialog(null, "Se ha creado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
				estatuto.close();
				conex.desconectar();
   
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "No se creo el Usuario");
			}
	} 	
	
	public void Actualizar(UsuarioVO usu) {
		 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				estatuto.executeUpdate("UPDATE usuarios SET ('"+usu.getEmail_usuario()+"', '"+usu.getNombre_usuario()+"', '"+usu.getPassword()+"', '"+usu.getUsuario()+"' WHERE '"+usu.getCedula_usuario()+"')");
 				JOptionPane.showMessageDialog(null, "Se ha actualizado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
 				estatuto.close();
 				conex.desconectar();
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se actualizo el Usuario");
 			}
	 }
		
	public void Borrar(UsuarioVO usu) {
		 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				estatuto.executeUpdate("DELETE FROM usuarios WHERE '"+usu.getCedula_usuario()+"')");
 				JOptionPane.showMessageDialog(null, "Se ha borrado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
 				estatuto.close();
 				conex.desconectar();
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se borro el Usuario");
 			}
	 }
	
	public ArrayList<UsuarioVO> consultar(int documento) {
 		ArrayList<UsuarioVO> miUsuario = new ArrayList<UsuarioVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario= " + documento);
 				consulta.setInt(1, documento);
 				ResultSet res = consulta.executeQuery();
   
 				if(res.next()){
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
 				JOptionPane.showMessageDialog(null, "no se pudo consultar el Usuario\n"+e);
 		}
 		return miUsuario;
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
}
