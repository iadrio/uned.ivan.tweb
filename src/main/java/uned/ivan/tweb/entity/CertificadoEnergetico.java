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



	public CertificadoEnergetico() {
		super();
		setTipo(TipoCertificado.CERTIFICADO_ENERGETICO);
		// TODO Auto-generated constructor stub
	}

	public CertificadoEnergetico(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, EstadosCertificado estado, String otrosDatos) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		setTipo(TipoCertificado.CERTIFICADO_ENERGETICO);
		// TODO Auto-generated constructor stub
	}

	public CertificadoEnergetico(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, EstadosCertificado estado, String otrosDatos, String categoria) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		this.categoria = categoria;
		setTipo(TipoCertificado.CERTIFICADO_ENERGETICO);
	}

	@Override
	public String toString() {
		return "CertificadoEnergetico [categoria=" + categoria + "]";
	}
	
	
	
	
}
