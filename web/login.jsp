<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Login</title>
	
	<link rel="stylesheet" type="text/css" href="css/loginSignup/login.css">
	<!-- Main Style Css -->
           
	 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="text/javascript" src="js/loginSignup/loginSignup.js"></script>
</head>
<body class="form-v8">
    <h1 class="topic">Mega City Cab</h1 >
	<div class="page-content">
            
		<div class="form-v8-content">
                    
			<div class="form-left">
				<img src="images/form-v8.jpg" alt="form">
			</div>
			<div class="form-right">
				<div class="tab">
					
					<div class="tab-inner">
                                            
						<button class="tablinks" onclick="openCity(event, 'sign-in')">Sign In</button>
					</div>
				</div>
				<form class="form-detail" action="LoginServlet" method="post" onsubmit="return validateForm();">
					
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
						
						<div class="form-row-last">
							<input type="submit" name="Sign In" class="register" value="Sign In">
						</div>
						<div class="form-row-last">
							<div class="btnsignup" ><a href="signup.jsp">Sign up</i></a></div>
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
    String error = request.getParameter("error");
    if (error != null) { 
%>
    <script type="text/javascript">
        showError(<%= error %>);
    </script>
<% 
    }
%>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>