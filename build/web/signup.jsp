<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Sign Up</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <link rel="stylesheet" type="text/css" href="css/loginSignup/login.css">
     <script type="text/javascript" src="js/loginSignup/loginSignup.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body class="form-v8">
    <div class="page-content">
        <div class="form-v8-content">
            <div class="form-right">
                <div class="tab">
                    <div class="tab-inner">
                        <button class="tablinks" onclick="openCity(event, 'sign-in')">Sign Up</button>
                    </div>
                </div>

                <form class="form-detail" action="SignupServlet" method="post" onsubmit="return validateForm();">
                    <div class="tabcontent" id="sign-in">
                        <div class="form-row">
                            <label class="form-row-inner">
                                <input type="text" name="username" id="username" class="input-text" required>
                                <span class="label">User Name</span>
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
                        <div class="form-row">
                            <label class="form-row-inner">
                                <input type="text" name="email" id="email" class="input-text" required>
                                <span class="label">E-Mail</span>
                                <span class="border"></span>
                            </label>
                        </div>
                        <div class="form-row">
                            <label class="form-row-inner">
                                <input type="text" name="nic" id="nic" class="input-text" required>
                                <span class="label">NIC</span>
                                <span class="border"></span>
                            </label>
                        </div>
                        <span class="label">Address</span>
                        <span class="border"></span>
                        <div class="form-row">
                            <label class="form-row-inner">
                                <textarea name="address" class="input-text" rows="4" cols="50" required></textarea>
                            </label>
                        </div>
                        <div class="form-row">
                            <label class="form-row-inner">
                                <input type="tel" name="phone" id="phone" class="input-text" required>
                                <span class="label">Phone</span>
                                <span class="border"></span>
                            </label>
                        </div>
                        <input type="hidden" name="role" value="user">

                        <div class="form-row-last">
                            <input type="submit" name="register" class="register" value="Sign Up">
                            <a href="login.jsp"><div class="btnsignup">Sign In</div></a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Script should be placed after the form for better execution -->
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

        document.getElementsByClassName("tablinks")[0].click(); 

        
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
</body>
</html>
