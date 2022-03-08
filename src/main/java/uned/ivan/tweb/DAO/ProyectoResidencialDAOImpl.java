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
import uned.ivan.tweb.entity.ProyectoResidencial;
import uned.ivan.tweb.tools.HibernateUtil;

@Component
@Qualifier("residencial")
public class ProyectoResidencialDAOImpl  implements ProyectoDAO {
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
		System.out.println("añadiendo proyecto residencial");
	}

	@Override
	public Proyecto getProject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> getProjects() {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Proyecto> miQuery = miSession.createQuery("from ProyectoResidencial", Proyecto.class);
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
