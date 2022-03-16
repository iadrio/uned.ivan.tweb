package uned.ivan.tweb.entity;

public enum TipoProyecto {
	RESIDENCIAL("Residencial"),
	NO_RESIDENCIAL("No residencial"),
	REHABILITACION("Rehabilitacion");
	
	private String name;
	
	TipoProyecto(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString(){ 
		return name; 
	}
}
