<%@ page import="java.util.*" %>
<%@ page import="br.unisinos.unitunes.model.*" %>
<html>
	<body>
		<% 	
			List<Book> books = null;

			if (request != null) {
				books = (List<Book>) request.getAttribute("books");
			} else {
				out.println("request vazia");
			}

			if (books != null) {
				for(Book book : books) {
					out.println("Titulo: " + book.getTitle());
				}
			} else {
				out.println("fudeu");
			}

		%>
	</body>
</html>	