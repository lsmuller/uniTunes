<%@page import="br.unisinos.unitunes.service.EmailService"%>
<%@page import="br.unisinos.unitunes.service.AcademicService"%>
<%@ page import="java.util.*" %>
<%@ page import="br.unisinos.unitunes.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>

	Listando academicos... <br>


		<%
		
		// Envio de email
		EmailService.sendMail();
		
			//AcademicService ac = AcademicService.getInstance();
			//Academic a = ac.getById(1);
			
			//a.setFirstName("Paulo Henrique");
			//ac.update(a);
			//ac.delete(a.getId());
		
		
		/* Academic a = new Academic(10, "email@teste.com" + Math.random(), "Teddy", "Test", "senha", 0.00, false, false);
			ac.insert(a);		 */
			
		
			/* Academic a = null;
			a = (Academic) request.getAttribute("books");
			
			out.println(a); */
		
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