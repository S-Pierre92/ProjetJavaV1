package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/inscription"})
public class Inscription extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  final String VUE = "/WEB-INF/form.jsp";
    public  final String CHAMP_EMAIL = "email";
    public  final String CHAMP_PASS = "motdepasse";
    public  final String CHAMP_CONF = "confirmation";
    public  final String CHAMP_NOM = "nom";
    
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    
    

	
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
    	String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();
    	
    	String nom = request.getParameter(CHAMP_NOM);
    	String email = request.getParameter(CHAMP_EMAIL);
    	String mdp = request.getParameter(CHAMP_PASS);
    	String confirmation = request.getParameter(CHAMP_CONF);
    	
    	try {
			this.validationEmail(email);		
		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
    	
    	try {
			this.validationMotsDePasse(mdp, confirmation);
			
		} catch (Exception e) {
			erreurs.put(CHAMP_CONF, e.getMessage());
			erreurs.put(CHAMP_PASS, e.getMessage());
		}
    	
    	try {
			this.validationNom(nom);
			
		} catch (Exception e) {
			erreurs.put(CHAMP_NOM, e.getMessage());
		}
    	
    	/* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty()) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	
    }
    
    
    private void validationEmail( String email ) throws Exception{
    	
    	if(email.isEmpty() || email == null) {
    		throw new Exception("Faut faire péter l'email wesh");
    	}
    	
    	if(!email.contains("@")) {
    		
    		throw new Exception("Les @, c'est pour les chiens?");
    	}
    	
    }
    
    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
    	
    	if(motDePasse.isEmpty() || motDePasse == null) {
    		throw new Exception("C'est pour ton bien le mot de passe en fait");
    	}
    	
    	if(!motDePasse.equals(confirmation)) {
    		throw new Exception("On tient un nouveau cas Alzheimer...");
    	}
    	
    	
    }
    private void validationNom( String nom ) throws Exception{
    	
    	if(nom.isEmpty() || nom == null) {
    		throw new Exception("What's your name?");
    	}
    	
    }
}
