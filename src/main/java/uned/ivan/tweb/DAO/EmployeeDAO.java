package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import uned.ivan.tweb.entity.Employee;

public interface EmployeeDAO {
	public void saveOrUpdateEmployee(Employee employee) throws ConstraintViolationException;
	public Employee getEmployee(int Id);
	public List<Employee> getEmployees();
	public void deleteEmployee(int Id);
	public Employee getEmployee(String user);
}
