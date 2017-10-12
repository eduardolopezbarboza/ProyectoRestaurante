package usmp.pe.demo.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import usmp.pe.demo.model.Persona;

import usmp.pe.demo.model.PersonaRepository;

@Controller
public class AddPersonaController {
	
	@Autowired
	private PersonaRepository personaRepo;
	
	@GetMapping("/signIn")
	public String loadPerson(Model model) {
		model.addAttribute("persona", new Persona());
		return "signIn";
	}
	
	@PostMapping("/signIn")
	public String submitPerson(@ModelAttribute Persona persona) {
		if(persona.getConfirmpass().equals(persona.getPassword())) {
			personaRepo.save(persona);
			return "account";
		}else {
			return "error";
		}
	}
	
	@PostMapping("/saveUser")
	public String savePerson(@ModelAttribute Persona persona) {
		if(persona.getConfirmpass().equals(persona.getPassword())) {
			personaRepo.save(persona);
			return "account";
		}else {
			return "error";
		}
	}
	
	@GetMapping(value = "/person/{personId}/edit")
	public String editPerson(@PathVariable("personId") long id,
			Model model) {
		Persona person =personaRepo.findOne(id);
		model.addAttribute(person);
		return "editUser";
	}

}
