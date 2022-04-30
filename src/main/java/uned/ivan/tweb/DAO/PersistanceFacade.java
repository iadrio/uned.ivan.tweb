package uned.ivan.tweb.DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.CertificadoEnergetico;
import uned.ivan.tweb.entity.CertificadoHabitabilidad;
import uned.ivan.tweb.entity.CertificadoInspeccionTecnica;
import uned.ivan.tweb.entity.EstadosCertificado;
import uned.ivan.tweb.entity.EstadosProyecto;
import uned.ivan.tweb.entity.Proyecto;
import uned.ivan.tweb.entity.TipoCertificado;
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
	
	public Certificado getCertificado(int id) {
		List<Certificado> certificados =  getCertificados();
		
		for(Certificado c: certificados) {
			if(c.getId() == id) {
				return c;
			}
		}
		
		return null;
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
	
	public List<Certificado> getCertificadosCaducados() {
		List<Certificado> certificados = getCertificados();
		List<Certificado> certificadosCaducados = new ArrayList<Certificado>();
		for(Certificado cert: certificados){
			if(cert.isExpirable()&&cert.getEstado().equals(EstadosCertificado.FINALIZADO)) {
				Date fechaCaducidad;
				TipoCertificado type = cert.getTipo();
				switch(type) {
				case HABITABILIDAD:
					fechaCaducidad = ((CertificadoHabitabilidad) cert).getFechaCaducidad();
					break;
				case INSPECCION_TECNICA:
					fechaCaducidad = ((CertificadoInspeccionTecnica) cert).getFechaCaducidad();
					break;
				default:
					fechaCaducidad = new Date();
					break;
				}
				if(fechaCaducidad!=null&&fechaCaducidad.before(new Date())) {
					System.out.println(fechaCaducidad + " es anterior a " + new Date());
					certificadosCaducados.add(cert);
				}
			}
		}
		return certificadosCaducados;
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
		proyecto.setCliente(user);
		Vivienda vivienda;
		try {
			vivienda = getVivienda(Integer.parseInt(proyecto.getDireccion()));
			if(vivienda==null){
				vivienda = proyecto.getVivienda();
			}
		}catch(NumberFormatException e) {
			vivienda = proyecto.getVivienda();
		}
		
		if(vivienda!=null) {
			proyecto.setVivienda(vivienda);
			vivienda.setCliente(user);
			vivienda.agregarProyecto(proyecto);
		}
		user.agregarProyecto(proyecto);
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
	
	public List<Proyecto> getProyectosCandidadosInspeccionTecnica(){
		List<Proyecto> proyectos = proyectoDAOImpl.getProjects();
		List<Proyecto> proyectosCandidatos = new ArrayList<Proyecto>();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE,-16425);
		
		for(Proyecto proyecto: proyectoDAOImpl.getProjects()) {
			if(proyecto.getFechaFin()!=null&&c.getTime().after(proyecto.getFechaFin())&&proyecto.getEstado().equals(EstadosProyecto.FINALIZADO)) {
				proyectosCandidatos.add(proyecto);
			}
		}
		return proyectosCandidatos;
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
	
	public List<Proyecto> statusFilter(List<Proyecto> proyectos, List<EstadosProyecto> estados){
		List<Proyecto> filteredProjects = new ArrayList();
		for(Proyecto p: proyectos) {
			if(estados.contains(p.getEstado())){
				filteredProjects.add(p);
			}
		}
		return filteredProjects;
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
			if(viviendaDAOImpl.getViviendas()!=null) {
				int idCliente = user.getId();
				for(Vivienda vivienda: viviendaDAOImpl.getViviendas()) {
					if(vivienda.getCliente().getId()==idCliente) {
						viviendas.add(vivienda);
					}
				}
			}
			return viviendas;
		}else {
			return null;
		}
	}

}
