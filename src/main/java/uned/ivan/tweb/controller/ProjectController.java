package uned.ivan.tweb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uned.ivan.tweb.DAO.PersistanceFacade;
import uned.ivan.tweb.DAO.ProyectoDAO;
import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.CertificadoEnergetico;
import uned.ivan.tweb.entity.CertificadoHabitabilidad;
import uned.ivan.tweb.entity.CertificadoInspeccionTecnica;
import uned.ivan.tweb.entity.EstadosProyecto;
import uned.ivan.tweb.entity.InformePericial;
import uned.ivan.tweb.entity.Proyecto;
import uned.ivan.tweb.entity.ProyectoNoResidencial;
import uned.ivan.tweb.entity.ProyectoRehabilitacion;
import uned.ivan.tweb.entity.ProyectoResidencial;
import uned.ivan.tweb.entity.TipoCertificado;
import uned.ivan.tweb.entity.TipoProyecto;
import uned.ivan.tweb.entity.User;
import uned.ivan.tweb.entity.UserSession;


@Controller
@RequestMapping("/proyectos")
public class ProjectController {
	
	@Autowired
	private PersistanceFacade  persistance;
	
	@Autowired
	private UserSession session;
	
	@GetMapping("/formularioSeleccionProyecto")
	public String formularioSeleccionTipoProyecto(Model elModelo) {
		return "formularioSeleccionProyecto";
	}
	
	@GetMapping("/formularioAgregarProyecto")
	public String formularioAgregarProyecto(@RequestParam("tipo") String tipo, Model elModelo) {
	    if (tipo!=null){
	    	TipoProyecto type = TipoProyecto.valueOf(tipo);
			switch(type) {
				case RESIDENCIAL:
					return "formularioProyectoResidencial";
				case NO_RESIDENCIAL:
					return "formularioProyectoNoResidencial";
				case REHABILITACION:
					return "formularioProyectoRehabilitacion";
				default:
					return "noImplementado";
			}
	    }else {
	    	return "noImplementado";
	    }
	}
	
	@PostMapping("/anadirProyecto")
	public String anadirProyecto(@ModelAttribute("proyecto") Proyecto proyecto,@ModelAttribute("tipo") String tipo,Model modelo) {
		System.out.println("Modelo controller" + modelo);
		System.out.println("Proyecto controller" + proyecto);
		persistance.añadirProyecto(proyecto,session.getUser());
		return "redirect:/usuarios/menu";	
	}
	
	@GetMapping("/asignarProyecto")
	public String asignarProyecto(@RequestParam("proyectoId") int id,Model elModelo ) {
		System.out.println("Llega al controlador " + id);
		Proyecto proyecto = persistance.getProject(id);
		persistance.asignarProyecto(proyecto,session.getUser());
		return "redirect:/usuarios/menu";	
	}
	
	@GetMapping("/verProyecto")
	public String verProyecto(@RequestParam("proyectoId") int id,@RequestParam("tipo") String tipo, Model elModelo ) {
		Proyecto proyecto = persistance.getProject(id);
		elModelo.addAttribute("proyecto", proyecto);
		
	    if (tipo!=null){
	    	TipoProyecto type = TipoProyecto.valueOf(tipo);
			switch(type) {
				case RESIDENCIAL:
					return "fichaProyectoResidencial";
				case NO_RESIDENCIAL:
					return "fichaProyectoNoResidencial";
				case REHABILITACION:
					return "fichaProyectoRehabilitacion";
				default:
					return "noImplementado";
			}
	    }else {
	    	return "noImplementado";
	    }
	}
	
	
	@ModelAttribute("proyecto")
	public Proyecto getItem(final HttpServletRequest request, Model modelo){
		String tipo = request.getParameter("tipo");
		Proyecto proyecto=null;
	    if (tipo!=null){
	    	TipoProyecto type = TipoProyecto.valueOf(tipo);
	    	switch(type) {
	    	case RESIDENCIAL:
	    		proyecto =  new ProyectoResidencial();
	    		break;
			case NO_RESIDENCIAL:
				proyecto = new ProyectoNoResidencial();
				break;
			case REHABILITACION:
				proyecto = new ProyectoRehabilitacion();
				break;
	    	}
	    }
	    return proyecto;
   
	}
	
	
	@ModelAttribute("tiposProyecto")
	public List<TipoProyecto> tiposProyecto(){
		return Arrays.asList(TipoProyecto.values());
	}

}