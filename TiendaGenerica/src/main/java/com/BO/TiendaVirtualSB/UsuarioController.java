package com.BO.TiendaVirtualSB;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.ClienteDAO;
import com.DAO.TiendaVirtualSB.UsuarioDAO;
import com.DTO.TiendaVirtualSB.UsuarioVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/crearUsuario")
	public void crear(UsuarioVO usu){
		UsuarioDAO Dao=new UsuarioDAO(); 
	    Dao.Crear(usu);	    
	 }
	
	@RequestMapping("/consultarUsuario")
	public ArrayList<UsuarioVO> consultar(int documento) {
		UsuarioDAO Dao=new UsuarioDAO(); 
		return 	Dao.consultar(documento);
	}
	
	@RequestMapping("/listarUsuario")
	public ArrayList<UsuarioVO> listarUsuario() {
		UsuarioDAO Dao=new UsuarioDAO(); 
		return Dao.listarUsuario();		
	}
	
	@RequestMapping("/validarUsuario")
	public boolean validarUsuario(String usuario, String password) {
		ClienteDAO Dao=new ClienteDAO(); 
		return Dao.validarUsuario(usuario,password);
	}
}
