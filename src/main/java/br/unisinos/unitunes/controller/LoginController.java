package br.unisinos.unitunes.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisinos.unitunes.model.Academic;
import br.unisinos.unitunes.model.ViewMessage;
import br.unisinos.unitunes.service.AcademicService;

@WebServlet(
        name = "LoginController", 
        urlPatterns = {"/login"}
    )
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	AcademicService academicService = AcademicService.getInstance();
    	RequestDispatcher dispatcher = null;
    	
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	Academic academic = null;
		try {
			academic = academicService.login(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if (academic != null) {
    		request.getSession().setAttribute("academic", academic);
    		dispatcher = request.getRequestDispatcher("index.jsp");
    	} else {
    		List<ViewMessage> viewMessages = new ArrayList<ViewMessage>();
    		viewMessages.add(new ViewMessage(ViewMessage.ERROR, "Email ou senha inválidos"));
    		viewMessages.add(new ViewMessage(ViewMessage.ERROR, email));
    		viewMessages.add(new ViewMessage(ViewMessage.ERROR, password));
    		dispatcher = request.getRequestDispatcher("login.jsp");
    		request.setAttribute("messages", viewMessages);
    	}
    	
    	dispatcher.forward(request, response);
    }
}
