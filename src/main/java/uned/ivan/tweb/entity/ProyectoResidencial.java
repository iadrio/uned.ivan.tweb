package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProyectoResidencial extends Proyecto{
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="superficieTerreno")
	private int superficieTerreno;
	
	@Column(name="superficieEdificio")
	private int superficieEdificio;
	
	@Column(name="plantas")
	private int plantas;
	
	@Column(name="habitaciones")
	private int habitaciones;
	
	@Column(name="banhos")
	private int banhos;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public ProyectoResidencial(User cliente, User empleado, Date fechaSolicitud, Date fechaInicioConstruccion,
			int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo, String estado, String direccion,
			int superficieTerreno, int superficieEdificio, int plantas, int habitaciones, int banhos) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo,
				estado);
		this.direccion = direccion;
		this.superficieTerreno = superficieTerreno;
		this.superficieEdificio = superficieEdificio;
		this.plantas = plantas;
		this.habitaciones = habitaciones;
		this.banhos = banhos;
		setTipo(TipoProyecto.RESIDENCIAL);
	}

	public ProyectoResidencial() {
		super();
		setTipo(TipoProyecto.RESIDENCIAL);
		// TODO Auto-generated constructor stub
	}

	public ProyectoResidencial(User cliente, User empleado, Date fechaSolicitud, Date fechaInicioConstruccion,
			int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo, String estado) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo, estado);
		setTipo(TipoProyecto.RESIDENCIAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProyectoResidencial [direccion=" + direccion + ", superficieTerreno=" + superficieTerreno
				+ ", superficieEdificio=" + superficieEdificio + ", plantas=" + plantas + ", habitaciones="
				+ habitaciones + ", banhos=" + banhos + "]";
	}
	
	
}
