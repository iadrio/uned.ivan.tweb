package uned.ivan.tweb.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uned.ivan.tweb.DAO.UsersDAO;
import uned.ivan.tweb.entity.User;
import uned.ivan.tweb.entity.UserSession;
import uned.ivan.tweb.tools.HibernateUtil;


@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UsersDAO userDao;
	
	@Autowired
	private UserSession session;
	
	@Autowired
	private HibernateUtil hibernateUtil;
	
	@RequestMapping("/formularioLogin")
	public String formularioLogin(Model elModelo) {
		session.setEmpleado(true);
		elModelo.addAttribute("userSession", session);
		return "formularioLogin";
	}
	
	@RequestMapping("/cerrarSession")
	public String cerrarSession(Model elModelo) {
		session.reset();
	//	hibernateUtil.getSession().close();
		return "redirect:formularioLogin";
	}
	
	@PostMapping("/checkLogin")
	public String checkLogin(@ModelAttribute("userSession") UserSession userSession,Model elModelo) {

		
		User employee = userDao.getUser(userSession.getUsuario());
		if(employee!=null&&employee.getContraseña().equals(userSession.getContraseña())){
			userSession.setRol(employee.getRol());
			session.setUsuario(userSession.getUsuario());
			session.setContraseña(userSession.getContraseña());
			session.setRol(userSession.getRol());
			session.setEmpleado(userSession.isEmpleado());
			session.setUser(employee);
			
			elModelo.addAttribute("userSession", userSession);
			return "redirect:/usuarios/menu";
		}

		
		return "loginKo";

	}
		
}
