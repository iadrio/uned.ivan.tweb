package uned.ivan.tweb.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.EstadosProyecto;
import uned.ivan.tweb.entity.Proyecto;
import uned.ivan.tweb.entity.User;
import uned.ivan.tweb.entity.Vivienda;

@Component
public class PersistanceFacade {
	
	@Autowired
	@Qualifier("CertificadoEnergeticoDAOImpl")
	private CertificadoDAO  certificadoEnergeticoDAOImpl;
	
	@Autowired
	@Qualifier("CertificadoInformePericialDAOImpl")
	private CertificadoDAO  certificadoInformePericialDAOImpl;
	
	@Autowired
	@Qualifier("CertificadoHabitabilidadDAOImpl")
	private CertificadoDAO  certificadoHabitabilidadDAOImpl;
	
	@Autowired
	@Qualifier("CertificadoInspeccionTecnicaDAOImpl")
	private CertificadoDAO  certificadoInspeccionTecnicaDAOImpl;
	
	@Autowired
	private ProyectoDAO proyectoDAOImpl;
	
	@Autowired
	private UsersDAO userDAOImpl;
	
	@Autowired
	private ViviendaDAOImpl viviendaDAOImpl;
	
	//Operaciones con certificados
	public void saveOrUpdateCertificado(Certificado certificado) throws ConstraintViolationException {
		certificadoEnergeticoDAOImpl.saveOrUpdate(certificado);
	}
	
	public List<Certificado> getCertificadosEnergeticos() {
		List<Certificado> certificados = certificadoEnergeticoDAOImpl.getCertificados();
		if(certificados != null) {
			return certificados;
		}else {
			return new ArrayList<Certificado>();
		}
	}
	
	public List<Certificado> getInformesPericiales() {
		List<Certificado> certificados = certificadoInformePericialDAOImpl.getCertificados();
		if(certificados != null) {
			return certificados;
		}else {
			return new ArrayList<Certificado>();
		}
	}
	
	public List<Certificado> getCertificadosHabitabilidad() {
		List<Certificado> certificados = certificadoHabitabilidadDAOImpl.getCertificados();
		if(certificados != null) {
			return certificados;
		}else {
			return new ArrayList<Certificado>();
		}
	}
	
	public List<Certificado> getCertificadosInspeccionTecnica() {
		List<Certificado> certificados = certificadoInspeccionTecnicaDAOImpl.getCertificados();
		if(certificados != null) {
			return certificados;
		}else {
			return new ArrayList<Certificado>();
		}
	}
	
	public List<Certificado> getCertificados() {
		List<Certificado> certificados = new ArrayList<Certificado>();
		certificados.addAll(getCertificadosEnergeticos());
		certificados.addAll(getInformesPericiales());
		certificados.addAll(getCertificadosHabitabilidad());
		certificados.addAll(getCertificadosInspeccionTecnica());
		return certificados;
	}
	
	public void añadirCertificado(Certificado certificado,User user,Vivienda vivienda) {
		certificado.setFechaSolicitud(new Date());
		user.agregarCertificado(certificado);
		vivienda.agregarCertificado(certificado);
		certificado.setCliente(user);
		certificado.setVivienda(vivienda);
		saveOrUpdateCertificado(certificado);
	}
	
	public List<Certificado> getCertificados(User user){
		if(user!=null) {
			List<Certificado> certificados =  new ArrayList<Certificado>();
			int idCliente = user.getId();
			for(Certificado certificado: getCertificados()) {
				if(certificado.getCliente().getId()==idCliente) {
					certificados.add(certificado);
				}
			}
			return certificados;
		}else {
			return null;
		}
	}
	
	
	//Operaciones con proyectos
	public void añadirProyecto(Proyecto proyecto,User user) {
		proyecto.setFechaSolicitud(new Date());
		proyecto.setEstado(EstadosProyecto.SOLICITADO.toString());	
		user.agregarProyecto(proyecto);
		proyecto.setCliente(user);
		saveOrUpdateProject(proyecto);
	}
	
