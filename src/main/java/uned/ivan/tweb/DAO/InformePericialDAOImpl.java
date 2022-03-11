package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.tools.HibernateUtil;

@Component
@Qualifier("InformePericialDAOImpl")
public class InformePericialDAOImpl implements CertificadoDAO {
	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Override
	public void saveOrUpdate(Certificado certificado) throws ConstraintViolationException {
		System.out.println("pericial!!!");
		System.out.println(certificado);
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
