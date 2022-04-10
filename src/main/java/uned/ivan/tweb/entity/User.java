package uned.ivan.tweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="usuario",unique=true)
	private String usuario;
	
	@Column(name="contrasena")
	private String contrasena;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido1")
	private String apellido1;
	
	@Column(name="apellido2")
	private String apellido2;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;

	@OneToMany(mappedBy="cliente",cascade = {CascadeType.ALL})
	private List<Proyecto> proyectos;
	
	@OneToMany(mappedBy="cliente",cascade = {CascadeType.ALL})
	private List<Certificado> certificados;
	
	@OneToMany(mappedBy="cliente",cascade = {CascadeType.ALL})
	private List<Vivienda> viviendas;
	
	@Column(name="rol")
	private String rol;
	
	public List<Vivienda> getViviendas() {
		return viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	public User(String usuario, String contrasena, String nombre, String apellido1, String apellido2,
			String telefono, String email, List<Proyecto> proyectos, String rol) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.email = email;
		this.proyectos = proyectos;
		this.rol = rol;
	}

	public User() {
		super();
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", usuario=" + usuario + ", contraseña=" + contrasena + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", email="
				+ email + ", proyectos=" + proyectos + ", certificados=" + certificados + ", viviendas=" + viviendas
				+ ", rol=" + rol + "]";
	}

	public void agregarProyecto(Proyecto proyecto) {
		if(proyectos == null) {
			proyectos = new ArrayList<Proyecto>();
		}
		proyectos.add(proyecto);
	}
	
	public void agregarVivienda(Vivienda vivienda) {
		if(viviendas == null) {
			viviendas = new ArrayList<Vivienda>();
		}
		viviendas.add(vivienda);
	}
	
	public void agregarCertificado(Certificado certificado) {
		if(certificados == null) {
			certificados = new ArrayList<Certificado>();
		}
		certificados.add(certificado);
	}

}
