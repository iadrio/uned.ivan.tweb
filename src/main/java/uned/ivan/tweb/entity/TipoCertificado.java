package uned.ivan.tweb.entity;

public enum TipoCertificado {
	CERTIFICADO_ENERGETICO("Certificado energético"),
	INFORME_PERICIAL("Informe Pericial"),
	HABITABILIDAD("Habitabilidad"),
	INSPECCION_TECNICA("Inspeccion Tecnica");
	
	
	private String name;
	
	TipoCertificado(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString(){ 
		return name; 
	}
}
