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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Proyecto {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="cliente_id")
	private User cliente;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="arquitecto_id")
	private User empleado;
	
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
	
	@Column(name="tipo")
	private TipoProyecto tipo;
	
	@Column(name="estado")
	private String estado;

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

	public User getEmpleado() {
		return empleado;
	}

	public void setEmpleado(User empleado) {
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

	public TipoProyecto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProyecto tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Proyecto(User cliente, User empleado, Date fechaSolicitud, Date fechaInicioConstruccion,
			int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo, String estado) {
		super();
		this.cliente = cliente;
		this.empleado = empleado;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicioConstruccion = fechaInicioConstruccion;
		this.duracionPrevista = duracionPrevista;
		this.fechaFin = fechaFin;
		this.coste = coste;
		this.tipo = tipo;
		this.estado = estado;
	}

	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", cliente=" + cliente.getId() + ", fechaSolicitud="
				+ fechaSolicitud + ", fechaInicioConstruccion=" + fechaInicioConstruccion + ", duracionPrevista="
				+ duracionPrevista + ", fechaFin=" + fechaFin + ", coste=" + coste + ", tipo=" + tipo + ", estado="
				+ estado + "]";
	}
}
