package uned.ivan.tweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uned.ivan.tweb.DAO.EmployeeDAO;
import uned.ivan.tweb.DAO.ProyectoDAO;
import uned.ivan.tweb.entity.Client;
import uned.ivan.tweb.entity.Employee;
import uned.ivan.tweb.entity.EstadosProyecto;
import uned.ivan.tweb.entity.Proyecto;
import uned.ivan.tweb.entity.ProyectoNoResidencial;
import uned.ivan.tweb.entity.ProyectoRehabilitacion;
import uned.ivan.tweb.entity.ProyectoResidencial;
import uned.ivan.tweb.entity.Roles;

@Controller
@RequestMapping("/proyectos")
public class ProjectController {
	
	@Autowired
	@Qualifier("proyecto")
	private ProyectoDAO  ProyectoDAO;
	
	@Autowired 
	private BeanFactory beans;
	
	@GetMapping("/formularioSeleccionProyecto")
	public String formularioSeleccionTipoProyecto(Model elModelo) {
		
		return "formularioSeleccionProyecto";
		
	}
	
	@GetMapping("/formularioAgregarProyecto")
	public String formularioAgregarProyecto(@RequestParam("tipo") String tipo, Model elModelo) {
		Proyecto proyecto;	
		switch(tipo) {
			case "residencial":
				proyecto = new ProyectoResidencial();
				elModelo.addAttribute("proyecto", proyecto);
				return "formularioProyectoResidencial";
			case "noResidencial":
				proyecto = new ProyectoNoResidencial();
				System.out.println(proyecto.getClass().getSimpleName());
				elModelo.addAttribute("proyecto", (ProyectoNoResidencial) proyecto);
				return "formularioProyectoNoResidencial";
			case "rehabilitacion":
				proyecto = new ProyectoRehabilitacion();
				System.out.println(proyecto.getClass().getSimpleName());
				elModelo.addAttribute("proyecto", (ProyectoRehabilitacion) proyecto);
				return "formularioProyectoRehabilitacion";
			default:
				return "noImplementado";
		}
	}
	
	@PostMapping("/anadirProyecto")
	public String anadirProyectoResidencial(@ModelAttribute("proyecto") Proyecto proyecto,@ModelAttribute("tipo") String tipo) {
		ProyectoDAO dao;

		switch(tipo) {
			
			case "residencial":
				dao=(uned.ivan.tweb.DAO.ProyectoDAO) beans.getBean("proyectoResidencialDAOImpl");
				break;
			case "rehabilitacion":
				dao=(uned.ivan.tweb.DAO.ProyectoDAO) beans.getBean("proyectoRehabilitacionDAOImpl");
				break;
			case "no residencial":
				dao=(uned.ivan.tweb.DAO.ProyectoDAO) beans.getBean("proyectoNoResidencialDAOImpl");
				break;
			default:
				dao = ProyectoDAO;
				break;
		}
		
		proyecto.setFechaSolicitud(new Date());
		proyecto.setEstado(EstadosProyecto.SOLICITADO.toString());
		dao.saveOrUpdateProject(proyecto);
		return "redirect:/login/returnMenu";	
	}
}
