package com.wheeludrive.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wheeludrive.entity.Facture;
import com.wheeludrive.entity.manager.FactureManager;
import com.wheeludrive.exception.PropertyException;
import com.wheeludrive.tools.PDF;

public class PDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public final String VUE = "/WEB-INF/form.jsp";
	public final String VUE_SUCCESS = "/WEB-INF/confirmForm.jsp";
	public final String ID_FACTURE = "id_facture";

	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> erreurs = new HashMap<String, String>();

		try {
			Facture facture = FactureManager.findFacture(Integer.parseInt(request.getParameter(ID_FACTURE)));
			PDF.getInstance().generateInvoicePDF(facture);
		} catch (NumberFormatException e) {
			erreurs.put(ID_FACTURE, "Aucune facture trouvée");
		} catch (PropertyException e) {
			erreurs.put(ID_FACTURE, "Aucune facture trouvée");
		}

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute(ATT_ERREURS, erreurs);

		/* Transmission de la paire d'objets request/response à notre JSP */
		if (erreurs.size() != 0) {
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher(VUE_SUCCESS).forward(request, response);
		}

	}

	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {

		if (motDePasse.isEmpty() || motDePasse == null) {
			throw new Exception("C'est pour ton bien le mot de passe en fait");
		}

		if (!motDePasse.equals(confirmation)) {
			throw new Exception("On tient un nouveau cas Alzheimer...");
		}

	}
}
