package com.BO.TiendaVirtualSB;

//import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.ProductoDAO;
import com.DTO.TiendaVirtualSB.ProductoVO;


@RestController
public class ProductoController {
	
	ProductoDAO Dao=new ProductoDAO();
	
	@RequestMapping("/consultarProducto")
	public ProductoVO consultar(int code) {
		return 	Dao.Consultar(code);
	}
	
	public boolean actualizar(ProductoVO product) { 
		return 	Dao.Actualizar(product);
	}
	
	@RequestMapping("/crearProducto")
	public boolean crear(ProductoVO product) 
	{
	    return Dao.Crear(product);
	}
	
	@RequestMapping("/borrarProducto")
	public boolean borrar(ProductoVO product){
	    return Dao.Borrar(product);	    
	}
	
	@RequestMapping("/borrarTodoProducto")
	public boolean borrarTodo(){
	    return Dao.BorrarTodo();	    
	}
	/*
	@RequestMapping("/listarProducto")
	public ArrayList<ProductoVO> listarProducto() {
		return Dao.listarProducto();		
	}
	*/
}