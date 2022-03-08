package uned.ivan.tweb.AOP;

import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import uned.ivan.tweb.entity.Client;
import uned.ivan.tweb.entity.Employee;
import uned.ivan.tweb.entity.User;
import uned.ivan.tweb.entity.UserSession;

@Aspect
@Component
public class loginAOP {

	@Autowired
	private UserSession session;
	
	@Pointcut("execution(String uned.ivan.tweb.controller.UserController.*(..))")
	public void controladorUsuarios() {};
	
	@Pointcut("execution(String uned.ivan.tweb.controller.LoginController.returnMenu(..))")
	public void returnMenu() {};
	
	@Pointcut("execution(String uned.ivan.tweb.controller.UserController.formularioAgregarCliente(..))")
	public void formularioAgregarCliente() {};
	
	
	
	@Around("(controladorUsuarios() && !formularioAgregarCliente()) || returnMenu()")
	public String checkUserLogged(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {	
		//Permitimos que los clientes creen una cuenta sin tener iniciada una sesión
		Object[] argumentos = proceedingJoinPoint.getArgs();
		boolean newClient = false;
		for(Object o: argumentos) {
			if(o instanceof Client && ((Client) o).getId()==0) {
				newClient = true;
			}
		}
		
				
		if(session.getUsuario() == null&&!newClient) {
			return "accesoNoAutorizado";
		}else {
			return (String) proceedingJoinPoint.proceed();
		}
	}	
	

}
