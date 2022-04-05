package uned.ivan.tweb.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import uned.ivan.tweb.DAO.UsersDAO;
import uned.ivan.tweb.entity.User;

public class PdfController extends AbstractPdfView {
	@Autowired
	private UsersDAO userDAO;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    System.out.println("buildPdfDocument in OpenPDFView");
	    // List of users that will be displayed in the PDF
	    List<User> users = (List<User>)model.get("Users");
	    Font font = new Font(Font.HELVETICA, 18, Font.BOLDITALIC);

	    PdfPTable table = new PdfPTable(3);
	    table.setWidthPercentage(100.0f);
	    table.setWidths(new float[] {4.0f, 4.0f, 4.0f});
	    PdfPCell cell = new PdfPCell();
	    cell.setPhrase(new Phrase("First Name", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Last Name", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Email", font));
	    table.addCell(cell);
	    // adding rows
	    for(User user : users) {
	      table.addCell(user.getUsuario());
	      table.addCell(user.getContrasena());
	      table.addCell(user.getEmail());
	    }
	    // adding table to document
	    document.add(new Paragraph("Hello world"));
	    document.add(new Paragraph("Hello world"));
	    document.add(new Paragraph("Hello world"));
	    document.add(new Paragraph("Hello world"));
	    document.addAuthor("Bruno Lowagie");
	    document.addSubject("This is the result of a Test."); 
	    
	}
	
	


}
