package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProyectoRehabilitacion extends Proyecto{
	@Column(name="superficieReforma")
	private int superficieReforma;

	@Column(name="direccion")
	private String direccion;
	
	public int getSuperficieReforma() {
		return superficieReforma;
	}

	public void setSuperficieReforma(int superficieReforma) {
		this.superficieReforma = superficieReforma;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ProyectoRehabilitacion(User cliente, User empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo,
			EstadosProyecto estado, int superficieReforma, String direccion) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo,
				estado);
		this.superficieReforma = superficieReforma;
		this.direccion = direccion;
		setTipo(TipoProyecto.REHABILITACION);
	}
	
	

	public ProyectoRehabilitacion(User cliente, User empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo,
			EstadosProyecto estado) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo, estado);
		setTipo(TipoProyecto.REHABILITACION);
		// TODO Auto-generated constructor stub
	}
	
	public ProyectoRehabilitacion(int superficieReforma, String direccion) {
		super();
		setTipo(TipoProyecto.REHABILITACION);
		this.superficieReforma = superficieReforma;
		this.direccion = direccion;
		// TODO Auto-generated constructor stub
	}

	public ProyectoRehabilitacion() {
		super();
		setTipo(TipoProyecto.REHABILITACION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "ProyectoRehabilitacion [superficieReforma=" + superficieReforma + "]";
	}
	
	
}
