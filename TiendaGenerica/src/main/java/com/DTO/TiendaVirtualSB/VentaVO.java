package com.DTO.TiendaVirtualSB;

public class VentaVO {

	private int Codigo;
	private int Cedula_cliente;
	private int Cedula_usuario;
	private double IVA_venta;
	private double Total_venta;
	private double Valor_venta;
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int code) {
		Codigo = code;
	}
	public int getCedula_cliente() {
		return Cedula_cliente;
	}
	public void setCedula_cliente(int cedula_cliente) {
		Cedula_cliente = cedula_cliente;
	}
	public int getCedula_usuario() {
		return Cedula_usuario;
	}
	public void setCedula_usuario(int cedula_usuario) {
		Cedula_usuario = cedula_usuario;
	}
	public double getIVA_venta() {
		return IVA_venta;
	}
	public void setIVA_venta(double iva_venta) {
		IVA_venta = iva_venta;
	}
	public double getTotal_venta() {
		return Total_venta;
	}
	public void setTotal_venta(double iva) {
		Total_venta = iva;
	}
	public double getValor_venta() {
		return Valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		Valor_venta = valor_venta;
	}
		
}
