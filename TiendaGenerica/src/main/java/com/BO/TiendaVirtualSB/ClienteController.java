package com.BO.TiendaVirtualSB;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.ClienteDAO;
import com.DTO.TiendaVirtualSB.ClienteVO;

@RestController
public class ClienteController {
	
	@RequestMapping("/crearCliente")
	public void crearCliente(ClienteVO persona) 
	 {
		ClienteDAO Dao=new ClienteDAO(); 
	    Dao.Crear(persona);	    
	 }
	 
	@RequestMapping("/consultarCliente")
	public ArrayList<ClienteVO> consultar(int documento) {
		ClienteDAO Dao=new ClienteDAO(); 
		return 	Dao.consultar(documento);
	}
	
	@RequestMapping("/listarCliente")
	public ArrayList<ClienteVO> listarCliente() {
		ClienteDAO Dao=new ClienteDAO(); 
		return Dao.listarCliente();		
	}
	
}