package uned.ivan.tweb.entity;

import java.util.List;

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
			String email, List<Proyecto> proyectos) {
		super(usuario, contraseña, nombre, apellido1, apellido2, telefono, email, proyectos);
		// TODO Auto-generated constructor stub
	}

	

	
}
