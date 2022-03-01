package uned.ivan.tweb.tools;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {

	SessionFactory miFactory;
	Session session;
	
    public HibernateUtil() {
		miFactory = new Configuration().configure("hibernate.cfg.xml").addPackage("uned.ivan.tweb.entity").buildSessionFactory();

	}
    
    public Session getSession(){
    	//if(session==null) {
    		session =  miFactory.openSession();
    		session.clear();
    	//}else {
    //		session =  miFactory.getCurrentSession();
    //	}
    	
    	return session;
    }
    
    public SessionFactory getSessionFactory() {
    	return miFactory;
    }
    
}