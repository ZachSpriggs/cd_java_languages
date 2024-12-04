<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Show books!</title>
</head>
<body>

	<div class = "wrapper">
	<div class = "left"></div>
	<div class = "languages">
	<form action="/languages" method="post">
    	<input type="hidden" name="_method" value="Dashboard">
    	<input type="submit" value="Dashboard">
	</form>
	<h1>Language: <c:out value="${language.name}"/></h1>
		<p>Creator: <c:out value="${language.creator}"/></p>
		<p>Version: <c:out value="${language.version}"/></p>
		<p>ID: <c:out value="${language.id}"/></p>
		<a href="/languages/${language.id}/edit">Edit language</a>
		<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</div>
	<div class = "right"></div>
	</div>
</body>
</html>