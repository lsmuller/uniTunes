<%@ page import="java.util.*" %>
<%@ page import="br.unisinos.unitunes.model.*" %>
<html>
	<body>
		<% 	
			List<Book> books = (List<Book>) req.getAttribute("books");

			for(Book book : books) {
				out.println("Titulo: " + book.getTitle());
			}
		%>
	</body>
</html>	