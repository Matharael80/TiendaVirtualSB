package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.DTO.TiendaVirtualSB.ProveedorVO;

public class ProveedorDAO {
	
	public boolean Crear(ProveedorVO prov) {
		String sql = "INSERT INTO proveedores VALUES ("+prov.getNIT()+", '"+prov.getCiudad()+"', '"+prov.getDireccion()+"', '"+prov.getNombre_proveedor()+"', '"+prov.getTelefono()+"')";
		return ejecutarUpdate(sql);
	} 	
	
	public boolean Actualizar(ProveedorVO prov) {
		String sql = "UPDATE proveedores SET ciudad_proveedor='"+prov.getCiudad()+"', direccion_proveedor='"+prov.getDireccion()+"', nombre_proveedor='"+prov.getNombre_proveedor()+"', telefono_proveedor='"+prov.getTelefono()+"' WHERE nitproveedor="+prov.getNIT();
		return ejecutarUpdate(sql);
	}
		
	public boolean Borrar(ProveedorVO prov) {
		String sql = "DELETE FROM proveedores WHERE nitproveedor="+prov.getNIT();
		return ejecutarUpdate(sql);
	}
	
	public ProveedorVO Consultar(int nit) {
 		ProveedorVO prov = new ProveedorVO();
 		Conexion conex= new Conexion();
    
 		try {
 			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE nitproveedor=" + nit);
 			//consulta.setInt(1, nit);
			ResultSet res = consulta.executeQuery();
   
			if(res.next()) {
				prov.setNIT(Integer.parseInt(res.getString("nitproveedor")));
				prov.setNombre_proveedor(res.getString("nombre_proveedor"));
				prov.setDireccion(res.getString("direccion_proveedor"));
				prov.setTelefono(res.getString("telefono_proveedor"));
				prov.setCiudad(res.getString("ciudad_proveedor"));
 			} else prov=null;
			res.close();
			consulta.close();
			conex.desconectar();
   
 		} catch (Exception e) {
 				System.out.println("No se pudo consultar el Proveedor\n"+e);
 		}
 		return prov;
	}
	/*
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
 	*/
 	public boolean ejecutarUpdate(String sql) {
 		Conexion conex= new Conexion();
 		  
		try {
			Statement estatuto = conex.getConnection().createStatement();
			System.out.println(sql);
			int resultado = estatuto.executeUpdate(sql);
			System.out.println(resultado);
			estatuto.close();
			conex.desconectar();
			if (resultado == 1)return true;
			else return false;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("No se logro ejecutar el Update Proveedor: "+ sql);
			return false;
		}
 	}
}
