package com.DTO.TiendaVirtualSB;

public class ClienteVO {
	
	 private int Cedula;
	 private String Nombre_cliente;
	 private String Direccion;
	 private int Telefono;
	 private String Email;
	 
	public int getCedula() {
		return Cedula;
	}
	public void setCedula(int cedula) {
		Cedula = cedula;
	}
	public String getNombre_cliente() {
		return Nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		Nombre_cliente = nombre_cliente;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
