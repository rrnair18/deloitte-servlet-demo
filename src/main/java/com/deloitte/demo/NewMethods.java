package com.deloitte.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Employee")
public class NewMethods extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        response.setContentType("text/html");  

        PrintWriter out = response.getWriter();

        out.println("<table>");
        out.println("<tr><th>EmployeeId</th><th>EmployeeName</th><th>Salary</th></tr>");

        String[][] employeeData = {
                {"1", "Sonu", "50000"},
                {"2", "Monu", "60000"},
                {"3", "Tonu", "70000"}
        };

        for (String[] employee : employeeData) {
            out.println("<tr><td>" + employee[0] + "</td><td>" + employee[1] + "</td><td>" + employee[2] + "</td></tr>");
        }

        out.println("</table>");
    }

}
