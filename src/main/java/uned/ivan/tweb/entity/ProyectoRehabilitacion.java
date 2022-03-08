package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ProyectoRehabilitacion")
public class ProyectoRehabilitacion extends Proyecto{
	
	@Column(name="superficieReforma")
	private int superficieReforma;



	public ProyectoRehabilitacion(int id, Client cliente, Employee empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, String direccion,
			String tipo, String estado, int superficieReforma) {
		super(id, cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste,
				direccion, tipo, estado);
		this.superficieReforma = superficieReforma;
	}


	public ProyectoRehabilitacion() {
		super();
		
	}


	public ProyectoRehabilitacion(int id, Client cliente, Employee empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, String direccion,
			String tipo, String estado) {
		super(id, cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, direccion,
				tipo, estado);
		// TODO Auto-generated constructor stub
	}


	public int getSuperficieReforma() {
		return superficieReforma;
	}

	public void setSuperficieReforma(int superficieReforma) {
		this.superficieReforma = superficieReforma;
	}

	@Override
	public String toString() {
		return "ProyectoRehabilitacion [superficieReforma=" + superficieReforma + "]";
	}
	
	
	
	
}
