package com.DTO.TiendaVirtualSB;

public class ProductoVO {

	private int Codigo;
	private String Nombre_producto;
	private int NIT_proveedor;
	private double Precio_compra;
	private double IVA;
	private double Precio_venta;
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int code) {
		Codigo = code;
	}
	public String getNombre_producto() {
		return Nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		Nombre_producto = nombre_producto;
	}
	public int getNIT_proveedor() {
		return NIT_proveedor;
	}
	public void setNIT_proveedor(int nit_proveedor) {
		NIT_proveedor = nit_proveedor;
	}
	public double getPrecio_compra() {
		return Precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		Precio_compra = precio_compra;
	}
	public double getIVA() {
		return IVA;
	}
	public void setIVA(double iva) {
		IVA = iva;
	}
	public double getPrecio_venta() {
		return Precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		Precio_venta = precio_venta;
	}		
}
