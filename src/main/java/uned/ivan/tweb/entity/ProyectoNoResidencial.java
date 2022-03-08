package uned.ivan.tweb.entity;

import java.util.Date;

public class ProyectoNoResidencial extends Proyecto {
	private int superficieTerreno;
	private int superficieEdificio;
	private String finalidad;
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
	
	
	
	public ProyectoNoResidencial(int id, Client cliente, Employee empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, String direccion,
			String tipo, String estado) {
		super(id, cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, direccion,
				tipo, estado);
		// TODO Auto-generated constructor stub
	}
	public ProyectoNoResidencial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProyectoNoResidencial(int id, Client cliente, Employee empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, String direccion,
			String tipo, String estado, int superficieTerreno, int superficieEdificio, String finalidad) {
		super(id, cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste,
				direccion, tipo, estado);
		this.superficieTerreno = superficieTerreno;
		this.superficieEdificio = superficieEdificio;
		this.finalidad = finalidad;
	}

	
	
	
}
