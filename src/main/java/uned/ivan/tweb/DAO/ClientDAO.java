package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import uned.ivan.tweb.entity.Client;

public interface ClientDAO {
	public void saveOrUpdateClient(Client cliente) throws ConstraintViolationException;;
	public Client getClient(int Id);
	public List<Client> getClients();
	public void deleteClient(int Id);
	public Client getClient(String user);
}
