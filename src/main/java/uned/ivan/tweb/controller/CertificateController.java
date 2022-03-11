package uned.ivan.tweb.controller;

import java.beans.PropertyEditor;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uned.ivan.tweb.DAO.CertificadoDAO;
import uned.ivan.tweb.DAO.ProyectoDAO;
import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.CertificadoEnergetico;
import uned.ivan.tweb.entity.EstadosProyecto;
import uned.ivan.tweb.entity.InformePericial;
import uned.ivan.tweb.entity.Proyecto;

@Controller
@RequestMapping("/certificados")
public class CertificateController {
	
	@Autowired
	ConversionService conversionService;
	
	@Autowired
	@Qualifier("CertificadoDAOMediator")
	private CertificadoDAO  certificadoDAO;
	
	@GetMapping("/formularioSeleccionCertificado")
	public String formularioSeleccionTipoCertificado(Model elModelo) {
		return "formularioSeleccionCertificado";
	}
	
	@GetMapping("/formularioAgregarCertificado")
	public String formularioAgregarCertificado(@RequestParam("tipo") String tipo, Model elModelo) {
		Certificado certificado;
		switch(tipo) {
			case "certificado energetico":
				certificado  = new CertificadoEnergetico();
				elModelo.addAttribute("certificado", certificado);
				return "formularioCertificadoEnergetico";
			case "informe pericial":
				certificado  = new InformePericial();
				elModelo.addAttribute("certificado", certificado);
				return "formularioInformePericial";
			default:
				return "noImplementado";
		}
	}
	
	@PostMapping("/anadirCertificado")
	public String anadirCertificado(@ModelAttribute("certificado") Certificado certificado) {
		certificado.setFechaSolicitud(new Date());
		certificadoDAO.saveOrUpdate(certificado);
		return "redirect:/usuarios/menu";	
	}
	
	@ModelAttribute("certificado")
	public Certificado getItem(final HttpServletRequest request){
	    String type = request.getParameter("tipo");
	    System.out.println(type);
	    if (type!=null){
	        if (type.equals("informe pericial")){
	            return new InformePericial();
	        }
	        if (type.equals("certificado energetico")){
	            return new CertificadoEnergetico();
	        }
	        throw new RuntimeException("OH NOES! Type unknown!");
	    }
	    return null; 
	}

}
