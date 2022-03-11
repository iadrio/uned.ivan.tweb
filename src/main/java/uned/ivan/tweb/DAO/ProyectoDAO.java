package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import uned.ivan.tweb.entity.User;
import uned.ivan.tweb.entity.Proyecto;



public interface ProyectoDAO {
	public void saveOrUpdateProject(Proyecto proyecto) throws ConstraintViolationException;
	public Proyecto getProject(int id);
	public List<Proyecto> getProjects();
	public void assignProject();
	public void deliverProject();
	public void startConstruction();
	public void finishConstruction();
}
