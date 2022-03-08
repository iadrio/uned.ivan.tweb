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
import javax.persistence.Table;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Proyecto {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="cliente_id")
	private Client cliente;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="arquitecto_id")
	private Employee empleado;
	
	@Column(name="fechaSolicitud")
	private Date fechaSolicitud;
	
	@Column(name="fechaInicioConstruccion")
	private Date fechaInicioConstruccion;
	
	@Column(name="duracionPrevista")
	private int duracionPrevista;
	
	@Column(name="fechaFin")
	private Date fechaFin;
	
	@Column(name="coste")
	private float coste;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="estado")
	private String estado;



	public Proyecto(int id, Client cliente, Employee empleado, Date fechaSolicitud, Date fechaInicioConstruccion,
			int duracionPrevista, Date fechaFin, float coste, String direccion, String tipo, String estado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.empleado = empleado;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicioConstruccion = fechaInicioConstruccion;
		this.duracionPrevista = duracionPrevista;
		this.fechaFin = fechaFin;
		this.coste = coste;
		this.direccion = direccion;
		this.tipo = tipo;
		this.estado = estado;
	}

	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public Employee getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employee empleado) {
		this.empleado = empleado;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaInicioConstruccion() {
		return fechaInicioConstruccion;
	}

	public void setFechaInicioConstruccion(Date fechaInicioConstruccion) {
		this.fechaInicioConstruccion = fechaInicioConstruccion;
	}

	public int getDuracionPrevista() {
		return duracionPrevista;
	}

	public void setDuracionPrevista(int duracionPrevista) {
		this.duracionPrevista = duracionPrevista;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", cliente=" + cliente + ", empleado=" + empleado + ", fechaSolicitud="
				+ fechaSolicitud + ", fechaInicioConstruccion=" + fechaInicioConstruccion + ", duracionPrevista="
				+ duracionPrevista + ", fechaFin=" + fechaFin + ", coste=" + coste + ", direccion=" + direccion
				+ ", tipo=" + tipo + ", estado=" + estado + "]";
	}


	
	
}
