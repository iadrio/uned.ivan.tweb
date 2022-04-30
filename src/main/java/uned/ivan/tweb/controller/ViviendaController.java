package uned.ivan.tweb.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import uned.ivan.tweb.DAO.PersistanceFacade;
import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.User;
import uned.ivan.tweb.entity.UserSession;
import uned.ivan.tweb.entity.Vivienda;

@Controller
@RequestMapping("/viviendas")
public class ViviendaController {
	
	@Autowired
	private PersistanceFacade  persistance;
	
	@Autowired
	private UserSession session;
	
	@GetMapping("/formularioAgregarVivienda")
	public String formularioAgregarVivienda(Model elModelo) {
		Vivienda vivienda = new Vivienda();	
		elModelo.addAttribute("vivienda", vivienda);
		return "formularioVivienda";
	}
	
	@GetMapping("/anadirVivienda")
	public RedirectView anadirVivienda(@RequestParam("direccion") String direccion,RedirectAttributes redir) {
		Vivienda vivienda = new Vivienda();
		RedirectView redirectView= new RedirectView("/usuarios/menu",true);
	   
		if(direccion.trim().equals("")) {
			redir.addFlashAttribute("error","La dirección no puede ir en blanco");
		}else {
			vivienda.setDireccion(direccion);
			persistance.añadirVivienda(vivienda,session.getUser());
		}
		return redirectView;
	}
	
	@GetMapping("/verVivienda")
	public String verVivienda(@RequestParam("viviendaId") int id,Model elModelo) {
		Vivienda vivienda = persistance.getVivienda(id);
		elModelo.addAttribute("vivienda", vivienda);
		return "fichaVivienda";
	}
	
	@ModelAttribute("userSession")
	public UserSession sesion(){
		return session;
	}
}
