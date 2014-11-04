<%@ page import="java.util.*" %>
<%@ page import="br.unisinos.unitunes.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
		<ul>
		<c:forEach var="book" items="${requestScope.books}">
		    <li> ${book.id}
		    <li> ${book.email}
		    <li> ${book.firstName}
		    <li> ${book.lastName}
		    <li> ${book.password}
		    <li> ${book.balance}
		    <li> ${book.admin}
		    <li> ${book.excluded}
		</c:forEach>
		<ul>

		<% 	
			List<Academic> academics = null;
			academics = (List<Academic>) request.getAttribute("books");

			for(Academic a : academics) {
				out.println(a.toString());
			}

			//List<Book> books = null;

			//books = (List<Book>) request.getAttribute("books");

			//if (books != null) {
			//for(Book book : books) {
			//	out.println("Titulo: " + book.getTitle());
			//	}
			//}
		%>
	</body>
</html>	