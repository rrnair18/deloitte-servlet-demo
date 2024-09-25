package com.deloitte.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_USERNAME = "admin";
	private static final String DEFAULT_PASSWORD = "password";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet method called");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String url = "jdbc:mysql://localhost:3306/EMPLOYEE";
		String user = "root";
		String pass = "18042002";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to the database successfully!");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM EMPLOYEE.USERDATA";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("name")+ " " + rs.getString("salary"));
			}
			
		}
		
		catch(ClassNotFoundException e){
			System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Database connection or SQL query error.");
			 e.printStackTrace();
		}
		
		finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
		}

		boolean validationResult = ValidateUser(username,password);
		
		if (validationResult = true) {
			request.setAttribute("message", "Login Successful");
			System.out.println("Login Successful");
		} else {
			request.setAttribute("message", "Login Failed!! Invalid Credentials");
			System.out.println("Login Failed");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

	}

	private boolean ValidateUser (String username ,String password) {
		boolean isValid; 
		;
		if (DEFAULT_USERNAME.equals(username) && DEFAULT_PASSWORD.equals(password)) {
			isValid = true;
		}
		else {
			isValid = false;
		}
		return isValid;
	}
	


}
