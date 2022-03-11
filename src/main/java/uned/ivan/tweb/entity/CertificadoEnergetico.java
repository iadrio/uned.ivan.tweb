package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CertificadoEnergetico extends Certificado {
	@Column(name="categoria")
	private String categoria;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public CertificadoEnergetico(int id, String tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, String otrosDatos, String categoria) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, otrosDatos);
		this.categoria = categoria;
	}

	public CertificadoEnergetico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CertificadoEnergetico(int id, String tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, String otrosDatos) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, otrosDatos);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "CertificadoEnergetico [categoria=" + categoria + "]";
	}
	
	
	
	
}
