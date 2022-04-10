package uned.ivan.tweb.entity;

public enum EstadosCertificado {
	SOLICITADO("solicitado"),
	ASIGNADO("asignado"),
	PRESUPUESTADO("presupuestado"),
	PENDIENTE_VISITA("pendiente visita"),
	EN_CURSO("en curso"),
	FINALIZADO("finalizado"),
	CADUCADO("caducado"),
	CADUCADO_SIN_RENOVAR("caducado sin renovar"),
	CADUCADO_RENOVACION_SOLICITADA("caducado con renovación solicitada");
	
	private String name;
	
	EstadosCertificado(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString(){ 
		return name; 
	}
}
