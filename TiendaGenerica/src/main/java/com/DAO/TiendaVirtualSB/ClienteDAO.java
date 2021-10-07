package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.DTO.TiendaVirtualSB.ClienteVO;

public class ClienteDAO {
		
	public void Crear(ClienteVO persona) {
	 
		Conexion conex= new Conexion();
  
			try {
				Statement estatuto = conex.getConnection().createStatement();
				estatuto.executeUpdate("INSERT INTO clientes VALUES ('"+persona.getCedula()+"', '"+persona.getNombre_cliente()+"', '"+persona.getDireccion()+"', '"+persona.getTelefono()+"', '"+persona.getEmail()+"')");
				JOptionPane.showMessageDialog(null, "Se ha creado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
				estatuto.close();
				conex.desconectar();
   
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "No se creo el cliente");
			}
	} 

 	public void Actualizar(ClienteVO persona) {
	 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				estatuto.executeUpdate("UPDATE clientes SET ('"+persona.getNombre_cliente()+"', '"+persona.getDireccion()+"', '"+persona.getTelefono()+"', '"+persona.getEmail()+"' WHERE '"+persona.getCedula()+"')");
 				JOptionPane.showMessageDialog(null, "Se ha actualizado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
 				estatuto.close();
 				conex.desconectar();
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se actualizo el cliente");
 			}
	 }
 
 	public void Borrar(ClienteVO persona) {
	 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				estatuto.executeUpdate("DELETE FROM clientes WHERE '"+persona.getCedula()+"')");
 				JOptionPane.showMessageDialog(null, "Se ha borrado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
 				estatuto.close();
 				conex.desconectar();
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se borro el cliente");
 			}
	 }
 
 	public ArrayList<ClienteVO> consultar(int documento) {
 		ArrayList<ClienteVO> miCliente = new ArrayList<ClienteVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula= " + documento);
 				consulta.setInt(1, documento);
 				ResultSet res = consulta.executeQuery();
   
 				if(res.next()){
 					ClienteVO persona= new ClienteVO();
 					persona.setCedula(Integer.parseInt(res.getString("Cedula")));
 					persona.setNombre_cliente(res.getString("Nombre Completo"));
 					persona.setDireccion(res.getString("Direccion"));
 					persona.setTelefono(Integer.parseInt(res.getString("Telefono")));
 					persona.setEmail(res.getString("Correo Electronico"));
 
 					miCliente.add(persona);
 				}
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				JOptionPane.showMessageDialog(null, "no se pudo consultar el cliente\n"+e);
 		}
 		return miCliente;
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
 					persona.setTelefono(Integer.parseInt(res.getString("Telefono")));
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