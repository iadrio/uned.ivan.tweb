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
public class Proyecto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private String tipo;
	
	@Column(name="estado")
	private String estado;
	
	//Proyecto no residencial y residencial
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="superficieTerreno")
	private int superficieTerreno;
	
	@Column(name="superficieEdificio")
	private int superficieEdificio;
	
	//Proyecto no residencial
	
	@Column(name="finalidad")
	private String finalidad;
	
	//Proyecto rehabitliacion
	@Column(name="superficieReforma")
	private int superficieReforma;
	
	//Proyecto  residencial
	
	@Column(name="plantas")
	private int plantas;
	
	@Column(name="habitaciones")
	private int habitaciones;
	
	@Column(name="banhos")
	private int banhos;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public int getSuperficieTerreno() {
		return superficieTerreno;
	}

	public void setSuperficieTerreno(int superficieTerreno) {
		this.superficieTerreno = superficieTerreno;
	}

	public int getSuperficieEdificio() {
		return superficieEdificio;
	}

	public void setSuperficieEdificio(int superficieEdificio) {
		this.superficieEdificio = superficieEdificio;
	}

	public String getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(String finalidad) {
		this.finalidad = finalidad;
	}

	public int getSuperficieReforma() {
		return superficieReforma;
	}

	public void setSuperficieReforma(int superficieReforma) {
		this.superficieReforma = superficieReforma;
	}

	public int getPlantas() {
		return plantas;
	}

	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public int getBanhos() {
		return banhos;
	}

	public void setBanhos(int banhos) {
		this.banhos = banhos;
	}

	public Proyecto(int id, User cliente, User empleado, Date fechaSolicitud, Date fechaInicioConstruccion,
			int duracionPrevista, Date fechaFin, float coste, String direccion, String tipo, String estado,
			int superficieTerreno, int superficieEdificio, String finalidad, int superficieReforma, int plantas,
			int habitaciones, int banhos) {
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
		this.superficieTerreno = superficieTerreno;
		this.superficieEdificio = superficieEdificio;
		this.finalidad = finalidad;
		this.superficieReforma = superficieReforma;
		this.plantas = plantas;
		this.habitaciones = habitaciones;
		this.banhos = banhos;
	}

	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", cliente=" + cliente.getId() + ", empleado=" + empleado + ", fechaSolicitud="
				+ fechaSolicitud + ", fechaInicioConstruccion=" + fechaInicioConstruccion + ", duracionPrevista="
				+ duracionPrevista + ", fechaFin=" + fechaFin + ", coste=" + coste + ", direccion=" + direccion
				+ ", tipo=" + tipo + ", estado=" + estado + ", superficieTerreno=" + superficieTerreno
				+ ", superficieEdificio=" + superficieEdificio + ", finalidad=" + finalidad + ", superficieReforma="
				+ superficieReforma + ", plantas=" + plantas + ", habitaciones=" + habitaciones + ", banhos=" + banhos
				+ "]";
	}
	


	
	
}
