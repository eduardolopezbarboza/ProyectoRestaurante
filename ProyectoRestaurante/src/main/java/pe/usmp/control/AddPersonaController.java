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
import org.springframework.web.bind.annotation.PostMapping;

import pe.usmp.model.Persona;
import  pe.usmp.model.PersonaRepository;

@Controller
public class AddPersonaController {

	@Autowired
	private PersonaRepository personaRepo;

	@GetMapping("/")
	public String loadFormPerson(Model model, Locale locale) {
		model.addAttribute("persona", new Persona());
		return "index";
	}
	
	/*@GetMapping("/addUser")
	public String loadFormPerson(Model model) {
		model.addAttribute("persona", new Persona());
		return "registrar";
	}*/
	
	@PostMapping("/addUser")
	public String submitPerson(@Valid Persona persona, BindingResult result, Model model) {
		String password = persona.getPassword();
		String confpassword = persona.getConfpassword();
		String direccion = "";
		if(result.hasErrors()) {
			direccion="index";
		}else {
			if(password.equals(confpassword)) {
				persona.setMensajeConfirmacion("Se grabo correctamente");
				direccion = "resultado";
				personaRepo.save(persona);
			}else {
				persona.setMensajeConfirmacion("Las claves deben coincidir. ¡Verificar!");
				direccion = "index";
			}
		}
		return direccion;
	}
	
	/*@PostMapping("/addUser")
	public String submitPerson(@Valid Persona persona, BindingResult result, Model model) {
		String password = persona.getPassword();
		String confpassword = persona.getConfpassword();
		String direccion = "";
		if(result.hasErrors()) {
			direccion="registrar";
		}else {
			if(password.equals(confpassword)) {
				persona.setMensajeConfirmacion("Se grabo correctamente");
				direccion = "resultado";
				personaRepo.save(persona);
			}else {
				persona.setMensajeConfirmacion("Las claves deben coincidir. ¡Verificar!");
				direccion = "registrar";
			}
		}
		return direccion;
	}*/
	
	@GetMapping("/listarCuentas")
	public String list(Map<String, Object> model) {
		List<Persona> pers = personaRepo.findAll();
		model.put("usuarios", pers);
		return "listaUsuarios";
	}
	
	
	/*@PostMapping("/addPerson")
	public String submitPerson(@ModelAttribute Persona persona) {

		personaRepo.save(persona);

		return "result";
	}

	@GetMapping("/listPerson")
	public String list(Map<String, Object> model) {
		List<Persona> pers = personaRepo.findAll();
		model.put("pers", pers);
		return "persList";
	} */
}
