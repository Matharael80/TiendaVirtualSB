package com.DTO.TiendaVirtualSB;

public class ClienteVO {
	
	 private int Cedula;
	 private String Nombre_cliente;
	 private String Direccion;
	 private String Telefono;
	 private String Email;
	 private double ValorVentas;
	 
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
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public double getValorVentas() {
		return ValorVentas;
	}
	public void setValorVentas(double valorVentas) {
		ValorVentas = valorVentas;
	}
}
