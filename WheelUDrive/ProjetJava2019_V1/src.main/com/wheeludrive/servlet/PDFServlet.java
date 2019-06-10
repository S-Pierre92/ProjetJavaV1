package com.wheeludrive.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Date;
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

import org.apache.log4j.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.wheeludrive.entity.Facture;
import com.wheeludrive.entity.manager.FactureManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.tools.PDF;

@WebServlet(urlPatterns = { "/wheeludrive/pdf" })
public class PDFServlet extends HttpServlet {
	private final static Logger log = Logger.getLogger(PDFServlet.class);

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

		try {
			Facture facture = FactureManager.findFacture(Integer.parseInt(request.getParameter(ID_FACTURE)));

			// init pdf data with facture
			if (PDF.getInstance().initPDFData(facture)) {
				// set templates values
				try {
					Map<String, Object> values = PDF.getInstance().getPDFValues();
					for (Entry<String, Object> entry : values.entrySet()) {
						request.setAttribute(entry.getKey(), entry.getValue());
					}
				} catch (PropertyException e1) {
					System.out.println("Une erreur est survenue lors de la récupération des infos");
				}

				// generate pdf template
				request.getRequestDispatcher(INVOICE_TEMPLATE).include(request, responseWrapper);
				String content = responseWrapper.toString();

				ByteArrayOutputStream output = new ByteArrayOutputStream();
				Document document = new Document();

				try {
					PdfWriter writer = PdfWriter.getInstance(document, output);
					document.open();

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
						System.out.println("Un problème est survenu lors de la génération du document");
					}
				} catch (DocumentException e) {
					System.out.println("Un problème est survenu lors de la génération du document");
				}
			} else {
				System.out.println("Une erreur est survenue lors de la génération du document");
			}
		} catch (NumberFormatException | PropertyException e) {
			System.out.println("Aucune facture trouvée");
		}
		// todo abort request (this way we do not display invoice.jsp
	}
}
