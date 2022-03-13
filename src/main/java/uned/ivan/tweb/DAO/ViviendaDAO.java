package uned.ivan.tweb.DAO;

import java.util.List;

import javax.validation.ConstraintViolationException;

import uned.ivan.tweb.entity.Vivienda;

public interface ViviendaDAO {
	public void saveOrUpdate(Vivienda vivienda) throws ConstraintViolationException;
	public Vivienda getVivienda(int id);
	public List<Vivienda> getViviendas();
}
