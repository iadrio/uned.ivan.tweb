package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.CertificadoEnergetico;
import uned.ivan.tweb.entity.InformePericial;

@Component
@Qualifier("CertificadoDAOMediator")
public class CertificadoDAOMediator implements CertificadoDAO{
	
	@Autowired
	@Qualifier("CertificadoEnergeticoDAOImpl")
	private CertificadoDAO  certificadoEnergeticoDAO;
	
	@Autowired
	@Qualifier("InformePericialDAOImpl")
	private CertificadoDAO  informePericialDAODAO;

	@Override
	public void saveOrUpdate(Certificado proyecto) throws ConstraintViolationException {
		String valor = proyecto.getClass().getSimpleName();
		System.out.println("Mediador!!! " + valor +  "   " + (proyecto instanceof InformePericial));
		switch(valor) {
		case "CertificadoEnergetico":
			certificadoEnergeticoDAO.saveOrUpdate(proyecto);
			break;
		case "InformePericial":
			informePericialDAODAO.saveOrUpdate(proyecto);
			break;
		}
		
		
	}

	@Override
	public Certificado getCertificado(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certificado> getCertificados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assign() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
