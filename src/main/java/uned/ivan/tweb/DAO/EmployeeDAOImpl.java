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

import uned.ivan.tweb.entity.Client;
import uned.ivan.tweb.entity.Employee;
import uned.ivan.tweb.entity.Roles;
import uned.ivan.tweb.tools.HibernateUtil;

@Component
public class EmployeeDAOImpl implements EmployeeDAO, InitializingBean, DisposableBean {
	
	@Autowired
	private HibernateUtil hibernateUtil;

	public EmployeeDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@Transactional
	public void saveOrUpdateEmployee(Employee employee) throws ConstraintViolationException {
		Session miSession = hibernateUtil.getSession();
		Transaction tx = miSession.beginTransaction();
		try {
			miSession.saveOrUpdate(employee);
			miSession.getTransaction().commit();
		}catch(ConstraintViolationException e) {
			tx.rollback();
			throw  e;
		}
		
	}

	@Override
	public Employee getEmployee(int Id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();
		Query<Employee> miQuery = miSession.createQuery("from Employee c where c.id = :id", Employee.class).setParameter("id", Id);
		Employee employee = miQuery.getSingleResult();
		miSession.getTransaction().commit();		
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();
		Query<Employee> miQuery = miSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = miQuery.getResultList();
		miSession.getTransaction().commit();		
		return employees;
	}

	@Override
	public void deleteEmployee(int Id) {
		Session miSession = hibernateUtil.getSession();
		miSession.beginTransaction();
		Query<Employee> miQuery = miSession.createQuery("delete from Employee where id = :id").setParameter("id", Id);
		miQuery.executeUpdate();
		miSession.getTransaction().commit();
	}
	
	@Override
	public Employee getEmployee(String user) {
		Session miSession = hibernateUtil.getSession();
		Employee employee;
		miSession.beginTransaction();
		Query<Employee> miQuery = miSession.createQuery("from Employee where usuario = :usuario");
		miQuery.setParameter("usuario", user);
		employee = miQuery.uniqueResult();
		miSession.getTransaction().commit();
		return employee;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Employee employee = new Employee("admin","admin",null,null,null,null,"admin@admin.es",null);
		employee.setRol(Roles.ADMINISTRADOR.toString());
		saveOrUpdateEmployee(employee);
	}

}
