package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import uned.ivan.tweb.entity.User;
import uned.ivan.tweb.entity.Roles;
import uned.ivan.tweb.tools.HibernateUtil;

@Component
public class UsersDAOImpl implements UsersDAO, InitializingBean, DisposableBean {
	
	@Autowired
	private HibernateUtil hibernateUtil;

	public UsersDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@Transactional
	public void saveOrUpdateUser(User user) throws ConstraintViolationException {
		Session miSession = hibernateUtil.getSession();
		Transaction tx = miSession.beginTransaction();
		try {
			miSession.merge(user);
			miSession.getTransaction().commit();
		}catch(ConstraintViolationException e) {
			tx.rollback();
			throw  e;
		}
		
	}

	@Override
	public User getUser(int Id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();
		Query<User> miQuery = miSession.createQuery("from User c where c.id = :id", User.class).setParameter("id", Id);
		User user = miQuery.getSingleResult();
		miSession.getTransaction().commit();		
		return user;
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();
		Query<User> miQuery = miSession.createQuery("from User", User.class);
		List<User> users = miQuery.getResultList();
		miSession.getTransaction().commit();		
		return users;
	}

	@Override
	public void deleteUser(int Id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();
		Query<User> miQuery = miSession.createQuery("delete from User where id = :id").setParameter("id", Id);
		miQuery.executeUpdate();
		miSession.getTransaction().commit();
	}
	
	@Override
	public User getUser(String usuario) {
		Session miSession = hibernateUtil.getSession();
		User user;
		miSession.beginTransaction();
		Query<User> miQuery = miSession.createQuery("from User where usuario = :usuario");
		miQuery.setParameter("usuario", usuario);
		user = miQuery.uniqueResult();
		miSession.getTransaction().commit();
		return user;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		User employee = new User("admin","admin","administrador","chuli",null,"660633998","admin@admin.es",null, null);
		employee.setRol(Roles.ADMINISTRADOR.toString());
		User customer = new User("user","user","usuario","chuli",null,"661632666","user@user.es",null, null);
		customer.setRol(Roles.CLIENTE.toString());
		User arquitecto = new User("arquitecto","arquitecto","arquitecto","arquitecto","arquitecto","666666666","arquitecto@arquitecto.es",null, null);
		arquitecto.setRol(Roles.ARQUITECTO.toString());
		saveOrUpdateUser(employee);
		saveOrUpdateUser(customer);
		saveOrUpdateUser(arquitecto);
	}

}
