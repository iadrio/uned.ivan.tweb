package uned.ivan.tweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vivienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="id_cliente")
	private User cliente;
	
	@Column(name="direccion")
	private String direccion;
	
	@OneToMany(mappedBy="vivienda",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Certificado> certificados;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	public Vivienda(int id, User cliente, String direccion, List<Certificado> certificados) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.direccion = direccion;
		this.certificados = certificados;
	}

	public Vivienda() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Vivienda [id=" + id + ", cliente=" + cliente.getId() + ", direccion=" + direccion + ", certificados="
				+ certificados + "]";
	}
	
	public void agregarCertificado(Certificado certificado) {
		if(certificados == null) {
			certificados = new ArrayList<Certificado>();
		}
		certificados.add(certificado);
	}
	
	
}
