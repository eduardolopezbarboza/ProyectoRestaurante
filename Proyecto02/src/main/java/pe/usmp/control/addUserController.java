package pe.usmp.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import pe.usmp.model.Usuario;



@Controller
public class addUserController {
	
	
	@GetMapping("/acceder")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping("/acceder")
	public String submitUsuario(@ModelAttribute Usuario usuario) {
		String direccion = "";
		if(usuario.getStusuario().equals("admin") && usuario.getClave().equals("12345")) {
			direccion="inicio";
		}else {
			System.out.println("Acceder Post Usuario" + usuario.getStusuario());
			direccion="login";
		}
		return direccion;
	}
	
	
}
