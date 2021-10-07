package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.DTO.TiendaVirtualSB.ProveedorVO;

public class ProveedorDAO {
	public void Crear(ProveedorVO prov) {
		 
		Conexion conex= new Conexion();
  
			try {
				Statement estatuto = conex.getConnection().createStatement();
				estatuto.executeUpdate("INSERT INTO proveedores VALUES ('"+prov.getNIT()+"', '"+prov.getNombre_proveedor()+"', '"+prov.getDireccion()+"', '"+prov.getTelefono()+"', '"+prov.getCiudad()+"')");
				JOptionPane.showMessageDialog(null, "Se ha creado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
				estatuto.close();
				conex.desconectar();
   
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "No se creo el Proveedor");
			}
	} 	
	
	public void Actualizar(ProveedorVO prov) {
		 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				estatuto.executeUpdate("UPDATE proveedores SET ('"+prov.getNombre_proveedor()+"', '"+prov.getDireccion()+"', '"+prov.getTelefono()+"', '"+prov.getCiudad()+"' WHERE '"+prov.getNIT()+"')");
 				JOptionPane.showMessageDialog(null, "Se ha actualizado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
 				estatuto.close();
 				conex.desconectar();
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se actualizo el Proveedor");
 			}
	 }
		
	public void Borrar(ProveedorVO prov) {
		 
 		Conexion conex= new Conexion();
	  
 			try {
 				Statement estatuto = conex.getConnection().createStatement();
 				estatuto.executeUpdate("DELETE FROM proveedores WHERE '"+prov.getNIT()+"')");
 				JOptionPane.showMessageDialog(null, "Se ha borrado Exitosamente","InformaciÃ³n",JOptionPane.INFORMATION_MESSAGE);
 				estatuto.close();
 				conex.desconectar();
	   
 			} catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se borro el Proveedor");
 			}
	 }
	
	public ArrayList<ProveedorVO> consultar(int documento) {
 		ArrayList<ProveedorVO> miProveedor = new ArrayList<ProveedorVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE NIT= " + documento);
 				consulta.setInt(1, documento);
 				ResultSet res = consulta.executeQuery();
   
 				if(res.next()){
 					ProveedorVO prov= new ProveedorVO();
 					prov.setNIT(Integer.parseInt(res.getString("NIT Proveedor")));
 					prov.setNombre_proveedor(res.getString("Nombre Proveedor"));
 					prov.setDireccion(res.getString("Direccion"));
 					prov.setTelefono(res.getString("Telefono"));
 					prov.setCiudad(res.getString("Ciudad"));
 
 					miProveedor.add(prov);
 				}
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				JOptionPane.showMessageDialog(null, "no se pudo consultar el Proveedor\n"+e);
 		}
 		return miProveedor;
	}
	
 	public ArrayList<ProveedorVO> listarProveedor() {
 		ArrayList<ProveedorVO> miProveedor = new ArrayList<ProveedorVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
 				ResultSet res = consulta.executeQuery();
 				while(res.next()){
 					ProveedorVO prov= new ProveedorVO();
 					prov.setNIT(Integer.parseInt(res.getString("NIT Proveedor")));
 					prov.setNombre_proveedor(res.getString("Nombre Proveedor"));
 					prov.setDireccion(res.getString("Direccion"));
 					prov.setTelefono(res.getString("Telefono"));
 					prov.setCiudad(res.getString("Ciudad"));
  
 					miProveedor.add(prov);
 				}
 				res.close();
 				consulta.close();
 				conex.desconectar();
   
 			} catch (Exception e) {
 				JOptionPane.showMessageDialog(null, "no se pudo listar Proveedores\n"+e);
 		}
 		return miProveedor;
 	}

}
