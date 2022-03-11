package uned.ivan.tweb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
	private UsersDAO userDAO;
	
	@Autowired
	@Qualifier("proyecto")
	private ProyectoDAO proyectoDAO;

	@Autowired
	private UserSession session;
	
	@RequestMapping("/listaClientes")
	public String listaClientes(Model elModelo){
		elModelo.addAttribute("clientes", getClientes());
		elModelo.addAttribute("userSession",session);
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
		List<Proyecto> proyecto=proyectoDAO.getProjects();
		List<User> empleados= getEmpleados();
		List<User> clients= getClientes();
		elModelo.addAttribute("proyectos", proyecto);
		elModelo.addAttribute("userSession",session);
		elModelo.addAttribute("empleados", empleados);
		elModelo.addAttribute("clientes", clients);
		
		if(session.getUser() == null) {
			return "redirect:/login/formularioLogin";
		}
		
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
		User cliente = userDAO.getUser(id);
		elModelo.addAttribute("cliente", cliente);
		return "formularioCliente";
	}
	

	@RequestMapping("/formularioAgregarEmpleado")
	public String formularioAgregarEmpleado(Model elModelo) {
		User employee = new User();
		List<String> roles = new ArrayList<String>();
	    for(Roles r: Roles.values()) {
	    	roles.add(r.toString());
	    }
	    elModelo.addAttribute("roles", roles);
		elModelo.addAttribute("empleado", employee);
		return "formularioEmpleado";
		
	}
	
	@GetMapping("/formularioActualizarEmpleado")
	public String formularioActualizarEmpleado(@RequestParam("clienteId") int id, Model elModelo ) {
		User employee = userDAO.getUser(id);
		List<String> roles = new ArrayList<String>();
	    for(Roles r: Roles.values()) {
	    	roles.add(r.toString());
	    }
	    elModelo.addAttribute("roles", roles);
		elModelo.addAttribute("empleado", employee);
		
		return "formularioEmpleado";
	}
	
	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@ModelAttribute("usuario") User usuario) {
		try {
			userDAO.saveOrUpdateUser(usuario);
			return "redirect:/usuarios/menu";
		}catch(ConstraintViolationException e) {
			return "actualizarUsuarioKo";
		}
	}
	
	@GetMapping("/eliminarUsuario")
	public String eliminarCliente(@RequestParam("userId") int id, Model elModelo ) {
			userDAO.deleteUser(id);
			return "redirect:/usuarios/menu";
	}

	public List<User> getUsers(){
		List<User> users =userDAO.getUsers();
		return users;
	}
	
	public List<User> getUsers(List<String> roles){
		List<User> users=userDAO.getUsers();
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

	  @RequestMapping(value = "/viewPDF", method = RequestMethod.POST)
	  public ModelAndView viewPDF() throws Exception{
	    List<User> users = getClientes();
	    return new ModelAndView("viewPDF", "Users", users);
	  }
	


}

