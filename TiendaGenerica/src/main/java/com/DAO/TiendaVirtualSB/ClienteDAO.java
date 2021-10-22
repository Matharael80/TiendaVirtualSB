package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

 	public ArrayList<ClienteVO> ListarCliente() {
 		ArrayList<ClienteVO> miCliente = new ArrayList<ClienteVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
 				ResultSet res = consulta.executeQuery();
 				while(res.next()){
 					ClienteVO cte= new ClienteVO();
 					cte.setCedula(Integer.parseInt(res.getString("cedula_cliente")));
 					cte.setNombre_cliente(res.getString("nombre_cliente"));
 					cte.setDireccion(res.getString("direccion_cliente"));
 					cte.setTelefono(res.getString("telefono_cliente"));
 					cte.setEmail(res.getString("email_cliente"));
  
 					miCliente.add(cte);
 				}
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				System.out.println("no se pudo listar clientes\n"+e);
 		}
 		return miCliente;
 	}
 	
 	public ArrayList<ClienteVO> VentasCliente() {
 		ArrayList<ClienteVO> miCliente = new ArrayList<ClienteVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				String sql = "SELECT V.cedula_cliente, nombre_cliente, SUM(valor_venta) AS 'ventas'"
 						+ " FROM ventas AS V"
 						+ " JOIN clientes AS C"
 						+ " ON V.cedula_cliente=C.cedula_cliente"
 						+ " GROUP BY cedula_cliente";
 				PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
 				ResultSet res = consulta.executeQuery();
 				while(res.next()){
 					ClienteVO cte= new ClienteVO();
 					cte.setCedula(Integer.parseInt(res.getString("cedula_cliente")));
 					cte.setNombre_cliente(res.getString("nombre_cliente"));
 					cte.setValorVentas(Double.parseDouble(res.getString("ventas")));
 					
 					miCliente.add(cte);
 				}
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				System.out.println("no se pudo listar ventas de clientes\n"+e);
 		}
 		return miCliente;
 	}
}