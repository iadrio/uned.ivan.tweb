package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import uned.ivan.tweb.entity.User;

public interface UsersDAO {
	public void saveOrUpdateUser(User user) throws ConstraintViolationException;
	public User getUser(int Id);
	public List<User> getUsers();
	public void deleteUser(int Id);
	public User getUser(String user);
}
