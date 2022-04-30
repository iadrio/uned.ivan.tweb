package uned.ivan.tweb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import uned.ivan.tweb.DAO.*;
import uned.ivan.tweb.entity.*;

@Controller
@RequestMapping("/usuarios")
public class UserController  {
	
	@Autowired
	private PersistanceFacade  persistance;

	@Autowired
	private UserSession session;
	
	@RequestMapping("/listaClientes")
	public String listaClientes(Model elModelo){
		elModelo.addAttribute("clientes", getClientes());
		return "listaClientes";
	}
	
	@RequestMapping("/listaEmpleados")
	public String listaEmpleados(Model elModelo){
		elModelo.addAttribute("empleados", getEmpleados());
		elModelo.addAttribute("userSession",session);
		return "listaEmpleados";
	}
	
	@RequestMapping("/menu")
	public String menu(Model elModelo){
		User user = session.getUser();
		if(session.getUser() == null) {
			return "redirect:/login/formularioLogin";
		}
		elModelo.addAttribute("certificadosCaducados", persistance.getCertificadosCaducados());
		elModelo.addAttribute("proyectos", persistance.getProyectos(user));
		elModelo.addAttribute("certificados", persistance.getCertificados(user));
		elModelo.addAttribute("userSession",session);
		elModelo.addAttribute("empleados", getEmpleados());
		elModelo.addAttribute("clientes", getClientes());
		elModelo.addAttribute("viviendas", persistance.getViviendas(user));
		elModelo.addAttribute("proyectosAsignados", user.getProyectos());
		elModelo.addAttribute("proyectosTodos", persistance.getProjects());
		elModelo.addAttribute("certificadosAsignados", user.getCertificados());
		elModelo.addAttribute("certificadosTodos", persistance.getCertificados());
		elModelo.addAttribute("proyectosCaducados", persistance.getProyectosCandidadosInspeccionTecnica());
		
		
		switch(session.getRol()) {
			case "ADMINISTRADOR":
				return "menuAdministrador";
			case "ARQUITECTO":
				return "menuArquitecto";
			case "CLIENTE":
				return "menuCliente";
			default:
				return "redirect:/login/formularioLogin";
		}
	}

	@RequestMapping("/formularioAgregarCliente")
	public String formularioAgregarCliente(Model elModelo) {
		User user = new User();
		user.setRol("CLIENTE");
		elModelo.addAttribute("cliente", user);
		return "formularioCliente";
	}
	
	
	@GetMapping("/formularioActualizarCliente")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int id, Model elModelo ) {
		User cliente = persistance.getUser(id);
		elModelo.addAttribute("cliente", cliente);
		return "formularioCliente";
	}
	
	@GetMapping("/verUsuario")
	public String verUsuario(@RequestParam("usuarioId") int id, Model elModelo ) {
		User usuario = persistance.getUser(id);
		elModelo.addAttribute("usuario", usuario);
		return "fichaUsuario";
	}
	

	@RequestMapping("/formularioAgregarUsuario")
	public String formularioAgregarUsuario(Model elModelo) {
		User usuario = new User();
		List<String> roles = new ArrayList<String>();
	    for(Roles r: Roles.values()) {
	    	if(!r.equals(Roles.CLIENTE)) {
	    		roles.add(r.toString());
	    	}
	    }
	    elModelo.addAttribute("roles", roles);
		elModelo.addAttribute("usuario", usuario);
		return "formularioUsuario";
		
	}
	
	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@Valid @ModelAttribute("usuario") User usuario,BindingResult bind,Model modelo) {
		Boolean hasErrors = false;
		String errores = "Errores: ";
		System.out.println(usuario);
		try {
			Long.parseLong(usuario.getTelefono());
		}catch(Exception e) {
			hasErrors=true;
			errores = errores + "El télefono debe ser un número";
		}
		if(usuario.getId()==0&&persistance.getUser(usuario.getUsuario())!=null) {
			hasErrors = true;
			errores = errores + "El usuario ya existe";
		}

		if(bind.hasErrors()||hasErrors){
			for(ObjectError error:bind.getAllErrors()) {
				errores = errores  + error.getDefaultMessage() + ",  ";
			}
			modelo.addAttribute("error",errores);
			
			if(usuario.getRol().equals(Roles.CLIENTE.toString())) {
				User cliente;
				if(usuario.getId()!=0) {
					cliente = persistance.getUser(usuario.getId());
				}else {
					cliente = new User();
					cliente.setRol("CLIENTE");
				}
				modelo.addAttribute("cliente", cliente);
				return "formularioCliente";
			}else {
				return formularioAgregarUsuario(modelo);
			}
		}else {
			try {
				persistance.saveOrUpdateUser(usuario);
				
				return "redirect:/usuarios/menu";
			}catch(ConstraintViolationException e) {
				return "actualizarUsuarioKo";
			}
		}
	}
	
	@GetMapping("/eliminarUsuario")
	public String eliminarCliente(@RequestParam("userId") int id, Model elModelo ) {
			persistance.deleteUser(id);
			return "redirect:/usuarios/menu";
	}
	


	  
	  @ModelAttribute("userSession")
		public UserSession sesion(){
			return session;
		}
	  
	public List<User> getUsers(){
		List<User> users =persistance.getUsers();
		return users;
	}
	
	public List<User> getUsers(List<String> roles){
		List<User> users=persistance.getUsers();
		List<User> filteredUsers = new ArrayList<User>();
		for(User u: users){
			if(roles.contains(u.getRol())) {
				filteredUsers.add(u);
			}
		}
		return filteredUsers;
	}
	
	public List<User> getEmpleados(){
		List<String> roles = Arrays.asList("ARQUITECTO","ADMINISTRADOR");
		return getUsers(roles);
	}
	
	public List<User> getClientes(){
		List<String> roles = Arrays.asList("CLIENTE");
		return getUsers(roles);
	}
	
	public boolean checkSession(Model elModelo) {
		UserSession userSession = (UserSession) elModelo.getAttribute("userSession");
		if(userSession != null) {
			return true;
		}else {
			return false;
		}
	}


	


}

