package uned.ivan.tweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee extends User{
	
	@Column(name="rol")
	private String rol;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String usuario, String contraseña, String nombre, String apellido1, String apellido2,
			String telefono, String email) {
		super(usuario, contraseña, nombre, apellido1, apellido2, telefono, email);
		// TODO Auto-generated constructor stub
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
