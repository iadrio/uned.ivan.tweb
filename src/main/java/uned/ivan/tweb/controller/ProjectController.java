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
import uned.ivan.tweb.entity.Roles;

@Controller
@RequestMapping("/proyectos")
public class ProjectController {
	
	@Autowired
	@Qualifier("proyecto")
	private ProyectoDAO  proyectoDAO;
	
	@Autowired 
	private BeanFactory beans;
	
	@GetMapping("/formularioSeleccionProyecto")
	public String formularioSeleccionTipoProyecto(Model elModelo) {
		
		return "formularioSeleccionProyecto";
		
	}
	
	@GetMapping("/formularioAgregarProyecto")
	public String formularioAgregarProyecto(@RequestParam("tipo") String tipo, Model elModelo) {
		Proyecto proyecto  = new Proyecto();
		elModelo.addAttribute("proyecto", proyecto);
		switch(tipo) {
			case "residencial":
				return "formularioProyectoResidencial";
			case "noResidencial":
				return "formularioProyectoNoResidencial";
			case "rehabilitacion":
				return "formularioProyectoRehabilitacion";
			default:
				return "noImplementado";
		}
	}
	
	@PostMapping("/anadirProyecto")
	public String anadirProyectoResidencial(@ModelAttribute("proyecto") Proyecto proyecto,@ModelAttribute("tipo") String tipo) {
		ProyectoDAO dao = proyectoDAO;
		
		proyecto.setFechaSolicitud(new Date());
		proyecto.setEstado(EstadosProyecto.SOLICITADO.toString());
		System.out.println("En el controller " +  proyecto);
		dao.saveOrUpdateProject(proyecto);
		return "redirect:/login/returnMenu";	
	}
	
	@GetMapping("/verProyecto")
	public String eliminarEmpleado(@RequestParam("proyectoId") int id,@RequestParam("tipo") String tipo, Model elModelo ) {
		ProyectoDAO dao = proyectoDAO;
		Proyecto proyecto = dao.getProject(id);
		elModelo.addAttribute("proyecto", proyecto);
		switch(tipo) {
			case "residencial":
				return "fichaProyectoResidencial";
			case "noResidencial":
				return "fichaProyectoNoResidencial";
			case "rehabilitacion":
				return "fichaProyectoRehabilitacion";
			default:
				return "noImplementado";
		}
	}

}