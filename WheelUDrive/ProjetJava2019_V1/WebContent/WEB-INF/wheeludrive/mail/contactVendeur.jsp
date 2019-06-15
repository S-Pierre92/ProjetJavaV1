<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>Bonjour,</p>

<p>Un utilisateur vous contacte par rapport à l'une de vos annonces
	:
<p>
<ul>
	<li>Nom : ${sender_name}</li>
	<li>Email : ${sender_email}</li>
</ul>

<p>
	Message : <br /> ${mail_content}
<p>