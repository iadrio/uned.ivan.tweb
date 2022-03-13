package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.Proyecto;
import uned.ivan.tweb.tools.HibernateUtil;

@Component
@Qualifier("CertificadoDAOImpl")
public abstract class CertificadoDAOImpl implements CertificadoDAO {
	@Autowired
	protected HibernateUtil hibernateUtil;
	
	@Override
	public void saveOrUpdate(Certificado certificado) throws ConstraintViolationException {
		Session miSession = hibernateUtil.getSession();
		Transaction tx = miSession.beginTransaction();
		try {
			miSession.saveOrUpdate(certificado);
			miSession.getTransaction().commit();	
		}catch(ConstraintViolationException e) {
			tx.rollback();
			throw  e;
		}
	}


}
