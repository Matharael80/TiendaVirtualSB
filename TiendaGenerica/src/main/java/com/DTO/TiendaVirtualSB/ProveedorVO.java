package com.DTO.TiendaVirtualSB;

public class ProveedorVO {

	private int NIT;
	private String Nombre_proveedor;
	private String Direccion;
	private String Telefono;
	private String Ciudad;
	
	public int getNIT() {
		return NIT;
	}
	public void setNIT(int nIT) {
		NIT = nIT;
	}
	public String getNombre_proveedor() {
		return Nombre_proveedor;
	}
	public void setNombre_proveedor(String nombre_proveedor) {
		Nombre_proveedor = nombre_proveedor;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
		
}
