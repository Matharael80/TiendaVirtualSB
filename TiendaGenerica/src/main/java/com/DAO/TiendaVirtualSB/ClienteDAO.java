package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.DTO.TiendaVirtualSB.ClienteVO;

public class ClienteDAO {
		
	public boolean Crear(ClienteVO persona) {
	 
		Conexion conex= new Conexion();
  
			try {
				Statement estatuto = conex.getConnection().createStatement();
				String sql = "INSERT INTO clientes VALUES ("+persona.getCedula()+", '"+persona.getDireccion()+"', '"+persona.getEmail()+"', '"+persona.getNombre_cliente()+"', '"+persona.getTelefono()+"')";
				System.out.println(sql);
				int resultado = estatuto.executeUpdate(sql);
				System.out.println(resultado);
				estatuto.close();
				conex.desconectar();
				if (resultado == 1)return true;
 				else return false;
   
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("No se creo el Cliente");
				return false;
			}
	} 

 	public boolean Actualizar(ClienteVO persona) {
	 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				int resultado = estatuto.executeUpdate("UPDATE clientes SET nombre_cliente='"+persona.getNombre_cliente()+"', direccion_cliente='"+persona.getDireccion()+"', telefono_cliente="+persona.getTelefono()+", email_cliente='"+persona.getEmail()+"' WHERE cedula_cliente="+persona.getCedula());
 				System.out.println(resultado);
 				estatuto.close();
 				conex.desconectar();
 				if (resultado == 1)return true;
 				else return false;
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            System.out.println("No se actualizo el Cliente");
	            return false;
 			}
	 }
 
 	public boolean Borrar(ClienteVO persona) {
	 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				int resultado = estatuto.executeUpdate("DELETE FROM clientes WHERE cedula_cliente= "+persona.getCedula());
 				System.out.println(resultado);
 				estatuto.close();
 				conex.desconectar();
 				if (resultado == 1)return true;
 				else return false;
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            System.out.println("No se borro el Cliente");
	            return false;
 			}
	 }
 
 	public ClienteVO Consultar(int documento) {
 		ClienteVO persona = new ClienteVO();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_cliente= " + documento);
 				//consulta.setInt(1, documento);
 				ResultSet res = consulta.executeQuery();
   
 				if(res.next()){
 					
 					persona.setCedula(Integer.parseInt(res.getString("cedula_cliente")));
 					persona.setNombre_cliente(res.getString("nombre_cliente"));
 					persona.setDireccion(res.getString("direccion_cliente"));
 					persona.setTelefono(res.getString("telefono_cliente"));
 					persona.setEmail(res.getString("email_cliente"));
 				}
 				else persona=null;
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				System.out.println("No se pudo consultar el Cliente\n"+e);
 		}
 		return persona;
 }

 	public ArrayList<ClienteVO> listarCliente() {
 		ArrayList<ClienteVO> miCliente = new ArrayList<ClienteVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
 				ResultSet res = consulta.executeQuery();
 				while(res.next()){
 					ClienteVO persona= new ClienteVO();
 					persona.setCedula(Integer.parseInt(res.getString("Cedula")));
 					persona.setNombre_cliente(res.getString("Nombre Completo"));
 					persona.setDireccion(res.getString("Direccion"));
 					persona.setTelefono(res.getString("Telefono"));
 					persona.setEmail(res.getString("Correo Electronico"));
  
 					miCliente.add(persona);
 				}
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				JOptionPane.showMessageDialog(null, "no se pudo listar clientes\n"+e);
 		}
 		return miCliente;
 	}
}