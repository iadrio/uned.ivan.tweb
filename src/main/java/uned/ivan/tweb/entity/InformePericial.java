package uned.ivan.tweb.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class InformePericial extends Certificado{

	public InformePericial() {
		super();
		setTipo(TipoCertificado.INFORME_PERICIAL);
		// TODO Auto-generated constructor stub
	}

	public InformePericial(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, EstadosCertificado estado, String otrosDatos) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		setTipo(TipoCertificado.INFORME_PERICIAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
