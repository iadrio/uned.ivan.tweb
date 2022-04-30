package uned.ivan.tweb.entity;

import java.util.ArrayList;
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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proyectos")
    @SequenceGenerator(name="proyectos", sequenceName = "proyectosId")
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
	private EstadosProyecto estado;
	
	@Column(name="notas")
	private String notas;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_vivienda")
	private Vivienda vivienda;
	
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

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public User getEmpleado() {
		return empleado;
	}

	public void setEmpleado(User empleado) {
		this.empleado = empleado;
	}
	
	public String getDireccion() {
		if(vivienda!=null) {
			return vivienda.getDireccion();
		}else {
			return null;
		}
	}

	public void setDireccion(String direccion) {
		if(vivienda!=null) {
			vivienda.setDireccion(direccion);
		}else {
			vivienda = new Vivienda();
			vivienda.setDireccion(direccion);
		}
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

	public EstadosProyecto getEstado() {
		return estado;
	}

	public void setEstado(EstadosProyecto estado) {
		this.estado = estado;
	}
	
	

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Proyecto(User cliente, User empleado, Date fechaSolicitud, Date fechaInicioConstruccion,
			int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo, EstadosProyecto estado) {
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
		this.setFechaSolicitud(new Date());
		this.setEstado(EstadosProyecto.SOLICITADO);	
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", cliente=" + "cliente.getId()" + ", fechaSolicitud="
				+ fechaSolicitud + ", fechaInicioConstruccion=" + fechaInicioConstruccion + ", duracionPrevista="
				+ duracionPrevista + ", fechaFin=" + fechaFin + ", coste=" + coste + ", tipo=" + tipo + ", estado="
				+ estado + "]";
	}
	
	public void presupuestar(int duracionPrevista,float coste) throws Exception{
		if(esPresupuestable()) {
			this.setDuracionPrevista(duracionPrevista);
			this.setCoste(coste);
			this.setEstado(EstadosProyecto.PRESUPUESTADO);
		}else {
			throw new Exception("Estado no permitido " + this.estado);
		}
	}
	
	public void asignar(User user) throws Exception{
		if(esEditable()) {
			user.agregarProyecto(this);
			this.setEmpleado(user);
			this.setEstado(EstadosProyecto.ASIGNADO);
		}else {
			throw new Exception("Estado no permitido " + this.estado);
		}
	}
	
	public void cancelar() throws Exception {
		if(esCancelable()) {
			this.setFechaFin(new Date());
			this.setEstado(EstadosProyecto.CANCELADO);		
		}else {
			throw new Exception("Estado no permitido " + this.estado);
		}
	}
	
	
	public  boolean esFinalizable() {
		List<EstadosProyecto> estadosPermitidos = Arrays.asList(EstadosProyecto.EN_CURSO);
		if(estadosPermitidos.contains(this.estado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public  boolean esCancelable() {
		List<EstadosProyecto> estadosPermitidos = Arrays.asList(EstadosProyecto.SOLICITADO,EstadosProyecto.PRESUPUESTADO,EstadosProyecto.ASIGNADO);
		if(estadosPermitidos.contains(this.estado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esPresupuestable() {
		List<EstadosProyecto> estadosPermitidos = Arrays.asList(EstadosProyecto.ASIGNADO);
		if(estadosPermitidos.contains(this.estado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esEditable() {
		List<EstadosProyecto> estadosProhibidos = Arrays.asList(EstadosProyecto.CANCELADO,EstadosProyecto.FINALIZADO);
		if(estadosProhibidos.contains(this.estado)) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean esIniciable() {
		List<EstadosProyecto> estadosPermitidos = Arrays.asList(EstadosProyecto.EN_CURSO);
		if(estadosPermitidos.contains(this.estado)) {
			return true;
		}else {
			return false;
		}
	}
}
