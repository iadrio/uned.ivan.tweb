package uned.ivan.tweb.entity;

public enum EstadosCertificado {
	SOLICITADO("solicitado"),
	ASIGNADO("asignado"),
	PRESUPUESTADO("presupuestado"),
	VISITA_REALIZADA("visita realizada"),
	FINALIZADO("finalizado"),
	CADUCADO_SIN_RENOVAR("caducado sin renovar"),
	CADUCADO_RENOVACION_SOLICITADA("caducado con renovación solicitada"),
	CANCELADO("cancelado");
	
	private String name;
	
	EstadosCertificado(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString(){ 
		return name; 
	}
}
