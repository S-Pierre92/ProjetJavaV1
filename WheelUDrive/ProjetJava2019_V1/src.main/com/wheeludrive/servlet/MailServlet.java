package com.wheeludrive.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

import com.wheeludrive.tools.Mail;

@WebServlet(urlPatterns = { "/wheeludrive/mail" })
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger log = Logger.getLogger(MailServlet.class);

	public final String MAIL_OBJECT = "mail_object";
	public final String MAIL_CONTENT = "mail_content";
	public final String ID_USER_SENDER = "id_user_sender";
	public final String ID_USER_DEST = "id_user_dest";

	public final String CONTACT_VENDEUR_TEMPLATE = "/WEB-INF/wheeludrive/mail/contactVendeur.jsp";

	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> sendTo = new ArrayList<String>();
		sendTo.add("projetjava2019@gmail.com");
		
		Mail mail = Mail.getInstance();
		try {
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

			request.setAttribute("mail_content", StringEscapeUtils.escapeHtml(request.getParameter(MAIL_CONTENT)));
			request.setAttribute("mail_object", StringEscapeUtils.escapeHtml(request.getParameter(MAIL_OBJECT)));
			request.setAttribute("", "");

			// generate pdf template
			request.getRequestDispatcher(CONTACT_VENDEUR_TEMPLATE).include(request, responseWrapper);
			String content = responseWrapper.toString();

			mail.sendEmail(sendTo, "sava", "ok");
		} catch (MessagingException e) {
			log.debug(e.getMessage());
		}
	}
}
