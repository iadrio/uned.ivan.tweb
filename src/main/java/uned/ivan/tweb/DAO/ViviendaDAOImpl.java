package uned.ivan.tweb.DAO;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.Vivienda;
import uned.ivan.tweb.tools.HibernateUtil;

@Component
public class ViviendaDAOImpl implements ViviendaDAO{
	@Autowired
	protected HibernateUtil hibernateUtil;

	@Override
	public void saveOrUpdate(Vivienda vivienda) throws ConstraintViolationException {
		Session miSession = hibernateUtil.getSession();
		Transaction tx = miSession.beginTransaction();
		try {
			miSession.saveOrUpdate(vivienda);
			miSession.getTransaction().commit();	
		}catch(ConstraintViolationException e) {
			tx.rollback();
			throw  e;
		}
		
	}

	@Override
	public Vivienda getVivienda(int id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Vivienda> miQuery = miSession.createQuery("from Vivienda c where c.id = :id", Vivienda.class).setParameter("id", id);
		Vivienda vivienda = miQuery.getSingleResult();
		miSession.getTransaction().commit();		
		return vivienda;
	}

	@Override
	public List<Vivienda> getViviendas() {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Vivienda> miQuery = miSession.createQuery("from Vivienda", Vivienda.class);
		List<Vivienda> viviendas = miQuery.getResultList();
		miSession.getTransaction().commit();		
		return viviendas;
	}

}
