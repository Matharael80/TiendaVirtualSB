package com.BO.TiendaVirtualSB;

//import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.ProveedorDAO;
import com.DTO.TiendaVirtualSB.ProveedorVO;


@RestController
public class ProveedorController {
	
	ProveedorDAO Dao=new ProveedorDAO();
	
	@RequestMapping("/consultarProveedor")
	public ProveedorVO consultar(int nit) {
		return 	Dao.Consultar(nit);
	}
	
	public boolean actualizar(ProveedorVO client) { 
		return 	Dao.Actualizar(client);
	}
	
	@RequestMapping("/crearProveedor")
	public boolean crear(ProveedorVO client) 
	 {
	    return Dao.Crear(client);
	 }
	
	@RequestMapping("/borrarProveedor")
	public boolean borrar(ProveedorVO client){
	    return Dao.Borrar(client);	    
	 }
	/*
	@RequestMapping("/listarProveedor")
	public ArrayList<ProveedorVO> listarProveedor() {
		return Dao.listarProveedor();		
	}
	*/
}