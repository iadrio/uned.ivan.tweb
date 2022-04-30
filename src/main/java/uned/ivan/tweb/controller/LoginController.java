package uned.ivan.tweb.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.swing.text.Document;

import org.apache.commons.io.IOUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
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
	
	@GetMapping(value="/verEnunciado",produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody byte[] verEnunciado() throws IOException {
		String pdf = "enunciado.pdf"; 
	    Resource resource = new ClassPathResource(pdf);
	    InputStream s = resource.getInputStream();
	    return IOUtils.toByteArray(s);
	    
	}
	
	@GetMapping(value="/verMemoria",produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody byte[] verMemoria() throws IOException {
		String pdf = "memoria.pdf"; 
	    Resource resource = new ClassPathResource(pdf);
	    InputStream s = resource.getInputStream();
	    return IOUtils.toByteArray(s);
	    
	}
	
	@GetMapping(value="/verManual",produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody byte[] verReadme() throws IOException {
		String pdf = "manual.pdf"; 
	    Resource resource = new ClassPathResource(pdf);
	    InputStream s = resource.getInputStream();
	    return IOUtils.toByteArray(s);
	    
	}
	
	@RequestMapping("/cerrarSession")
	public String cerrarSession(Model elModelo) {
		session.reset();
	//	hibernateUtil.getSession().close();
		return "redirect:formularioLogin";
	}
	
	@PostMapping("/checkLogin")
	public String checkLogin(@ModelAttribute("userSession") UserSession userSession,Model elModelo) {
		System.out.println(elModelo);
		System.out.println(userSession);
		User employee = userDao.getUser(userSession.getUsuario());
		if(employee!=null&&employee.getContrasena().equals(userSession.getContrasena())){
			userSession.setRol(employee.getRol());
			session.setUsuario(userSession.getUsuario());
			session.setContrasena(userSession.getContrasena());
			session.setRol(userSession.getRol());
			session.setEmpleado(userSession.isEmpleado());
			session.setUser(employee);
			
			elModelo.addAttribute("userSession", userSession);
			System.out.println(elModelo);
			return "redirect:/usuarios/menu";
		}else {
			elModelo.addAttribute("error", "Login incorrecto. Inténtalo de nuevo.");
			System.out.println(elModelo);
			return "formularioLogin";
		}
	}
		
}
