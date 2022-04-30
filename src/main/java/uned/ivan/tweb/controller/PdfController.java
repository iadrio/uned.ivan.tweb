package uned.ivan.tweb.controller;


import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.draw.LineSeparator;
import uned.ivan.tweb.DAO.UsersDAO;
import uned.ivan.tweb.entity.Certificado;
import uned.ivan.tweb.entity.CertificadoEnergetico;
import uned.ivan.tweb.entity.CertificadoHabitabilidad;
import uned.ivan.tweb.entity.CertificadoInspeccionTecnica;
import uned.ivan.tweb.entity.InformePericial;
import uned.ivan.tweb.entity.TipoCertificado;
import uned.ivan.tweb.entity.User;

public class PdfController extends AbstractPdfView {
	@Autowired
	private UsersDAO userDAO;
	
	private String autor = "TWEB Arquitectura";
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Certificado cert = (Certificado) model.get("Cert");
		Font font = new Font(Font.HELVETICA, 12, Font.BOLDITALIC);
		Font font2 = new Font(Font.HELVETICA, 10, Font.BOLDITALIC);
		
	    setCabecera(document);
	    setDatosComunes(document,font,font2,cert);
	    addDatosEspecificos(document,font,font2,cert);
	    document.add(new Paragraph(" ",font));
	    document.add(new Paragraph("DATOS DEL CLIENTE",font));
	    document.add(new Paragraph(" ",font));
	    addUserData(document,font,font2,cert.getCliente());
		document.add(new LineSeparator());
		
		if(cert.getArquitecto()!=null) {
			document.add(new Paragraph(" ",font));
		    document.add(new Paragraph("DATOS DEL ARQUITECTO",font));
		    document.add(new Paragraph(" ",font));
		    document.add(new LineSeparator());
		    addUserData(document,font,font2,cert.getArquitecto());
		}
		
		document.add(new Paragraph(" ",font));
	    document.add(new Paragraph("OTROS DATOS",font));
	    document.add(new Paragraph(" ",font));
	    document.add(new Paragraph(cert.getOtrosDatos(),font2));
	    /*document.addCreator(autor);
	    document.addAuthor(autor);
	    document.addTitle(cert.getTipo().toString() + " " + cert.getVivienda().toString());
	    document.addCreationDate();*/
	}
	
	public void setCabecera(Document document) throws Exception {
		String imageFile = "cabecera.jpg"; 
	    Resource resource = new ClassPathResource(imageFile);
	    Image img = new Jpeg(resource.getURL()); 
	    document.add(img);
	}
	
	public void setDatosComunes(Document document,Font font,Font font2,Certificado cert) throws Exception{
		document.add(new LineSeparator());
		PdfPTable table = new PdfPTable(6);
	    table.setWidthPercentage(100.0f);
	    table.setWidths(new float[] {0.25f, 0.5f, 0.5f,2f, 1f,4.0f});
	    PdfPCell cell = new PdfPCell();
	    cell.setPhrase(new Phrase("Id", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(Integer.toString(cert.getId()), font2));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Tipo", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getTipo().toString(), font2));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Precio", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(Float.toString(cert.getPrecio()) + "€", font2));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Estado", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getEstado().toString(), font2));
	    table.addCell(cell);
	    document.add(table);
	    table = new PdfPTable(2);
	    table.setWidthPercentage(100.0f);
	    table.setWidths(new float[] {0.5f, 3f});
	    cell.setPhrase(new Phrase("Vivienda", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getVivienda().getDireccion(), font2));
	    table.addCell(cell);
	    document.add(table);
	    table = new PdfPTable(4);
	    table.setWidthPercentage(100.0f);
	    table.setWidths(new float[] {1.25f, 2f,1f,2f});
	    cell.setPhrase(new Phrase("fecha solicitud", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getFechaSolicitud().toLocaleString(), font2));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("fecha entrega", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getFechaEntrega()!=null?cert.getFechaEntrega().toLocaleString():"", font2));
	    table.addCell(cell);
	    document.add(table);
	}

	public void addUserData(Document document,Font font,Font font2,User user) {
	    PdfPTable table = new PdfPTable(6);
	    PdfPCell cell = new PdfPCell();
	    table.setWidthPercentage(100.0f);
	    table.setWidths(new float[] {0.5f, 0.5f, 0.5f,1.0f, 0.5f,0.5f});
	    cell.setPhrase(new Phrase("Nombre", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(user.getNombre(), font2));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Apellidos", font));
	    table.addCell(cell);
	    String apellidos = user.getApellido1();
	    if(user.getApellido2()!=null) {
	    	apellidos = apellidos + " " + user.getApellido2();
	    }
	    cell.setPhrase(new Phrase(apellidos, font2));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Telefono", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(user.getTelefono(), font2));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Email", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(user.getEmail(), font2));
	    table.addCell(cell);
	    document.add(table);
	}
	
	public void addDatosEspecificos(Document document,Font font,Font font2,Certificado cert) {
		TipoCertificado type = cert.getTipo();
    	switch(type) {
    	case CERTIFICADO_ENERGETICO:
    		addCertificadoEnergetico(document,font,font2,(CertificadoEnergetico) cert);
    		break;
		case INFORME_PERICIAL:
			addInformePericial(document,font,font2,(InformePericial) cert);
			break;
		case HABITABILIDAD:
			addHabitabilidad(document,font,font2,(CertificadoHabitabilidad) cert);
			break;
		case INSPECCION_TECNICA:
			addInspeccionTecnica(document, font, font2,(CertificadoInspeccionTecnica) cert);
			break;
		default:
			break;
    	}
	}
	
	public void addCertificadoEnergetico(Document document,Font font,Font font2,CertificadoEnergetico cert) {
		PdfPTable table = new PdfPTable(2);
	    PdfPCell cell = new PdfPCell();
	    table.setHorizontalAlignment(Element.ALIGN_LEFT);
	    table.setWidthPercentage(25.0f);
	    table.setWidths(new float[] {0.5f, 0.25f});
	    cell.setPhrase(new Phrase("Categoría", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getCategoria()!=null?cert.getCategoria().toString():"", font2));
	    table.addCell(cell);
	    document.add(table);
	}
	
	public void addInformePericial(Document document,Font font,Font font2,InformePericial cert) {

	}
	
	public void addHabitabilidad(Document document,Font font,Font font2,CertificadoHabitabilidad cert) {
		PdfPTable table = new PdfPTable(4);
		PdfPCell cell = new PdfPCell();
	    table.setWidthPercentage(100.0f);
	    table.setWidths(new float[] {1.25f, 2f,1f,2f});
	    cell.setPhrase(new Phrase("fecha visita", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getFechaVisita()!=null?cert.getFechaVisita().toLocaleString():"", font2));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("fecha caducidad", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getFechaCaducidad()!=null?cert.getFechaCaducidad().toLocaleString():"", font2));
	    table.addCell(cell);
	    document.add(table);
	}
	
	public void addInspeccionTecnica(Document document,Font font,Font font2,CertificadoInspeccionTecnica cert) {
		PdfPTable table = new PdfPTable(2);
	    PdfPCell cell = new PdfPCell();
	    table.setHorizontalAlignment(Element.ALIGN_LEFT);
	    table.setWidthPercentage(50.0f);
	    table.setWidths(new float[] {0.5f, 0.5f});
	    cell.setPhrase(new Phrase("Fecha caducidad", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(cert.getFechaCaducidad()!=null?cert.getFechaCaducidad().toString():"", font2));
	    table.addCell(cell);
	    document.add(table);
	}
}
