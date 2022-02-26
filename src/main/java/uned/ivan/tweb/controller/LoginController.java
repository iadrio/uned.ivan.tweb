package uned.ivan.tweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uned.ivan.tweb.DAO.ClientDAO;
import uned.ivan.tweb.DAO.EmployeeDAO;
import uned.ivan.tweb.entity.Client;
import uned.ivan.tweb.entity.Employee;
import uned.ivan.tweb.entity.UserSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping("/formularioLogin")
	public String formularioLogin(Model elModelo) {
		UserSession userSession = new UserSession();
		userSession.setEmpleado(true);
		elModelo.addAttribute("userSession", userSession);

		return "formularioLogin";
	}
	
	@PostMapping("/checkLogin")
	public String checkLogin(@ModelAttribute("userSession") UserSession userSession,Model elModelo) {

		
		if(userSession.isEmpleado()) {
			Employee employee = employeeDAO.getEmployee(userSession.getUsuario());
			if(employee!=null&&employee.getContraseña().equals(userSession.getContraseña())){
				userSession.setRol(employee.getRol());
				elModelo.addAttribute("userSession", userSession);
				return "loginOk";
			}
		}else {
			Client client = clientDAO.getClient(userSession.getUsuario());
			if(client!=null&&client.getContraseña().equals(userSession.getContraseña())){
				elModelo.addAttribute("userSession", userSession);
				return "loginOk";
			}
		}
		
		return "loginKo";

	}
	
	
	@PostMapping("/returnMenu")
	public String returnMenu(@ModelAttribute("userSession") UserSession userSession, final RedirectAttributes redirectAttrs) {

		redirectAttrs.addFlashAttribute("userSession",userSession);

		return "redirect:/usuarios/lista";

	}

}
