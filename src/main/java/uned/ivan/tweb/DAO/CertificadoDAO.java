package uned.ivan.tweb.DAO;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import uned.ivan.tweb.entity.Certificado;


public interface CertificadoDAO {
	public void saveOrUpdate(Certificado proyecto) throws ConstraintViolationException;
	public Certificado getCertificado(int id);
	public List<Certificado> getCertificados();
	public void assign();
}

