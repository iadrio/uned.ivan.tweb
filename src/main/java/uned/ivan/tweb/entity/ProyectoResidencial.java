package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProyectoResidencial extends Proyecto{
	@NotNull
	@Min(value = 1, message = "La superficie de terreno de la parcela debe ser mayor que 0")
	@Column(name="superficieTerreno")
	private int superficieTerreno;

	@NotNull
	@Min(value = 1, message = "La superficie del edificio debe ser mayor que 0")
	@Column(name="superficieEdificio")
	private int superficieEdificio;
	
	@NotNull
	@Min(value = 1,message = "El numero de plantas debe ser mayor que 0")
	@Column(name="plantas")
	private int plantas;
	
	@NotNull
	@Min(value = 1,message = "El numero de habitaciones debe ser mayor que 0")
	@Column(name="habitaciones")
	private int habitaciones;
	
	@NotNull
	@Min(value = 1,message = "El numero de baños debe ser mayor que 0")
	@Column(name="banhos")
	private int banhos;

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
			int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo, EstadosProyecto estado,
			int superficieTerreno, int superficieEdificio, int plantas, int habitaciones, int banhos) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo,
				estado);
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
			int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo, EstadosProyecto estado) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo, estado);
		setTipo(TipoProyecto.RESIDENCIAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProyectoResidencial [direccion=" + getVivienda().getDireccion() + ", superficieTerreno=" + superficieTerreno
				+ ", superficieEdificio=" + superficieEdificio + ", plantas=" + plantas + ", habitaciones="
				+ habitaciones + ", banhos=" + banhos + "]";
	}
	
	
}
