package com.BO.TiendaVirtualSB;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.UsuarioDAO;
import com.DTO.TiendaVirtualSB.UsuarioVO;

@RestController
public class UsuarioController {
	
	UsuarioDAO Dao=new UsuarioDAO(); 
	
	@RequestMapping("/consultarUsuario")
	public UsuarioVO consultar(int documento) {
		return 	Dao.Consultar(documento);
	}
	
	public boolean actualizar(UsuarioVO user) { 
		return 	Dao.Actualizar(user);
	}
	
	@RequestMapping("/crearUsuario")
	public boolean crear(UsuarioVO usu){ 
	    return Dao.Crear(usu);	    
	}
	
	@RequestMapping("/borrarUsuario")
	public boolean borrar(UsuarioVO usu){
	    return Dao.Borrar(usu);	    
	}
	
	@RequestMapping("/listarUsuario")
	public ArrayList<UsuarioVO> listarUsuario() { 
		return Dao.listarUsuario();		
	}
	
	@RequestMapping("/validarUsuario")
	public boolean validarUsuario(String usuario, String password) {
		return Dao.validarUsuario(usuario,password);
	}
}
