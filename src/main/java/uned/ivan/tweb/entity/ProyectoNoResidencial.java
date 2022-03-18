package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProyectoNoResidencial extends Proyecto{
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="superficieTerreno")
	private int superficieTerreno;
	
	@Column(name="superficieEdificio")
	private int superficieEdificio;
	
	@Column(name="finalidad")
	private String finalidad;

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

	public String getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(String finalidad) {
		this.finalidad = finalidad;
	}

	public ProyectoNoResidencial(User cliente, User empleado, Date fechaSolicitud, Date fechaInicioConstruccion,
			int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo, EstadosProyecto estado, String direccion,
			int superficieTerreno, int superficieEdificio, String finalidad) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo,
				estado);
		this.direccion = direccion;
		this.superficieTerreno = superficieTerreno;
		this.superficieEdificio = superficieEdificio;
		this.finalidad = finalidad;
		setTipo(TipoProyecto.NO_RESIDENCIAL);
	}

	public ProyectoNoResidencial() {
		super();
		setTipo(TipoProyecto.NO_RESIDENCIAL);
		// TODO Auto-generated constructor stub
	}

	public ProyectoNoResidencial(User cliente, User empleado, Date fechaSolicitud, Date fechaInicioConstruccion,
			int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo, EstadosProyecto estado) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo, estado);
		setTipo(TipoProyecto.NO_RESIDENCIAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProyectoNoResidencial [direccion=" + direccion + ", superficieTerreno=" + superficieTerreno
				+ ", superficieEdificio=" + superficieEdificio + ", finalidad=" + finalidad + "]";
	}
}
