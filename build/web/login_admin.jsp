<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>

    
    <link rel="stylesheet" type="text/css" href="css/loginSignup/login.css">
 
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="text/javascript" src="js/loginSignup/loginSignup.js"></script>
</head>
<body class="form-v8">
   <h1 class="topic">Super Admin Logging</h1 >
    <div class="page-content">
        <div class="form-v8-content">
            
            <div class="form-right">
                <form class="form-detail" action="LoginServletAdmin" method="post" onsubmit="return validateForm();">
                    <div class="form-row">
                        <label class="form-row-inner">
                            <input type="text" name="username" id="username" class="input-text" required>
                            <span class="label">Username</span>
                            <span class="border"></span>
                        </label>
                    </div>
                    <div class="form-row">
                        <label class="form-row-inner">
                            <input type="password" name="password" id="password" class="input-text" required>
                            <span class="label">Password</span>
                            <span class="border"></span>
                        </label>
                    </div>
                    <input type="hidden" name="role" value="superAdmin">
                    <div class="form-row-last">
                        <input type="submit" name="login" class="register" value="Login">
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
		function openCity(evt, cityName) {
		    var i, tabcontent, tablinks;
		    tabcontent = document.getElementsByClassName("tabcontent");
		    for (i = 0; i < tabcontent.length; i++) {
		        tabcontent[i].style.display = "none";
		    }
		    tablinks = document.getElementsByClassName("tablinks");
		    for (i = 0; i < tablinks.length; i++) {
		        tablinks[i].className = tablinks[i].className.replace(" active", "");
		    }
		    document.getElementById(cityName).style.display = "block";
		    evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>

    <% 
        // Retrieve the error parameter from the request (e.g., ?error=1 or ?error=2)
        String error = request.getParameter("error");
        if (error != null) { 
    %>
        <script type="text/javascript">
            showError(<%= error %>);  // Call the function from the external JS file for error handling
        </script>
    <% 
        }
    %>
</body>
</html>
