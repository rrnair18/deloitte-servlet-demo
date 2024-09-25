package com.deloitte.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("Service method called");
	}



	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destroy method called");
	}



	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init method called");
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet method called");	
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact.jsp");
		dispatcher.forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet method called");	
		
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String email = request.getParameter("email");
		
		System.out.println("Subject : " +subject);
		System.out.println("Message : " +message);
		System.out.println("Email : " +email);
		
		request.setAttribute("message", "Thank You.");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact.jsp");
		dispatcher.forward(request, response);
		
	}	
}
