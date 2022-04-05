package uned.ivan.tweb.controller;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

import uned.ivan.tweb.DAO.PersistanceFacade;
import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.CertificadoEnergetico;
import uned.ivan.tweb.entity.CertificadoHabitabilidad;
import uned.ivan.tweb.entity.CertificadoInspeccionTecnica;
import uned.ivan.tweb.entity.EstadosProyecto;
import uned.ivan.tweb.entity.InformePericial;
import uned.ivan.tweb.entity.Proyecto;
import uned.ivan.tweb.entity.TipoCertificado;
import uned.ivan.tweb.entity.UserSession;
import uned.ivan.tweb.entity.Vivienda;

@Controller
@RequestMapping("/certificados")
public class CertificateController {
		
	@Autowired
	private PersistanceFacade  persistance;
	
	@Autowired
	private UserSession session;
	
	@GetMapping("/formularioSeleccionCertificado")
	public String formularioSeleccionTipoCertificado(Model elModelo) {
		List<Vivienda> viviendas= persistance.getViviendas(session.getUser());
		elModelo.addAttribute("viviendas", viviendas);
		return "formularioSeleccionCertificado";
	}
	
	@GetMapping("/formularioAgregarCertificado")
	public String formularioAgregarCertificado(@RequestParam("tipo") String tipo,Model elModelo) {
		Certificado certificado;	
		Vivienda vivienda;
		vivienda = (Vivienda) elModelo.getAttribute("vivienda");
		certificado = (Certificado) elModelo.getAttribute("certificado");
		if(vivienda==null) {
			List<Vivienda> viviendas= persistance.getViviendas(session.getUser());
			elModelo.addAttribute("viviendas", viviendas);
			elModelo.addAttribute("error", "Debes seleccionar una vivienda. Si no tienes una registrada, debes registrar una primero.");
			return "formularioSeleccionCertificado";
		}else {
			anadirCertificado(certificado,vivienda);
		}
		return "redirect:/usuarios/menu";
	}
	
	@PostMapping("/anadirCertificado")
	public String anadirCertificado(@ModelAttribute("certificado") Certificado certificado,@ModelAttribute("vivienda") Vivienda vivienda) {
		persistance.añadirCertificado(certificado,session.getUser(),vivienda);
		return "redirect:/usuarios/menu";	
	}
	
	@ModelAttribute("certificado")
	public Certificado getItem(final HttpServletRequest request ){
		String tipo = request.getParameter("tipo");
		
	    if (tipo!=null){
	    	TipoCertificado type = TipoCertificado.valueOf(tipo);
	    	switch(type) {
	    	case CERTIFICADO_ENERGETICO:
				return new CertificadoEnergetico();
			case INFORME_PERICIAL:
				return new InformePericial();
			case HABITABILIDAD:
				return new CertificadoHabitabilidad();
			case INSPECCION_TECNICA:
				return new CertificadoInspeccionTecnica();
			default:
				return null;
	    	}
	    }
	    return null; 
	}
	
	@ModelAttribute("vivienda")
	public Vivienda getVivienda(final HttpServletRequest request ){
		String idVivienda = request.getParameter("idVivienda");
		
	    if (idVivienda!=null){
	    	int id = Integer.parseInt(idVivienda);
	    	return persistance.getVivienda(id);
	    }
	    return null; 
	}
	
	@ModelAttribute("tiposCertificado")
	public List<TipoCertificado> tiposCertificado(){
		return Arrays.asList(TipoCertificado.values());
	}
	
	@ModelAttribute("userSession")
	public UserSession sesion(){
		return session;
	}
	

}
