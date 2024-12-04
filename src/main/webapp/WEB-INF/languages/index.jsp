<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>All languages</title>
</head>
<body>
	  
	<div class = "wrapper">
	<div class = "left"></div>
		<div class = "languages">
			<h1>All Books</h1>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Creator</th>
			            <th>Version</th>
			            <th>Actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${languages}" var="language">
			        <tr>
			            <td><a href = "/languages/${language.id}"><c:out value="${language.name}"/></a></td>
			            <td><c:out value="${language.creator}"/></td>
			            <td><c:out value="${language.version}"/></td>
			            <td><a href = "/languages/${language.id}/edit">Edit | </a>
			            	<form action="/languages/${language.id}" method="post">
    							<input type="hidden" name="_method" value="delete">
    							<input type="submit" value="Delete">
							</form>
			            </td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		<div class = "forms">
			<h1>New Language</h1>
			<form:form action="/languages/create" method="post" modelAttribute="language">
			    <p>
			        <form:label path="name">Name: </form:label>
			        <form:errors path="name"/>
			        <form:input path="name"/>
			    </p>
			    <p>
			        <form:label path="creator">Creator: </form:label>
			        <form:errors path="creator"/>
			        <form:input path="creator"/>
			    </p>
			    <p>
			        <form:label path="version">Version: </form:label>
			        <form:errors path="version"/>
			        <form:input path="version"/>
			    </p> 
		    <input type="submit" value="Submit"/>
			</form:form> 
		</div>
	<div class = "right"></div>
	</div>

</body>
</html>