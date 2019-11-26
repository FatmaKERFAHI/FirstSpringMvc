<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.error{color: red;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person Form</title>
</head>
<body>
<form:form modelAttribute="personne" action="personne" method="post">
<form:label path="nom">nom</form:label>
<form:input path="nom"/>
<form:errors path="nom" cssClass ="error"/>
<form:label path="prenom">prénom</form:label>
<form:input path="prenom" />
<form:errors path="prenom" cssClass ="error"/>
<input type="submit" value="Ajouter"/>
</form:form>
</body>
</html>