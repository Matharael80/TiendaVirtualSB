package com.BO.TiendaVirtualSB;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.UsuarioDAO;
import com.DTO.TiendaVirtualSB.UsuarioVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/consultarUsuario")
	public UsuarioVO consultar(int documento) {
		UsuarioDAO Dao=new UsuarioDAO(); 
		return 	Dao.Consultar(documento);
	}
	
	public boolean actualizar(UsuarioVO user) {
		UsuarioDAO Dao=new UsuarioDAO(); 
		return 	Dao.Actualizar(user);
	}
	
	@RequestMapping("/crearUsuario")
	public boolean crear(UsuarioVO usu){
		UsuarioDAO Dao=new UsuarioDAO(); 
	    return Dao.Crear(usu);	    
	 }
	
	@RequestMapping("/borrarUsuario")
	public boolean borrar(UsuarioVO usu){
		UsuarioDAO Dao=new UsuarioDAO(); 
	    return Dao.Borrar(usu);	    
	 }
	
	@RequestMapping("/listarUsuario")
	public ArrayList<UsuarioVO> listarUsuario() {
		UsuarioDAO Dao=new UsuarioDAO(); 
		return Dao.listarUsuario();		
	}
	
	@RequestMapping("/validarUsuario")
	public boolean validarUsuario(String usuario, String password) {
		UsuarioDAO Dao=new UsuarioDAO(); 
		return Dao.validarUsuario(usuario,password);
	}
}
