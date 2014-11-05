<%@ page import="java.util.*" %>
<%@ page import="br.unisinos.unitunes.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>

	Listando academicos...

		<ul>
		<c:forEach var="book" items="${requestScope.books}">
		    <li> Id: ${book.id}
		    <li> Email: ${book.email}
		    <li> Nome: ${book.firstName}
		    <li> Sobrenome: ${book.lastName}
		    <li> Senha: ${book.password}
		    <li> Saldo: ${book.balance}
		    <li> Admin: ${book.admin}
		    <li> Excluido: ${book.excluded}
		    <br>
		</c:forEach>
		<ul>

		<%
			Academic a = null;
			a = request.getAttribute("books);
			
			out.println(a);
		
			//List<Academic> academics = null;
			//academics = (List<Academic>) request.getAttribute("books");

			//for(Academic a : academics) {
			//	out.println(a.toString());
			//	out.println();
			//}

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