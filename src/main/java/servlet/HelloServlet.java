package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisinos.unitunes.controller.BookController;
import br.unisinos.unitunes.model.Book;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	BookController controller = new BookController();
    	
    	List<Book> books = controller.getBookList();
    	
    	req.setAttribute("books", books);
    	
    	String page = null;
    	
    	if (books == null) {
    		page ="books.jsp";
    	} else {
    		page = "index.jsp";
    	}
    	
    	RequestDispatcher dispatcher = req.getRequestDispatcher(page);
    	dispatcher.forward(req, resp);
    }
    
}
