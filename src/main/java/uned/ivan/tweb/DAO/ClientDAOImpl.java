package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import uned.ivan.tweb.tools.HibernateUtil;
import uned.ivan.tweb.entity.Client;
import uned.ivan.tweb.entity.Employee;
import uned.ivan.tweb.entity.Roles;

@Component
public class ClientDAOImpl implements ClientDAO, InitializingBean, DisposableBean {
	
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	@Transactional
	public void saveOrUpdateClient(Client cliente) throws ConstraintViolationException {
		Session miSession = hibernateUtil.getSession();
		Transaction tx = miSession.beginTransaction();
		try {
			miSession.saveOrUpdate(cliente);
			miSession.getTransaction().commit();	
		}catch(ConstraintViolationException e) {
			tx.rollback();
			throw  e;
		}
	}

	@Override
	public Client getClient(int Id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Client> miQuery = miSession.createQuery("from Client c where c.id = :id", Client.class).setParameter("id", Id);
		Client cliente = miQuery.getSingleResult();
		miSession.getTransaction().commit();		
		return cliente;
	}
	
	@Override
	@Transactional
	public List<Client> getClients() {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();		
		Query<Client> miQuery = miSession.createQuery("from Client", Client.class);
		List<Client> clientes = miQuery.getResultList();
		miSession.getTransaction().commit();		
		return clientes;
	}
	

	@Override
	public void deleteClient(int Id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();
		Query<Client> miQuery = miSession.createQuery("delete from Client where id = :id").setParameter("id", Id);
		
		miQuery.executeUpdate();

		miSession.getTransaction().commit();

	}
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public Client getClient(String user) {
		Session miSession = hibernateUtil.getSession();
		Client client;
		miSession.beginTransaction();
		Query<Client> miQuery = miSession.createQuery("from Client where usuario = :usuario");
		miQuery.setParameter("usuario", user);
		client = miQuery.uniqueResult();
		miSession.getTransaction().commit();
		return client;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Client cliente = new Client("user","user",null,null,null,null,"user@user.es",null);
		saveOrUpdateClient(cliente);
		
	}


}
