package uned.ivan.tweb.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import uned.ivan.tweb.DAO.*;
import uned.ivan.tweb.entity.*;

@Controller
@RequestMapping("/usuarios")
public class UserController {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Autowired
	@Qualifier("proyecto")
	private ProyectoDAO proyectoDAO;

	@Autowired
	private UserSession session;
	
	@RequestMapping("/lista")
	public String lista(Model elModelo){
		List<Employee> empleados=employeeDAO.getEmployees();
		elModelo.addAttribute("empleados", empleados);
		List<Client> clients=clientDAO.getClients();
		elModelo.addAttribute("clientes", clients);
		elModelo.addAttribute("userSession",session);
		return "lista-usuarios";
	}
	
	@RequestMapping("/listaClientes")
	public String listaClientes(Model elModelo){
		List<Client> clients=clientDAO.getClients();
		elModelo.addAttribute("clientes", clients);
		elModelo.addAttribute("userSession",session);
		return "listaClientes";
	}
	
	@RequestMapping("/listaEmpleados")
	public String listaEmpleados(Model elModelo){
		List<Employee> empleados=employeeDAO.getEmployees();
		elModelo.addAttribute("empleados", empleados);
		elModelo.addAttribute("userSession",session);
		return "listaEmpleados";
	}
	
	@RequestMapping("/menuCliente")
	public String menuCliente(Model elModelo){
		List<Proyecto> proyecto=proyectoDAO.getProjects();
		elModelo.addAttribute("proyectos", proyecto);
		elModelo.addAttribute("userSession",session);
		if(proyecto != null) {
			for(Proyecto p: proyecto) {
				System.out.println("proyectos");
				System.out.println(p);
			}
		}
		return "menuCliente";
	}
	
	@RequestMapping("/menuAdministrador")
	public String menuAdministrador(Model elModelo){
		List<Employee> empleados=employeeDAO.getEmployees();
		elModelo.addAttribute("empleados", empleados);
		List<Client> clients=clientDAO.getClients();
		elModelo.addAttribute("clientes", clients);
		elModelo.addAttribute("userSession",session);
		System.out.println(session);
		return "menuAdministrador";
	}
	
	@RequestMapping("/formularioAgregarCliente")
	public String formularioAgregarCliente(Model elModelo) {
		Client elCliente = new Client();
		
		elModelo.addAttribute("cliente", elCliente);
		return "formularioCliente";
		
	}
	
	@GetMapping("/formularioActualizarCliente")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int id, Model elModelo ) {
		Client cliente = clientDAO.getClient(id);
		elModelo.addAttribute("cliente", cliente);
		
		return "formularioCliente";
	}
	
	@PostMapping("/actualizarCliente")
	public String actualizarCliente(@ModelAttribute("cliente") Client elCliente) {
		try {
			clientDAO.saveOrUpdateClient(elCliente);
			return "redirect:/login/returnMenu";
		}catch(ConstraintViolationException e) {
			return "actualizarUsuarioKo";
		}
	}
	
	@GetMapping("/eliminarCliente")
	public String eliminarCliente(@RequestParam("clienteId") int id, Model elModelo ) {
			clientDAO.deleteClient(id);
			return "redirect:/login/returnMenu";
	}
	
	@RequestMapping("/formularioAgregarEmpleado")
	public String formularioAgregarEmpleado(Model elModelo) {
		Employee employee = new Employee();
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
		Employee employee = employeeDAO.getEmployee(id);
		List<String> roles = new ArrayList<String>();
	    for(Roles r: Roles.values()) {
	    	roles.add(r.toString());
	    }
	    elModelo.addAttribute("roles", roles);
		elModelo.addAttribute("empleado", employee);
		
		return "formularioEmpleado";
	}
	
	@PostMapping("/actualizarEmpleado")
	public String actualizarEmpleado(@ModelAttribute("empleado") Employee empleado) {
		try {
			employeeDAO.saveOrUpdateEmployee(empleado);
			return "redirect:/login/returnMenu";
		}catch(ConstraintViolationException e) {
			return "actualizarUsuarioKo";
		}
	}
	
	@GetMapping("/eliminarEmpleado")
	public String eliminarEmpleado(@RequestParam("clienteId") int id, Model elModelo ) {
		employeeDAO.deleteEmployee(id);
		return "redirect:/usuarios/lista";
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

