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
		String nom=usuario.getStusuario();
		String pass=usuario.getClave();
		/*List<Persona> nomdb = personaRepo.findByNombre(nom);*/
		List<Persona> passdb = personaRepo.findByPassword(pass);
		List<Persona> nomdb = personaRepo.findNombreByPassword(pass);
		String direccion = "";

		if(nom.equals("") && pass.equals("")) {
			System.out.println("Acceder Post Usuario" + usuario.getStusuario());
			direccion="login";
			System.out.println("Esta vacio");
		}else {
			if(nom.equals("admin") && pass.equals("12345")) {
				direccion="indexAdmin";
				System.out.println("Si funciona, redirecciona a admin");
			}else {
				if(nomdb.toString().equalsIgnoreCase("["+nom+"]") && passdb.toString().equalsIgnoreCase("["+pass+"]")) {
					direccion="indexUser";
					System.out.println("Si funciona, redirecciona a user");
				}else {
					direccion="login";
					System.out.println("Los datos no concuerdan");
				}
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
