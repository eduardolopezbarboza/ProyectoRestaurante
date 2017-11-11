package pe.usmp.control;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.usmp.model.Persona;
import pe.usmp.model.Producto;
import pe.usmp.model.ProductoRepository;

@Controller
public class AddProductoController {
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@GetMapping("/agregarProducto")
	public String loadFormProducto(Model model, Locale locale) {
		model.addAttribute("producto", new Producto());
		return "productoForm";
	}
	
	@PostMapping("/agregarProducto")
	public String submitProducto(@Valid 
			Producto producto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "productoForm";
		}else {
			productoRepo.save(producto);
			return "resultadoProducto";
		}		
	}
	
	@PostMapping("/saveProduct")
	public String savePerson(@ModelAttribute Producto producto) {
		productoRepo.save(producto);
		return "indexAdmin";
	}

	@GetMapping(value = "/producto/{productId}/eliminar")
	public String eliminarPerson(@PathVariable("productId") long codigo,
			Model model) {
		System.out.println("Codigo : " + codigo);
		productoRepo.delete(codigo);
		return "redirect:/listarProductos";
	}

	@GetMapping("/listarProductos")
	public String list(Map<String, Object> model) {
		List<Producto> productos = productoRepo.findAll();
		model.put("productos", productos);
		return "listaProductos";
	}
	
	@GetMapping(value = "/producto/{productId}/edit")
	public String editPerson(@PathVariable("productId") long codigo,
			Model model) {
		Producto producto = productoRepo.findOne(codigo);
		System.out.println("Codigo de Edit " + producto.getCodigo());
		model.addAttribute("producto", producto);
		return "editarProducto";
	}

}
