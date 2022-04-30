package uned.ivan.tweb.controller;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import uned.ivan.tweb.DAO.PersistanceFacade;
import uned.ivan.tweb.entity.CategoriaEnergetica;
import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.CertificadoEnergetico;
import uned.ivan.tweb.entity.CertificadoHabitabilidad;
import uned.ivan.tweb.entity.CertificadoInspeccionTecnica;
import uned.ivan.tweb.entity.EstadosCertificado;
import uned.ivan.tweb.entity.EstadosProyecto;
import uned.ivan.tweb.entity.InformePericial;
import uned.ivan.tweb.entity.Proyecto;
import uned.ivan.tweb.entity.TipoCertificado;
import uned.ivan.tweb.entity.User;
import uned.ivan.tweb.entity.UserSession;
import uned.ivan.tweb.entity.Vivienda;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

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
	
	@GetMapping("/verCertificado")
	public String verCertificado(@RequestParam("certificadoId") int id,@RequestParam("tipo") String tipo,Model elModelo) {
		Certificado certificado = persistance.getCertificado(id);
		elModelo.addAttribute("certificado", certificado);
		return "fichaCertificado";
	}
	
	@GetMapping("/asignarCertificado")
	public String asignarProyecto(@RequestParam("certificadoId") int id,Model elModelo ) {
		try {
			Certificado certificado = persistance.getCertificado(id);
			certificado.asignar(session.getUser());
			persistance.saveOrUpdateCertificado(certificado);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/usuarios/menu";	
	}
	
	@GetMapping("/solicitarInspeccionTecnica")
	public String solicitarCertificadoHabitabilidad(@RequestParam("proyectoId") int id) {
		Certificado cert = new CertificadoInspeccionTecnica();
		Proyecto proyecto = persistance.getProject(id);
		Vivienda vivienda = proyecto.getVivienda();
		cert.setEstado(EstadosCertificado.SOLICITADO);
		proyecto.setEstado(EstadosProyecto.CERTIFICADO_SOLICITADO);
		persistance.añadirCertificado(cert,vivienda.getCliente(),vivienda);
		persistance.saveOrUpdateProject(proyecto);
		return "redirect:/usuarios/menu";
	}
	
	@PostMapping("/anadirCertificado")
	public String anadirCertificado(@ModelAttribute("certificado") Certificado certificado,@ModelAttribute("vivienda") Vivienda vivienda) {
		certificado.setEstado(EstadosCertificado.SOLICITADO);
		persistance.añadirCertificado(certificado,session.getUser(),vivienda);
		return "redirect:/usuarios/menu";	
	}
	
	@GetMapping("/formularioPresupuestar")
	public String presupuestar(@RequestParam("certificadoId") int id,Model elModelo ) {
		Certificado certificado = persistance.getCertificado(id);
		elModelo.addAttribute("certificado", certificado);
		return "formularioPresupuestar";	
	}
	
	@PostMapping("/presupuestar")
	public RedirectView presupuestar(@ModelAttribute("certificado") Certificado certificadoForm,@ModelAttribute("tipo") String tipo,Model modelo,RedirectAttributes redir) {
		RedirectView redirectView;
		if(certificadoForm.getPrecio()<=0) {
			String errores = "Errores: ";
			if(certificadoForm.getPrecio()<=0) {
				errores = errores + "el presupuesto debe ser mayor que 0, ";
			}

			redir.addFlashAttribute("error",errores);
			redir.addAttribute("certificadoId",certificadoForm.getId());
			redirectView= new RedirectView("/certificados/formularioPresupuestar",true);
			return redirectView;		
		}else {
			Certificado certificado = persistance.getCertificado(certificadoForm.getId());
			try {
				certificado.presupuestar(certificadoForm.getPrecio());
				persistance.saveOrUpdateCertificado(certificado);
			} catch(Exception e){
				e.printStackTrace();
			}
			redirectView= new RedirectView("/usuarios/menu",true);
			return redirectView;
		}
	}
	
	@GetMapping("/formularioFinalizar")
	public String formularioFinalizar(@RequestParam("certificadoId") int id,@ModelAttribute("tipo") String tipo,Model elModelo ) {
		Certificado certificado = persistance.getCertificado(id);
		elModelo.addAttribute("certificado", certificado);
		return "formularioFinalizarCertificado";		
	}
	
	@PostMapping("/finalizar")
	public String finalizar(@ModelAttribute("certificado") Certificado certificadoForm,@ModelAttribute("tipo") String tipo,Model elModelo ) {
		try {
			Certificado certificado = persistance.getCertificado(certificadoForm.getId());
			certificado.setOtrosDatos(certificadoForm.getOtrosDatos());
			TipoCertificado type = TipoCertificado.valueOf(tipo);
			switch(type) {
	    	case CERTIFICADO_ENERGETICO:
	    		((CertificadoEnergetico) certificado).setCategoria(((CertificadoEnergetico) certificadoForm).getCategoria());
	    		break;
			case INFORME_PERICIAL:
				break;
			case HABITABILIDAD:
				break;
			case INSPECCION_TECNICA:
				break;
			default:
				break;
			}
				
			certificado.finalizar();
			persistance.saveOrUpdateCertificado(certificado);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/usuarios/menu";		
	}
	
	@GetMapping("/descartarCertificado")
	public String descartar(@RequestParam("certificadoId") int id,Model elModelo ) {
		try {
			Certificado certificado = persistance.getCertificado(id);
			certificado.setEstado(EstadosCertificado.CADUCADO_SIN_RENOVAR);
			persistance.saveOrUpdateCertificado(certificado);
		} catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/usuarios/menu";		
	}
	
	@GetMapping("/cancelarCertificado")
	public String cancelar(@RequestParam("certificadoId") int id,Model elModelo ) {
		try {
			Certificado certificado = persistance.getCertificado(id);
			certificado.cancelar();
			persistance.saveOrUpdateCertificado(certificado);
		} catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/usuarios/menu";		
	}
	
	@GetMapping("/solicitarRenovacion")
	public String renovar(@RequestParam("certificadoId") int id,Model elModelo ) {
		try {
			Certificado certificado = persistance.getCertificado(id);
			Certificado newCert;
			certificado.setEstado(EstadosCertificado.CADUCADO_RENOVACION_SOLICITADA);
			persistance.saveOrUpdateCertificado(certificado);
			TipoCertificado type = certificado.getTipo();
	    	switch(type) {
	    	case CERTIFICADO_ENERGETICO:
	    		newCert = new CertificadoEnergetico();
	    		break;
			case INFORME_PERICIAL:
				newCert = new InformePericial();
				break;
			case HABITABILIDAD:
				newCert =  new CertificadoHabitabilidad();
				break;
			case INSPECCION_TECNICA:
				newCert =  new CertificadoInspeccionTecnica();
				break;
			default:
				newCert =  null;
				break;
	    	}
	    	newCert.setEstado(EstadosCertificado.SOLICITADO);
			persistance.añadirCertificado(newCert,certificado.getCliente(),certificado.getVivienda());
			persistance.saveOrUpdateCertificado(newCert);
		} catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/usuarios/menu";		
	}
	
	@GetMapping("/registrarVisita")
	public String registrarVisita(@RequestParam("certificadoId") int id,Model elModelo ) {
		try {
			Certificado certificado = persistance.getCertificado(id);
			certificado.visitar();
			persistance.saveOrUpdateCertificado(certificado);
		} catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/usuarios/menu";		
	}
	@GetMapping("/anadirNota")
	public String añadirNota(@RequestParam("certificadoId") int id,Model elModelo ) {
		Certificado cert = persistance.getCertificado(id);
		elModelo.addAttribute("certificado", cert);
		return "formularioAñadirNotaCertificados";	
	}
	
	@PostMapping("/guardarNota")
	public String guardarNota(@ModelAttribute("certificado") Certificado certificadoForm,@ModelAttribute("tipo") String tipo,Model modelo) {
		Certificado Certificado = persistance.getCertificado(certificadoForm.getId());
		Certificado.setOtrosDatos(certificadoForm.getOtrosDatos());
		persistance.saveOrUpdateCertificado(Certificado);
		return "redirect:/usuarios/menu";	
	}
	

	@GetMapping("/verCertificadoPDF")
	public ModelAndView imprimirCertificado(@RequestParam("certificadoId") int id) throws Exception{
	   Certificado cert = persistance.getCertificado(id);
	   return new ModelAndView("viewPDF", "Cert", cert);
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
	

	
	@ModelAttribute("categoriasEnergeticas")
	public List<CategoriaEnergetica> categoriasEnegeticas(){
		System.out.println("Categorias");
		System.out.println(CategoriaEnergetica.values());
		return Arrays.asList(CategoriaEnergetica.values());
	}
	
	@ModelAttribute("userSession")
	public UserSession sesion(){
		return session;
	}
	
	
	

}
