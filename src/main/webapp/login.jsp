<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
    <h1>Login</h1>
    
    <%
		String message = (String)  request.getAttribute("message");
		if(message != null){
		    %>
	        <p>
	            <%= message %>
	        </p>
	    <% } %>
    
    <form action="LoginServlet" method="post">
        <label for = "username">Username: </label><br> 
        <input type="text" name="username"><br>   

 		<label for = "password">Password: </label><br> 
        <input type="password" name="password"><br>
        
        <Button type="submit" value="Login">Login</Button>
    </form>   

</body>
</html>