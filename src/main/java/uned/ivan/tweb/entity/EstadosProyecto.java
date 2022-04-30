package uned.ivan.tweb.entity;

import java.util.List;

public enum EstadosProyecto {
	SOLICITADO("solicitado"),
	ASIGNADO("asignado"),
	PRESUPUESTADO("presupuestado"),
	EN_CURSO("en curso"),
	FINALIZADO("finalizado"),
	DESCARTADO("certificado habitabilidad rechazado"),
	CERTIFICADO_SOLICITADO("Inspeccion técnica solicitada"),
	CANCELADO("cancelado");
	
	private String name;
	
	EstadosProyecto(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString(){ 
		return name; 
	}
}
