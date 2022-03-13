package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CertificadoHabitabilidad extends Certificado{
	@Column(name="fechaVisita")
	private Date fechaVisita;
	
	@Column(name="fechaEmision")
	private Date fechaEmision;
	
	@Column(name="fechaCaducidad")
	private Date fechaCaducidad;

	public Date getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public CertificadoHabitabilidad(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, String estado, String otrosDatos, Date fechaVisita,
			Date fechaEmision, Date fechaCaducidad) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		this.fechaVisita = fechaVisita;
		this.fechaEmision = fechaEmision;
		this.fechaCaducidad = fechaCaducidad;
		setTipo(TipoCertificado.HABITABILIDAD);
	}

	public CertificadoHabitabilidad() {
		super();
		setTipo(TipoCertificado.HABITABILIDAD);
		// TODO Auto-generated constructor stub
	}

	public CertificadoHabitabilidad(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, String estado, String otrosDatos) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		setTipo(TipoCertificado.HABITABILIDAD);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CertificadoHabitabilidad [fechaVisita=" + fechaVisita + ", fechaEmision=" + fechaEmision
				+ ", fechaCaducidad=" + fechaCaducidad + "]";
	}
	
	

}
