package uned.ivan.tweb.entity;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	private String usuario;
	private String contrasena;
	private String rol;
	private boolean empleado;
	private User user;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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
	public UserSession(String usuario, String contraseña, String rol, boolean empleado,User user) {
		super();
		this.usuario = usuario;
		this.contrasena = contraseña;
		this.rol = rol;
		this.empleado = empleado;
		this.user = user;
	}
	
	
	@Override
	public String toString() {
		return "UserSession [usuario=" + usuario + ", contraseña=" + contrasena + ", rol=" + rol + ", empleado="
				+ empleado + ", user=" + user + "]";
	}
	
	public void reset() {
		usuario = null;
		contrasena = null;
		rol = null;
		user = null;
	}
	

	
	
	
	
	

	
}
