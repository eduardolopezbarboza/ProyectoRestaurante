package pe.usmp.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "persona")

public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min=3, max=30,message="El nombre debe tener una longitud minima de {min} y maxima {max}")
	private String nombre;
	
	@NotEmpty
	@Size(min=3, max=30,message="El apellido debe tener una longitud minima de {min} y maxima {max}")
	private String apellido;
	
	@NotEmpty(message="Ingrese un correo válido")
	private String correo;
	
	@NotEmpty(message="Ingrese una contraseña")
	private String password;
	
	@NotEmpty(message="Valide la contraseña")
	private String confpassword;
	
	private String mensajeConfirmacion;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMensajeConfirmacion() {
		return mensajeConfirmacion;
	}
	public void setMensajeConfirmacion(String mensajeConfirmacion) {
		this.mensajeConfirmacion = mensajeConfirmacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfpassword() {
		return confpassword;
	}
	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}
	
}
