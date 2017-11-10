package pe.usmp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "contacto")
public class Contacto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@NotEmpty
	@Size(min=3, max=50,message="El nombre debe tener una longitud minima de {min} y maxima {max}")
	private String Nombre;
	
	@NotEmpty
	@Size(min=3, max=50,message="El correo debe tener una longitud minima de {min} y maxima {max}")
	private String correo;
	
	@NotEmpty
	@Size(min=1, max=120,message="El mensaje debe tener una longitud minima de {min} y maxima {max}")
	private String queja;
	
	
	
	

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getQueja() {
		return queja;
	}

	public void setQueja(String queja) {
		this.queja = queja;
	}
	
	
	
	


}
