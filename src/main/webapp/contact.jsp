<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact  us</title>
</head>
<body>

		<h1>Contact Us</h1>
		
		<%
		String message = (String)  request.getAttribute("message");
		if(message != null){
		    %>
	        <p>
	            <%= message %>
	        </p>
	    <% } %>

	<form action="ContactServlet" method="post">
		<label for ="Name"> Name : </label><br> : 
		<input type="text" name="name"><br> 
		
		<label for = "email">Email: </label><br> : 
		<input type="email" name="email"><br> 
		
		<label for = "message">Message: </label><br> :
		<textarea name="message"></textarea> <br> 
		<input type="submit" value="Send">  

	</form>
</body>
</html>