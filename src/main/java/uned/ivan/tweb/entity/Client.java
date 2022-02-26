package uned.ivan.tweb.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client extends User {
	
	

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String usuario, String contraseña, String nombre, String apellido1, String apellido2, String telefono,
			String email) {
		super(usuario, contraseña, nombre, apellido1, apellido2, telefono, email);
		// TODO Auto-generated constructor stub
	}

	
}
