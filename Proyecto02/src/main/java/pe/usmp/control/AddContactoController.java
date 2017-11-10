package pe.usmp.control;

import java.util.List;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.usmp.model.Contacto;
import pe.usmp.model.ContactoRepository;


@Controller
public class AddContactoController {

	@Autowired
	private ContactoRepository contactoRepo;
	
	
	@GetMapping("/agregarContacto")
	public String loadFormContacto(Model model) {
		model.addAttribute("contacto", new Contacto());
		return "contacto";
	}
	
	
	@PostMapping("/agregarContacto")
	public String submitContacto(@Valid 
			Contacto contacto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			return "contacto";
		}else {
			contactoRepo.save(contacto);
			
			return "resultadoContacto";
			
		
		}	
		
	}


	
	
	@GetMapping(value = "/contacto/{contactId}/eliminar")
	public String eliminarContact(@PathVariable("contactId") long codigo,
			Model model) {
		System.out.println("Codigo : " + codigo);
		contactoRepo.delete(codigo);
		return "redirect:/listarContacto";
	}

	@GetMapping("/listarContacto")
	public String list(Map<String, Object> model) {
		List<Contacto> contactos = contactoRepo.findAll();
		model.put("contactos", contactos);
		return "listaContacto";
	}
	
	@GetMapping(value = "/contacto/{contactoId}/edit")
	public String editContacto(@PathVariable("contactoId") long codigo,
			Model model) {
		Contacto contacto = contactoRepo.findOne(codigo);
		System.out.println("Codigo de Edit " + contacto.getCodigo());
		model.addAttribute("contacto", contacto);
		return "contacto";
	}
}


