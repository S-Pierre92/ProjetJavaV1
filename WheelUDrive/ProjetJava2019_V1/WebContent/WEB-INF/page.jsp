<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Premier jsp</title>
</head>
<body>
	<p>Ceci est une page jsp.</p>
	<jsp:useBean id="formulaire" class="beans.FormulaireBean" scope="request">
   
   <p>Nouveau bean !</p>
</jsp:useBean>

<jsp:getProperty name="formulaire" property="prenom"  />


</body>
</html>