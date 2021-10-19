package com.BO.TiendaVirtualSB;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.ClienteDAO;
import com.DTO.TiendaVirtualSB.ClienteVO;

@RestController
public class ClienteController {
	
	ClienteDAO Dao=new ClienteDAO();
	
	@RequestMapping("/consultarCliente")
	public ClienteVO consultar(int documento) {
		return 	Dao.Consultar(documento);
	}
	
	public boolean actualizar(ClienteVO client) { 
		return 	Dao.Actualizar(client);
	}
	
	@RequestMapping("/crearCliente")
	public boolean crear(ClienteVO client) {
	    return Dao.Crear(client);
	 }
	
	@RequestMapping("/borrarCliente")
	public boolean borrar(ClienteVO client){
	    return Dao.Borrar(client);	    
	 }
	
	@RequestMapping("/listarCliente")
	public ArrayList<ClienteVO> listarCliente() {
		return Dao.listarCliente();		
	}
	
}