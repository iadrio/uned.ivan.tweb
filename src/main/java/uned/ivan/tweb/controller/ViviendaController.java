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
	public String anadirVivienda(@RequestParam("direccion") String direccion) {
		Vivienda vivienda = new Vivienda();
		vivienda.setDireccion(direccion);
		persistance.añadirVivienda(vivienda,session.getUser());
		return "redirect:/usuarios/menu";	
	}
	
	@ModelAttribute("userSession")
	public UserSession sesion(){
		return session;
	}
	
}
