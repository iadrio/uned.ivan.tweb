package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class ProyectoRehabilitacion extends Proyecto{
	@Column(name="superficieReforma")
	private int superficieReforma;

	@NotNull
	@Min(value = 1,message = "La superficie a reformar debe ser mayor que 0")
	public int getSuperficieReforma() {
		return superficieReforma;
	}

	public void setSuperficieReforma(int superficieReforma) {
		this.superficieReforma = superficieReforma;
	}
	

	public ProyectoRehabilitacion(User cliente, User empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo,
			EstadosProyecto estado, int superficieReforma) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo,
				estado);
		this.superficieReforma = superficieReforma;
		setTipo(TipoProyecto.REHABILITACION);
	}
	
	

	public ProyectoRehabilitacion(User cliente, User empleado, Date fechaSolicitud,
			Date fechaInicioConstruccion, int duracionPrevista, Date fechaFin, float coste, TipoProyecto tipo,
			EstadosProyecto estado) {
		super(cliente, empleado, fechaSolicitud, fechaInicioConstruccion, duracionPrevista, fechaFin, coste, tipo, estado);
		setTipo(TipoProyecto.REHABILITACION);
		// TODO Auto-generated constructor stub
	}
	
	public ProyectoRehabilitacion(int superficieReforma) {
		super();
		setTipo(TipoProyecto.REHABILITACION);
		this.superficieReforma = superficieReforma;
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
