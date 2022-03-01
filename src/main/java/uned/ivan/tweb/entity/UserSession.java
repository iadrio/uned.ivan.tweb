package uned.ivan.tweb.entity;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	private String usuario;
	private String contraseña;
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
	public UserSession(String usuario, String contraseña, String rol, boolean empleado,User user) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.rol = rol;
		this.empleado = empleado;
		this.user = user;
	}
	
	
	@Override
	public String toString() {
		return "UserSession [usuario=" + usuario + ", contraseña=" + contraseña + ", rol=" + rol + ", empleado="
				+ empleado + ", user=" + user + "]";
	}
	
	public void reset() {
		usuario = null;
		contraseña = null;
		rol = null;
		user = null;
	}
	

	
	
	
	
	

	
}
