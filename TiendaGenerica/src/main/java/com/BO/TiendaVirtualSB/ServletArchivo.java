package com.BO.TiendaVirtualSB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.DTO.TiendaVirtualSB.ProductoVO;

@WebServlet("/servletArchivo")
@MultipartConfig
public class ServletArchivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletArchivo() {
        //super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ArrayList<ProductoVO> inputList = new ArrayList<ProductoVO>();
		String line;
		ProductoVO prod;
		ArrayList<ProductoVO> listaProductos = new ArrayList<ProductoVO>();
		ProductoController prodCtrl = new ProductoController();
		ProveedorController provCtrl = new ProveedorController();
		try {
		    Part filePart = request.getPart("archivo"); // Retrieves <input type="file" name="file">
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    if(fileName.equals("")) {
	        	  System.out.println("Archivo vacío");
	        	  request.setAttribute("validacion", "Error: no se seleccionó archivo para cargar");
	  		      request.getRequestDispatcher("Productos.jsp").forward(request, response);
	        }
		    else {
		  
		    InputStream fileContent = filePart.getInputStream();
		    System.out.println(fileName);
		    BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));
		    
		    while ((line = br.readLine()) != null) {

		          // Separador split por caracter indicado
		          String[] split = line.split(";");
		          System.out.println("\nLength : " + split.length);
		          System.out.println("split[0] : " + split[0]);
		          System.out.println("split[1] : " + split[1]);
		          System.out.println("split[2] : " + split[2]);
		          System.out.println("split[3] : " + split[3]);
		          System.out.println("split[4] : " + split[4]);
		          System.out.println("split[5] : " + split[5]);
		          
		          if(provCtrl.consultar(Integer.parseInt(split[2])) != null) {
		        	  prod = new ProductoVO();
		        	  prod.setCodigo(Integer.parseInt(split[0]));
			          prod.setNombre_producto(split[1]);
			          prod.setNIT_proveedor(Integer.parseInt(split[2]));
			          prod.setPrecio_compra(Double.parseDouble(split[3]));
			          prod.setIVA(Double.parseDouble(split[4]));
			          prod.setPrecio_venta(Double.parseDouble(split[5]));
			          
			          listaProductos.add(prod);
		          }else {
		        	  System.out.println("Adición de item " + split[0] + " presento falla.");
		        	  request.setAttribute("validacion", "Archivo contiene proveedor " + split[2] + " inexistente");
		  		      request.getRequestDispatcher("Productos.jsp").forward(request, response);
		  		      listaProductos = null;
		        	  break;
		          }
		      }
		      br.close();
		      
		      if(listaProductos != null) {
		    	  //System.out.println("Array Size: " + listaProductos.size());
		    	  int contador = 0;
		    	  prodCtrl.borrarTodo();
		    	  for(int i=0; i<listaProductos.size(); i++)
		          {
		    		  //System.out.println("Item: " + listaProductos.get(i).getCodigo());
		    		  
		    		  if(prodCtrl.crear(listaProductos.get(i))) {
			        	  System.out.println("Adición de item " + (i + 1) + " exitosa!");
			        	  contador++;
			          }else {
			        	  System.out.println("Adición de item " + i + " presento falla.");
			        	  request.setAttribute("validacion", "Error: Item " + (i + 1) + " no se pudo adicionar a base de datos");
			  		      request.getRequestDispatcher("Productos.jsp").forward(request, response);
			  		      break;
			          }
		          }
		    	  if(contador == listaProductos.size()) {
		    		  request.setAttribute("validacion", "Archivo Cargado Exitosamente");
			    	  request.getRequestDispatcher("Productos.jsp").forward(request, response);
		    	  }
		      }
		   }
		} catch (IOException | NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Error en la lectura del archivo");
			request.setAttribute("validacion", "Error: formato de archivo inválido");
		    request.getRequestDispatcher("Productos.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			System.out.println("Error de tipo de datos");
			request.setAttribute("validacion", "Error: datos leídos inválidos");
		    request.getRequestDispatcher("Productos.jsp").forward(request, response);
	    }
	}
}
