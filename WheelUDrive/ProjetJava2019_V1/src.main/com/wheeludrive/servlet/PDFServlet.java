package com.wheeludrive.servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.tools.PDF;

@WebServlet(urlPatterns = { "/wheeludrive/pdf" })
public class PDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public final String ID_FACTURE = "id_facture";

	public final String INVOICE_TEMPLATE = "/WEB-INF/wheeludrive/pdf/invoice.jsp";

	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> erreurs = new HashMap<String, String>();

		// pour pouvoir récupérer l'html généré depuis du jsp ,et le convertir en pdf
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response) {
			private final StringWriter sw = new StringWriter();

			@Override
			public PrintWriter getWriter() throws IOException {
				return new PrintWriter(sw);
			}

			@Override
			public String toString() {
				return sw.toString();
			}
		};

		// set templates values
		try {
			Map<String, Object> values = PDF.getInstance().getPDFValues();
			for (Entry<String, Object> entry : values.entrySet()) {
				request.setAttribute(entry.getKey(), entry.getValue());
			}
		} catch (PropertyException e1) {
		}

		request.getRequestDispatcher(INVOICE_TEMPLATE).include(request, responseWrapper);
		String content = responseWrapper.toString();
		System.out.println("Output : " + content);
		
		/*
	    try {
			Facture facture = FactureManager.findFacture(Integer.parseInt(request.getParameter(ID_FACTURE)));
		} catch (NumberFormatException | PropertyException e) {
			System.out.println("gnaaaa");
		}
		*/
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		Document document = new Document();

		try {
			PdfWriter writer = PdfWriter.getInstance(document, output);
			document.open();
			/*
			InputStream is = new ByteArrayInputStream(content.getBytes());
		    XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
			document.close();
			*/
			
			HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader(content));
			document.close();	
		  
			try {
			  response.setContentType("application/force-download");
			  response.setHeader("Content-disposition", "attachment; filename=facture.pdf");
			  response.setContentLength(output.size());
			  ServletOutputStream os = response.getOutputStream();
			  output.writeTo(os);
			  os.flush();
			  os.close();  
			} catch (Exception e) {
			  System.out.println("Eculé");
			  System.out.println(e.getMessage());
			}
		} catch (DocumentException e) {
			System.out.println("oki lol");
		}
		
		/*
		try {
			Facture facture = FactureManager.findFacture(Integer.parseInt(request.getParameter(ID_FACTURE)));
			// give the output stream to the generator
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			if (PDF.getInstance().generateInvoicePDF(facture, output)) {
				// directly download the pdf file
				response.setContentType("application/force-download");
				response.setHeader("Content-disposition", "attachment; filename=facture.pdf");
				response.setContentLength(output.size());
				ServletOutputStream os = response.getOutputStream();
				output.writeTo(os);
				os.flush();
				os.close();
			} else {
				throw new DocumentException();
			}
		} catch (NumberFormatException e) {
			erreurs.put(ID_FACTURE, "Aucune facture trouvée");
		} catch (PropertyException e) {
			erreurs.put(ID_FACTURE, "Aucune facture trouvée");
		} catch (DocumentException e) {
			erreurs.put(ID_FACTURE, "Une erreur s'est produit lors de la génération du document");
		}
		*/
		// todo abort request (this way we do not display invoice.jsp

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute(ATT_ERREURS, erreurs);
		/* Affichage de la page d'inscription */
//		this.getServletContext().getRequestDispatcher(ID_FACTURE).forward(request, response);
	}
}
