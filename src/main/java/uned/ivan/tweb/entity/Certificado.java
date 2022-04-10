package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  abstract class Certificado {
	//Comunes
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	private int id;
	
	@Column(name="tipo")
	private TipoCertificado tipo;	
	
	@Column(name="fechaSolicitud")
	private Date fechaSolicitud;
	
	@Column(name="fechaEntrega")
	private Date fechaEntrega;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="id_cliente")
	private User cliente;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="id_arquiteecto")
	private User arquitecto;
	
	@Column(name="precio")
	private float precio;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="id_vivienda")
	private Vivienda vivienda;
	
	@Column(name="estado")
	private EstadosCertificado estado;
	
	@Column(name="otrosDatos")
	private String otrosDatos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoCertificado getTipo() {
		return tipo;
	}

	public void setTipo(TipoCertificado tipo) {
		this.tipo = tipo;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	public User getArquitecto() {
		return arquitecto;
	}

	public void setArquitecto(User arquitecto) {
		this.arquitecto = arquitecto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public String getOtrosDatos() {
		return otrosDatos;
	}

	public void setOtrosDatos(String otrosDatos) {
		this.otrosDatos = otrosDatos;
	}
	
	public EstadosCertificado getEstado() {
		return estado;
	}

	public void setEstado(EstadosCertificado estado) {
		this.estado = estado;
	}

	public Certificado(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente, User arquitecto,
			float precio, Vivienda vivienda, EstadosCertificado estado, String otrosDatos) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.cliente = cliente;
		this.arquitecto = arquitecto;
		this.precio = precio;
		this.vivienda = vivienda;
		this.estado = estado;
		this.otrosDatos = otrosDatos;
	}

	public Certificado() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Certificado [id=" + id + ", tipo=" + tipo + ", fechaSolicitud=" + fechaSolicitud + ", fechaEntrega="
				+ fechaEntrega + ", cliente=" + cliente.getId() + ", arquitecto=" + arquitecto + ", precio=" + precio
				+ ", vivienda=" + vivienda.getId() + ", estado=" + estado + ", otrosDatos=" + otrosDatos + "]";
	}


	

}
