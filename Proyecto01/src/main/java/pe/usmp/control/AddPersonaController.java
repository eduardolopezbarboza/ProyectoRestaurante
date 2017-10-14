package pe.usmp.control;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pe.usmp.model.Persona;
import  pe.usmp.model.PersonaRepository;

@Controller
public class AddPersonaController {

	@Autowired
	private PersonaRepository personaRepo;

	@GetMapping("/index")
	public String loadFormPerson(Model model) {
		model.addAttribute("persona", new Persona());
		return "index";
	}

	@PostMapping("/index")
	public String submitPerson(@ModelAttribute Persona persona) {

		personaRepo.save(persona);

		return "index";
	}


}
