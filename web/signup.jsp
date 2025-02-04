<%-- 
    Document   : signup
    Created on : Feb 4, 2025, 3:50:06 PM
    Author     : OZT00106
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
</head>
<body>
    <h2>Create Account</h2>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">All fields are required!</p>
    <% } %>

   <form action="SignupServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="nic">NIC:</label>
    <input type="text" id="nic" name="nic" required><br><br>

    <label for="address">Address:</label>
    <textarea id="address" name="address" rows="3" cols="30" required></textarea><br><br>

    <label for="phone">Phone Number:</label>
    <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required><br><br>

    <input type="hidden" name="role" value="user">

    <button type="submit">Sign Up</button>
    </form>


    <br>
    <a href="login.jsp">Already have an account? Log In</a>
</body>
</html>
