package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import com.DTO.TiendaVirtualSB.VentaVO;

public class VentaDAO {
	
	public boolean Crear(VentaVO vent) {
		String sql = "INSERT INTO ventas VALUES ("+vent.getCodigo()+", "+vent.getCedula_cliente()+", "+vent.getCedula_usuario()+", '"+vent.getIVA_venta()+"', "+vent.getTotal_venta()+", "+vent.getValor_venta()+")";
		return ejecutarUpdate(sql);
	} 	
	
	public boolean Actualizar(VentaVO vent) {
		String sql = "UPDATE ventas SET ivacompra="+vent.getCedula_cliente()+", nitproveedor="+vent.getCedula_usuario()+", nombre_venta='"+vent.getIVA_venta()+"', precio_compra="+vent.getTotal_venta()+", precio_venta="+vent.getValor_venta()+" WHERE codigo_venta="+vent.getCodigo();
		return ejecutarUpdate(sql);
	}
		
	public boolean Borrar(VentaVO vent) {
		String sql = "DELETE FROM ventas WHERE codigo_venta="+vent.getCodigo();
		return ejecutarUpdate(sql);
	}
	
	public VentaVO Consultar(int code) {
 		VentaVO vent = new VentaVO();
 		Conexion conex= new Conexion();
    
 		try {
 			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas WHERE codigo_venta=" + code);
 			//consulta.setInt(1, nit);
			ResultSet res = consulta.executeQuery();
   
			if(res.next()) {
				vent.setCodigo(Integer.parseInt(res.getString("codigo_venta")));
				vent.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				vent.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				vent.setIVA_venta(Double.parseDouble(res.getString("ivaventa")));
				vent.setTotal_venta(Double.parseDouble(res.getString("total_venta")));
				vent.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
 			} else vent=null;
			res.close();
			consulta.close();
			conex.desconectar();
   
 		} catch (Exception e) {
 				System.out.println("No se pudo consultar el Venta\n"+e);
 		}
 		return vent;
	}
	
	public int ConsultarUltimaVenta() {
 		int vent = 0;
 		Conexion conex= new Conexion();
    
 		try {
 			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas order by codigo_venta desc limit 1");
 			//consulta.setInt(1, nit);
			ResultSet res = consulta.executeQuery();
   
			if(res.next()) {
				vent = Integer.parseInt(res.getString("codigo_venta"));
 			}
			res.close();
			consulta.close();
			conex.desconectar();
   
 		} catch (Exception e) {
 				System.out.println("No se pudo consultar la Venta\n"+e);
 				return vent;
 		}
 		return vent;
	}
	/*
 	public ArrayList<VentaVO> listarProveedor() {
 		ArrayList<VentaVO> miProveedor = new ArrayList<VentaVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");
 				ResultSet res = consulta.executeQuery();
 				while(res.next()){
 					VentaVO vent= new VentaVO();
 					vent.setNIT(Integer.parseInt(res.getString("NIT Proveedor")));
 					vent.setNombre_venteedor(res.getString("Nombre Proveedor"));
 					vent.setDireccion(res.getString("Direccion"));
 					vent.setTelefono(res.getString("Telefono"));
 					vent.setCiudad(res.getString("Ciudad"));
  
 					miProveedor.add(vent);
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
			System.out.println("No se logro ejecutar el Update Venta: "+ sql);
			return false;
		}
 	}
}
