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
import pe.usmp.model.PersonaRepository;

import pe.usmp.model.Usuario;

@Controller
public class addUserController {
	
	@Autowired
	private PersonaRepository personaRepo;
	
	@GetMapping("/acceder")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	/*@PostMapping("/acceder")
	public String submitUsuario(@ModelAttribute Usuario usuario) {
		String direccion = "";
		if(usuario.getStusuario().equals("admin") && usuario.getClave().equals("12345")) {
			direccion="indexAdmin";
		}else {
			System.out.println("Acceder Post Usuario" + usuario.getStusuario());
			direccion="login";
		}
		return direccion;
	}*/
	
	@PostMapping("/acceder")
	public String submitUsuario(@ModelAttribute Usuario usuario, Map<String, Object> model) {
		List<Persona> pers = personaRepo.findAll();
		String nom=usuario.getStusuario();
		String pass=usuario.getClave();
		int x=1;
		String direccion = "";

		if(pers.isEmpty()) {
			System.out.println("Acceder Post Usuario" + usuario.getStusuario());
			direccion="login";
		}else {
			do {
				if(nom.equals(pers.get(x).getNombre()) && pass.equals(pers.get(x).getPassword())){
					direccion="indexUser";
				}else {
					direccion="login";
					if(x<pers.size()) {
						x++;
					}
				}
			}while(nom.compareTo(pers.get(x).getNombre())!=0 && pass.compareTo(pers.get(x).getPassword())!=0);
			
			if(nom.equals("admin") && pass.equals("12345")) {
				direccion="indexAdmin";
			}else {
				direccion="login";
			}
		}
		
		return direccion;
	}
	
	@GetMapping("/indexAdmin")
	public String logedAdmin(Model model) {
		return "indexAdmin";
	}
	
	@GetMapping("/indexUser")
	public String logedUser(Model model) {
		return "indexUser";
	}
}
