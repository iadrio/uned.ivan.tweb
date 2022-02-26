package uned.ivan.tweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
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

	
	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		List<Employee> empleados=employeeDAO.getEmployees();
		elModelo.addAttribute("empleados", empleados);
		UserSession userSession = (UserSession) elModelo.getAttribute("userSession");
		List<Client> clients=clientDAO.getClients();
		elModelo.addAttribute("clientes", clients);
		return "lista-usuarios";
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
			return "redirect:/login/formularioLogin";
		}catch(ConstraintViolationException e) {
			return "actualizarUsuarioKo";
		}
		
	}
	
	@GetMapping("/eliminarCliente")
	public String eliminarCliente(@RequestParam("clienteId") int id, Model elModelo ) {
		if(checkSession(elModelo)){
			clientDAO.deleteClient(id);
			return "redirect:/usuarios/lista";
		}else {
			return "accesoNoAutorizado";
		}
	}
	
	@RequestMapping("/formularioAgregarEmpleado")
	public String formularioAgregarEmpleado(Model elModelo) {
		Employee employee = new Employee();
		
		elModelo.addAttribute("empleado", employee);
		return "formularioEmpleado";
		
	}
	
	@GetMapping("/formularioActualizarEmpleado")
	public String formularioActualizarEmpleado(@RequestParam("clienteId") int id, Model elModelo ) {
		Employee employee = employeeDAO.getEmployee(id);
		
		elModelo.addAttribute("empleado", employee);
		
		return "formularioEmpleado";
	}
	
	@PostMapping("/actualizarEmpleado")
	public String actualizarEmpleado(@ModelAttribute("empleado") Employee empleado) {
		try {
			employeeDAO.saveOrUpdateEmployee(empleado);
			return "redirect:/usuarios/lista";
		}catch(ConstraintViolationException e) {
			return "actualizarUsuarioKo";
		}
	}
	
	@GetMapping("/eliminarEmpleado")
	public String eliminarEmpleado(@RequestParam("clienteId") int id, Model elModelo ) {
		employeeDAO.deleteEmployee(id);
		return "redirect:/usuarios/lista";
	}
	
	@ModelAttribute("roles")
	   public List<String> getRoles() {
	      List<String> roles = new ArrayList<String>();
	      for(Roles r: Roles.values()) {
	    	  roles.add(r.toString());
	      }
	      return roles;
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

