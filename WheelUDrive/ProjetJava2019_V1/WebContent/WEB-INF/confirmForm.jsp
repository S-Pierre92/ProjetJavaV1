<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Premier jsp</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
	<p>Ceci est une page jsp.</p>
	<p>Votre nom est ${resultat['nom']}</p>
	<p>Votre nom est ${resultat['email']}</p>
	<p>Votre nom est ${resultat['confirmation']}</p>
	<p>Votre nom est ${resultat['motdepasse']}</p>
</body>
</html>