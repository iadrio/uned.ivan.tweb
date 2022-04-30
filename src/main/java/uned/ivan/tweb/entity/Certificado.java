package uned.ivan.tweb.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Certificado {
	//Comunes
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificados")
    @SequenceGenerator(name="certificados", sequenceName = "certificados")
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
	@JoinColumn(name="id_arquitecto")
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

	
	public void setEmpleado(User user) {
		this.arquitecto = user;
	}
	

	public void presupuestar(float coste) throws Exception{
		if(esPresupuestable()) {
			this.setPrecio(coste);
			this.setEstado(EstadosCertificado.PRESUPUESTADO);
		}else {
			throw new Exception("Estado no permitido " + this.estado);
		}
	}
	

	public void visitar() throws Exception{
		if(esVisitable()) {
			this.setEstado(EstadosCertificado.VISITA_REALIZADA);
		}else {
			throw new Exception("Estado no permitido " + this.estado);
		}
	}
	
	public void cancelar() throws Exception{
		if(esCancelable()) {
			this.setEstado(EstadosCertificado.CANCELADO);
		}else {
			throw new Exception("Estado no permitido " + this.estado);
		}
	}
	
	public void finalizar() throws Exception{
		if(esFinalizable()) {
			this.setEstado(EstadosCertificado.FINALIZADO);
			this.setFechaEntrega(new Date());
		}else {
			throw new Exception("Estado no permitido " + this.estado);
		}
	}
	
	public void asignar(User user) throws Exception{
		if(esEditable()) {
			user.agregarCertificado(this);
			this.setEmpleado(user);
			this.setEstado(EstadosCertificado.ASIGNADO);
		}else {
			throw new Exception("Estado no permitido " + this.estado);
		}
	}
	
	public  boolean esFinalizable() {
		List<EstadosCertificado> estadosPermitidos = Arrays.asList(EstadosCertificado.PRESUPUESTADO);
		if(estadosPermitidos.contains(this.estado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public  boolean esCancelable() {
		List<EstadosCertificado> estadosPermitidos = Arrays.asList(EstadosCertificado.SOLICITADO,EstadosCertificado.ASIGNADO,EstadosCertificado.PRESUPUESTADO);
		if(estadosPermitidos.contains(this.estado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esVisitable() {
		List<EstadosCertificado> estadosPermitidos = Arrays.asList();
		if(estadosPermitidos.contains(this.estado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esPresupuestable() {
		List<EstadosCertificado> estadosPermitidos = Arrays.asList(EstadosCertificado.ASIGNADO);
		if(estadosPermitidos.contains(this.estado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esEditable() {
		List<EstadosCertificado> estadosProhibidos = Arrays.asList(EstadosCertificado.CANCELADO,EstadosCertificado.FINALIZADO);
		if(estadosProhibidos.contains(this.estado)) {
			return false;
		}else {
			return true;
		}
	}
	
	public abstract boolean isExpirable();
}
