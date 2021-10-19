package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.DTO.TiendaVirtualSB.ClienteVO;

public class ClienteDAO {
		
	public boolean Crear(ClienteVO cli) {
	 
		Conexion conex= new Conexion();
  
			try {
				Statement estatuto = conex.getConnection().createStatement();
				String sql = "INSERT INTO clientes VALUES ("+cli.getCedula()+", '"+cli.getDireccion()+"', '"+cli.getEmail()+"', '"+cli.getNombre_cliente()+"', '"+cli.getTelefono()+"')";
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

 	public boolean Actualizar(ClienteVO cli) {
	 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				int resultado = estatuto.executeUpdate("UPDATE clientes SET nombre_cliente='"+cli.getNombre_cliente()+"', direccion_cliente='"+cli.getDireccion()+"', telefono_cliente="+cli.getTelefono()+", email_cliente='"+cli.getEmail()+"' WHERE cedula_cliente="+cli.getCedula());
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
 
 	public boolean Borrar(ClienteVO cli) {
	 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				int resultado = estatuto.executeUpdate("DELETE FROM clientes WHERE cedula_cliente= "+cli.getCedula());
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
 		ClienteVO cli = new ClienteVO();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_cliente= " + documento);
 				//consulta.setInt(1, documento);
 				ResultSet res = consulta.executeQuery();
   
 				if(res.next()){
 					
 					cli.setCedula(Integer.parseInt(res.getString("cedula_cliente")));
 					cli.setNombre_cliente(res.getString("nombre_cliente"));
 					cli.setDireccion(res.getString("direccion_cliente"));
 					cli.setTelefono(res.getString("telefono_cliente"));
 					cli.setEmail(res.getString("email_cliente"));
 				}
 				else cli=null;
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				System.out.println("No se pudo consultar el Cliente\n"+e);
 		}
 		return cli;
 }

 	public ArrayList<ClienteVO> listarCliente() {
 		ArrayList<ClienteVO> miCliente = new ArrayList<ClienteVO>();
 		Conexion conex= new Conexion();
 		String sql = "SELECT * FROM clientes";
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
 				ResultSet res = consulta.executeQuery(sql);
 				while(res.next()){
 					ClienteVO cli= new ClienteVO();
 					cli.setCedula(Integer.parseInt(res.getString("cedula_cliente")));
 					cli.setNombre_cliente(res.getString("nombre_cliente"));
 					cli.setDireccion(res.getString("direccion_cliente"));
 					cli.setTelefono(res.getString("telefono_cliente"));
 					cli.setEmail(res.getString("email_cliente"));
  
 					miCliente.add(cli);
 				}
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				System.out.println("no se pudo listar clientes\n"+e);
 		}
 		return miCliente;
 	}
}