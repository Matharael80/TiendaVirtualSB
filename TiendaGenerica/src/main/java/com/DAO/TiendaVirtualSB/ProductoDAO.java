package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import com.DTO.TiendaVirtualSB.ProductoVO;

public class ProductoDAO {
	
	public boolean Crear(ProductoVO prod) {
		String sql = "INSERT INTO productos VALUES ("+prod.getCodigo()+", "+prod.getIVA()+", "+prod.getNIT_proveedor()+", '"+prod.getNombre_producto()+"', "+prod.getPrecio_compra()+", "+prod.getPrecio_venta()+")";
		return ejecutarUpdate(sql);
	} 	
	
	public boolean Actualizar(ProductoVO prod) {
		String sql = "UPDATE productos SET ivacompra="+prod.getIVA()+", nitproveedor="+prod.getNIT_proveedor()+", nombre_producto='"+prod.getNombre_producto()+"', precio_compra="+prod.getPrecio_compra()+", precio_venta="+prod.getPrecio_venta()+" WHERE codigo_producto="+prod.getCodigo();
		return ejecutarUpdate(sql);
	}
		
	public boolean Borrar(ProductoVO prod) {
		String sql = "DELETE FROM productos WHERE codigo_producto="+prod.getCodigo();
		return ejecutarUpdate(sql);
	}
	
	public boolean BorrarTodo() {
		String sql = "DELETE FROM productos";
		return ejecutarUpdate(sql);
	}
	
	public ProductoVO Consultar(int code) {
 		ProductoVO prod = new ProductoVO();
 		Conexion conex= new Conexion();
    
 		try {
 			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos WHERE codigo_producto=" + code);
 			//consulta.setInt(1, nit);
			ResultSet res = consulta.executeQuery();
   
			if(res.next()) {
				prod.setCodigo(Integer.parseInt(res.getString("codigo_producto")));
				prod.setIVA(Double.parseDouble(res.getString("ivacompra")));
				prod.setNIT_proveedor(Integer.parseInt(res.getString("nitproveedor")));
				prod.setNombre_producto(res.getString("nombre_producto"));
				prod.setPrecio_compra(Double.parseDouble(res.getString("precio_compra")));
				prod.setPrecio_venta(Double.parseDouble(res.getString("precio_venta")));
 			} else prod=null;
			res.close();
			consulta.close();
			conex.desconectar();
   
 		} catch (Exception e) {
 				System.out.println("No se pudo consultar el Producto\n"+e);
 		}
 		return prod;
	}
	/*
 	public ArrayList<ProductoVO> listarProveedor() {
 		ArrayList<ProductoVO> miProveedor = new ArrayList<ProductoVO>();
 		Conexion conex= new Conexion();
    
 			try {
 				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");
 				ResultSet res = consulta.executeQuery();
 				while(res.next()){
 					ProductoVO prod= new ProductoVO();
 					prod.setNIT(Integer.parseInt(res.getString("NIT Proveedor")));
 					prod.setNombre_prodeedor(res.getString("Nombre Proveedor"));
 					prod.setDireccion(res.getString("Direccion"));
 					prod.setTelefono(res.getString("Telefono"));
 					prod.setCiudad(res.getString("Ciudad"));
  
 					miProveedor.add(prod);
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
			System.out.println("No se logro ejecutar el Update Producto: "+ sql);
			return false;
		}
 	}
}
