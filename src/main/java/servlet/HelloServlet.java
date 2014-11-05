package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisinos.unitunes.controller.AcademicController;
import br.unisinos.unitunes.model.Academic;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
//    	AcademicController ac = AcademicController.getInstance();
//    	List<Academic> books = ac.getAll();
//    	req.setAttribute("books", books);
    	
    	Academic books;
    	
    	AcademicController ac = AcademicController.getInstance();
    	try {
    		books = ac.getById(1);
    	}
    	catch (Exception e) {
    		books = new Academic(0, e.getMessage(), "", "", "", 0, false, true); 
    	}
    	
    	RequestDispatcher dispatcher = req.getRequestDispatcher("books.jsp");
    	dispatcher.forward(req, resp);
    }
    
}
