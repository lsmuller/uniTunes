<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unitunes</title>
</head>
<body>
	<c:forEach var="message" items="${messages}">
		${message.message} <br />
	</c:forEach>
	
	${request.requestedURI}
	${requestScope['javax.servlet.forward.request_uri']}

	<form action="/login" method="post">
		Email: <input type="text" name="email" /> <br />
		Senha: <input type="password" name="password" /> <br />
		<input type="submit" />
	</form>
</body>
</html>