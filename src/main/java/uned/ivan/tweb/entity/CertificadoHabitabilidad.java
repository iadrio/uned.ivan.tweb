package uned.ivan.tweb.entity;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CertificadoHabitabilidad extends Certificado{
	@Column(name="fechaVisita")
	private Date fechaVisita;
	
	@Column(name="fechaCaducidad")
	private Date fechaCaducidad;
	
	private int diasVigencia = 5475; //15 años

	public Date getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public CertificadoHabitabilidad(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, EstadosCertificado estado, String otrosDatos, Date fechaVisita, Date fechaCaducidad) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		this.fechaVisita = fechaVisita;
		this.fechaCaducidad = fechaCaducidad;
		setTipo(TipoCertificado.HABITABILIDAD);
	}

	public CertificadoHabitabilidad() {
		super();
		setTipo(TipoCertificado.HABITABILIDAD);
		// TODO Auto-generated constructor stub
	}

	public CertificadoHabitabilidad(int id, TipoCertificado tipo, Date fechaSolicitud, Date fechaEntrega, User cliente,
			User arquitecto, float precio, Vivienda vivienda, EstadosCertificado estado, String otrosDatos) {
		super(id, tipo, fechaSolicitud, fechaEntrega, cliente, arquitecto, precio, vivienda, estado, otrosDatos);
		setTipo(TipoCertificado.HABITABILIDAD);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CertificadoHabitabilidad [fechaVisita=" + fechaVisita + ", fechaCaducidad=" + fechaCaducidad + "]";
	}
	
	@Override
	public  boolean esFinalizable() {
		List<EstadosCertificado> estadosPermitidos = Arrays.asList(EstadosCertificado.VISITA_REALIZADA);
		if(estadosPermitidos.contains(this.getEstado())) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean esVisitable() {
		List<EstadosCertificado> estadosPermitidos = Arrays.asList(EstadosCertificado.PRESUPUESTADO);
		if(estadosPermitidos.contains(this.getEstado())) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void finalizar() throws Exception{
		Calendar c = Calendar.getInstance();
		super.finalizar();
		c.setTime(getFechaEntrega());
		c.add(Calendar.DATE,diasVigencia);
		setFechaCaducidad(c.getTime());
	}
	
	@Override
	public void visitar() throws Exception{
		super.visitar();
		setFechaVisita(new Date());
	}
	
	public  boolean isExpirable() {
		return true;
	}
}
