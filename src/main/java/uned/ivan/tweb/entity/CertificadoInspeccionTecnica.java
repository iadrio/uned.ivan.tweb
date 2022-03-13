package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CertificadoInspeccionTecnica extends Certificado{
	@Column(name="fechaCaducidad")
	private Date fechaCaducidad;

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public CertificadoInspeccionTecnica(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, String estado, String otrosDatos, Date fechaCaducidad) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		this.fechaCaducidad = fechaCaducidad;
		setTipo(TipoCertificado.INSPECCION_TECNICA);
	}

	public CertificadoInspeccionTecnica() {
		super();
		setTipo(TipoCertificado.INSPECCION_TECNICA);
		// TODO Auto-generated constructor stub
	}

	public CertificadoInspeccionTecnica(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, String estado, String otrosDatos) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		setTipo(TipoCertificado.INSPECCION_TECNICA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CertificadoInspeccionTecnica [fechaCaducidad=" + fechaCaducidad + "]";
	}
	
	
}
