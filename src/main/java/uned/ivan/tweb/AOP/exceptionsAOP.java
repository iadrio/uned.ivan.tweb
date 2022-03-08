package uned.ivan.tweb.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uned.ivan.tweb.entity.UserSession;

@Aspect
@Component
public class exceptionsAOP {
	
	@Pointcut("execution(String uned.ivan.tweb.*.*.*(..))")
	public void todos() {};
	
	
	@Around("todos()")
	public String catchExceptions(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		try {
			return (String) proceedingJoinPoint.proceed();
		}catch(Exception exception) {
			exception.printStackTrace();
			return "error";
		}
	}

}
