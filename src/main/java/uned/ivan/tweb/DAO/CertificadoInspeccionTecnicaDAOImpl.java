package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import uned.ivan.tweb.entity.Certificado;

@Component
@Qualifier("CertificadoInspeccionTecnicaDAOImpl")
public class CertificadoInspeccionTecnicaDAOImpl extends CertificadoDAOImpl implements CertificadoDAO {


	@Override
	public Certificado getCertificado(int id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Certificado> miQuery = miSession.createQuery("from CertificadoInspeccionTecnica c where c.id = :id", Certificado.class).setParameter("id", id);
		Certificado certificado = miQuery.getSingleResult();
		miSession.getTransaction().commit();		
		return certificado;
	}

	@Override
	public List<Certificado> getCertificados() {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Certificado> miQuery = miSession.createQuery("from CertificadoInspeccionTecnica", Certificado.class);
		List<Certificado> certificados = miQuery.getResultList();
		miSession.getTransaction().commit();		
		return certificados;
	}

	@Override
	public String toString() {
		return "CertificadoInspeccionTecnicaDAOImpl [hibernateUtil=" + hibernateUtil + "]";
	}
	
	

}
