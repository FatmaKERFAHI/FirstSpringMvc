<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Index page</title>
</head>
<body>
	<h2>To add new person</h2>
	<form action="addPerson" method="post">
		Nom : <input type="text" name="nom"> 
		Prenom : <input	type="text" name="prenom">
		<button type="submit">Envoyer</button>
	</form>
</body>
</html>
