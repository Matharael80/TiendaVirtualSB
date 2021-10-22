package com.BO.TiendaVirtualSB;

//import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.VentaDAO;
import com.DTO.TiendaVirtualSB.VentaVO;


@RestController
public class VentaController {
	
	VentaDAO Dao=new VentaDAO();
	
	@RequestMapping("/consultarVenta")
	public VentaVO consultar(int code) {
		return 	Dao.Consultar(code);
	}
	
	@RequestMapping("/consultarUltimaVenta")
	public int consultarUltimaVenta() {
		return 	Dao.ConsultarUltimaVenta();
	}
	
	public boolean actualizar(VentaVO vent) { 
		return 	Dao.Actualizar(vent);
	}
	
	@RequestMapping("/crearVenta")
	public boolean crear(VentaVO vent) 
	{
	    return Dao.Crear(vent);
	}
	
	@RequestMapping("/borrarVenta")
	public boolean borrar(VentaVO vent){
	    return Dao.Borrar(vent);	    
	}
	/*
	@RequestMapping("/listarVenta")
	public ArrayList<VentaVO> listarVenta() {
		return Dao.listarVenta();		
	}
	*/
}