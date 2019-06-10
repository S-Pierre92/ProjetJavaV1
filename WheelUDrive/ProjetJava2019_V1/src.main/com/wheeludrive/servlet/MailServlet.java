package com.wheeludrive.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wheeludrive.tools.Mail;

@WebServlet(urlPatterns = { "/wheeludrive/mail" })
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger log = Logger.getLogger(MailServlet.class);

	public final String ID_FACTURE = "id_facture";

	public final String CREATE_ACCOUNT_CONFIRMATION_TEMPLATE = "/WEB-INF/wheeludrive/mail/accountCreationConfirmation.jsp";

	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> erreurs = new HashMap<String, String>();

		List<String> sendTo = new ArrayList<String>();
		sendTo.add("altonio2323@gmail.com");

		Mail mail = Mail.getInstance();
		mail.send();

	}
}
