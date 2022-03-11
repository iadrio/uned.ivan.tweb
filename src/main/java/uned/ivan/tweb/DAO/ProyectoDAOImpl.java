package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import uned.ivan.tweb.entity.Proyecto;
import uned.ivan.tweb.tools.HibernateUtil;

@Component
@Qualifier("proyecto")
public class ProyectoDAOImpl implements ProyectoDAO {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public void saveOrUpdateProject(Proyecto proyecto) throws ConstraintViolationException {
		Session miSession = hibernateUtil.getSession();
		Transaction tx = miSession.beginTransaction();
		try {
			miSession.saveOrUpdate(proyecto);
			miSession.getTransaction().commit();	
		}catch(ConstraintViolationException e) {
			tx.rollback();
			throw  e;
		}

	}

	@Override
	public Proyecto getProject(int id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Proyecto> miQuery = miSession.createQuery("from Proyecto c where c.id = :id", Proyecto.class).setParameter("id", id);
		Proyecto proyecto = miQuery.getSingleResult();
		miSession.getTransaction().commit();		
		return proyecto;
	}

	@Override
	public List<Proyecto> getProjects() {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Proyecto> miQuery = miSession.createQuery("from Proyecto", Proyecto.class);
		List<Proyecto> proyectos = miQuery.getResultList();
		miSession.getTransaction().commit();		
		return proyectos;
	}

	@Override
	public void assignProject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliverProject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startConstruction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishConstruction() {
		// TODO Auto-generated method stub

	}

}
