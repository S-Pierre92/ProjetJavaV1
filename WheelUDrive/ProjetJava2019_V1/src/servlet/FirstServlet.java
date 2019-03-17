package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FormulaireBean;

@WebServlet(urlPatterns = {"/chemin"})
public class FirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Création et initialisation du message. */
		String paramAuteur = request.getParameter("auteur");
		String message = "Transmission de variables : OK ! " + paramAuteur;

		/* Création du bean */
		FormulaireBean bean = new FormulaireBean();
		/* Initialisation de ses propriétés */
		bean.setNom("Pierre");
		bean.setPrenom("Simon");
		bean.setPseudo("SP");
		bean.setMdp("mdp");

		/* Stockage du message et du bean dans l'objet request */
		request.setAttribute("message", message);
		request.setAttribute("formulaire", bean);

//		System.out.println(((FormulaireBean) request.getAttribute("formulaire")).getPrenom());

		this.getServletContext().getRequestDispatcher("/WEB-INF/page.jsp").forward(request, response);
	}
}
