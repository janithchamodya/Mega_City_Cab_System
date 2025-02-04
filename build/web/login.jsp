<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <a href="signup.jsp">Sign Up</a>
     <% 
        // Check if the error attribute is set in the request
        if (request.getAttribute("error") != null) { 
    %>
        <script type="text/javascript">
            showError(); 
        </script>
    <% 
        }
    %>
</body>
</html>