package uned.ivan.tweb.entity;

public enum EstadosProyecto {
	SOLICITADO("solicitado"),
	ASIGNADO("asignado"),
	PRESUPUESTADO("presupuestado"),
	EN_CURSO("en curso"),
	FINALIZADO("finalizado");
	
	private String name;
	
	EstadosProyecto(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString(){ 
		return name; 
	}
}
