package uned.ivan.tweb.entity;

import org.springframework.stereotype.Component;

@Component
public class UserSession {
	private String usuario;
	private String contraseña;
	private String rol;
	private boolean empleado;
	
	
	
	public boolean isEmpleado() {
		return empleado;
	}
	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public UserSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSession(String usuario, String contraseña, String rol, boolean empleado) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.rol = rol;
		this.empleado = empleado;
	}
	@Override
	public String toString() {
		return "UserSession [usuario=" + usuario + ", contraseña=" + contraseña + ", rol=" + rol + ", empleado="
				+ empleado + "]";
	}
	
	
	
	

	
}
