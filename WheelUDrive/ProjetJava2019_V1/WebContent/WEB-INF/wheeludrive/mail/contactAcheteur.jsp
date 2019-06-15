<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>Bonjour,</p>
<br>
<p>Si vous recevez ce mail c'est qu'un vendeur a accepté votre offre d'achat!</p>
<ul>
	<li>Nom : ${sender_name}</li>
	<li>Email : ${sender_email}</li>
</ul>
<br>
<p>
	Message : <br /> ${mail_content}
</p>