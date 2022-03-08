package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="ProyectoResidencial")
public class ProyectoResidencial extends Proyecto {
	
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
	public ProyectoResidencial() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public ProyectoResidencial(int id, Client cliente, Employee empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, String direccion,
			String tipo, String estado) {
		super(id, cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, direccion,
				tipo, estado);
		// TODO Auto-generated constructor stub
	}
	public ProyectoResidencial(int id, Client cliente, Employee empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, String direccion,
			String tipo, String estado, int superficieTerreno, int superficieEdificio, int plantas,
			int habitaciones, int banhos) {
		super(id, cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste,
				direccion, tipo, estado);
		this.superficieTerreno = superficieTerreno;
		this.superficieEdificio = superficieEdificio;
		this.plantas = plantas;
		this.habitaciones = habitaciones;
		this.banhos = banhos;
	}
	@Override
	public String toString() {
		return "ProyectoResidencial [superficieTerreno=" + superficieTerreno + ", superficieEdificio="
				+ superficieEdificio + ", plantas=" + plantas + ", habitaciones=" + habitaciones + ", banhos=" + banhos
				+ "] " + super.toString();
	}
	
	
	
	
}
