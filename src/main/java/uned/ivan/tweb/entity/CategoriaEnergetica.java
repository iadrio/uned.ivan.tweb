package uned.ivan.tweb.entity;

public enum CategoriaEnergetica {
	A("Clase A"),
	B("Clase B"),
	C("Clase C"),
	D("Clase D"),
	E("Clase E"),
	F("Clase F"),
	G("Clase G");
	
	private String name;
	
	CategoriaEnergetica(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString(){ 
		return name; 
	}
}
