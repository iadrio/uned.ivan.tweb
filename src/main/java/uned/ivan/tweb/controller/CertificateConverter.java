package uned.ivan.tweb.controller;


import org.springframework.core.convert.converter.Converter;

import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.CertificadoEnergetico;
import uned.ivan.tweb.entity.InformePericial;


public class CertificateConverter implements Converter <Certificado,Certificado> {


	@Override
	public Certificado convert(Certificado cert) {
	    Certificado certificado = null;
	    String tipo = cert.getTipo();
	    switch (tipo) {
	        case "certificado energetico":
	        	certificado = new CertificadoEnergetico ();
	            break;
	        case "informe pericial":
	        	certificado = new InformePericial ();
	            break;
	        default:
	            throw new IllegalArgumentException (
	                    "Unknown person type:" + tipo);
	    }
	    return certificado;
	}

	
	
	
}