	public void asignarProyecto(Proyecto proyecto,User user) {
		proyecto.setEstado(EstadosProyecto.ASIGNADO.toString());	
		user.agregarProyecto(proyecto);
		proyecto.setEmpleado(user);
		saveOrUpdateProject(proyecto);
	}
	
	public List<Proyecto> getProyectos(User user){
		if(user!=null) {
			List<Proyecto> proyectos =  new ArrayList<Proyecto>();
			int idCliente = user.getId();
			for(Proyecto proyecto: proyectoDAOImpl.getProjects()) {
				if(proyecto.getCliente().getId()==idCliente) {
					proyectos.add(proyecto);
				}
			}
			return proyectos;
		}else {
			return new ArrayList<Proyecto>();
		}
	}
	
	public List<Proyecto> getProyectosAsignados(User user){
		if(user!=null) {
			List<Proyecto> proyectos =  new ArrayList<Proyecto>();
			int idEmpleado = user.getId();
			for(Proyecto proyecto: proyectoDAOImpl.getProjects()) {
				if(proyecto.getEmpleado()!=null&&proyecto.getEmpleado().getId()==idEmpleado) {
					proyectos.add(proyecto);
				}
			}
			return proyectos;
		}else {
			return new ArrayList<Proyecto>();
		}
	}
	
	public List<Proyecto> getProyectosSinAsignar(){
		List<Proyecto> proyectos =  new ArrayList<Proyecto>();
		for(Proyecto proyecto: proyectoDAOImpl.getProjects()) {
			if(proyecto.getEmpleado()==null) {
				proyectos.add(proyecto);
			}
		}
		return proyectos;
	}
	
	public void saveOrUpdateProject(Proyecto proyecto) throws ConstraintViolationException {
		proyectoDAOImpl.saveOrUpdate(proyecto);
	}
	
	public Proyecto getProject(int id) {
		return proyectoDAOImpl.getProject(id);
	}
	
	public List<Proyecto> getProjects() {
		List<Proyecto> proyectos = proyectoDAOImpl.getProjects();
		if(proyectos == null) {
			return new ArrayList<Proyecto>();
		}else {
			return proyectos;
		}
	}
	
	//Operaciones con usuarios

	public void saveOrUpdateUser(User user) throws ConstraintViolationException {
		userDAOImpl.saveOrUpdateUser(user);
	}

	public User getUser(int Id) {
		return userDAOImpl.getUser(Id);
	}


	public List<User> getUsers() {
		return userDAOImpl.getUsers();
	}


	public void deleteUser(int Id) {
		userDAOImpl.deleteUser(Id);
	}
	

	public User getUser(String usuario) {
		return userDAOImpl.getUser(usuario);
	}
	
	//Operaciones con viviendas
	public void añadirVivienda(Vivienda vivienda,User user) {
		user.agregarVivienda(vivienda);
		vivienda.setCliente(user);
		saveOrUpdateVivienda(vivienda);
	}
	
	public void saveOrUpdateVivienda(Vivienda vivienda) throws ConstraintViolationException {
		viviendaDAOImpl.saveOrUpdate(vivienda);
	}
	
	public Vivienda getVivienda(int Id) {
		return viviendaDAOImpl.getVivienda(Id);
	}
	
	public List<Vivienda> getViviendas(){
		List<Vivienda> viviendas = viviendaDAOImpl.getViviendas();
		if(viviendas != null) {
			return viviendas;
		}else {
			return new ArrayList<Vivienda>();
		}
	}
	
	public List<Vivienda> getViviendas(User user){
		if(user!=null) {
			List<Vivienda> viviendas =  new ArrayList<Vivienda>();
			int idCliente = user.getId();
			for(Vivienda vivienda: viviendaDAOImpl.getViviendas()) {
				if(vivienda.getCliente().getId()==idCliente) {
					viviendas.add(vivienda);
				}
			}
			return viviendas;
		}else {
			return null;
		}
	}

}
