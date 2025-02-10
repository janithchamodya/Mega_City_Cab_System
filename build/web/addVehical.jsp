<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mega City Cab - Addmin Dashboard</title>

   
    
    <link href="css/adminDashboard/fontawesome/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="css/adminDashboard/mega-city-admin/Mega City Cabadmin.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/loginSignup/login.css">
    <script type="text/javascript" src="js/adminDashboard/adminDashboard.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body id="page-top">
    <div id="wrapper">
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

          
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Mega City Cab</div>
            </a>

          
            <hr class="sidebar-divider my-0">
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Facilities</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Addmin Facilities:</h6>
                        <a class="collapse-item" href="addVehical.jsp">Add Vehicle</a>
                        <a class="collapse-item" href="">Add Drivers</a>
                        <a class="collapse-item" href=""></a>
                        
                        
                    </div>
                </div>
            </li>

           

            <!-- Divider -->
            <hr class="sidebar-divider">


            

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                       
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                <img class="img-profile rounded-circle"
                                    src="">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
            <!-- End of Topbar -->
            <dev class="form-v8">
                
                    <div class="form-v8-content" style="margin-top: 0px;margin-left: 60px">
                        <div class="form-right">
                            <div class="tab">
                                <div class="tab-inner">
                                    <button class="tablinks" onclick="openCity(event, 'sign-in')">Add  Vehicle</button>
                                </div>
                            </div>

                           <form class="form-detail" action="addVehicleServlet" method="post" enctype="multipart/form-data">

                                <div class="tabcontent" id="sign-in">

                                    <!-- Vehicle Details Section -->
                                    <div class="form-row">
                                        <label class="form-row-inner">
                                            <input type="text" name="model" id="model" class="input-text" required>
                                            <span class="label">Model</span>
                                            <span class="border"></span>
                                        </label>
                                    </div>
                                    <div class="form-row">
                                        <label class="form-row-inner">
                                            <input type="text" name="vehicleName" id="vehicleName" class="input-text" required>
                                            <span class="label">Vehicle Name</span>
                                            <span class="border"></span>
                                        </label>
                                    </div>
                                    <div class="form-row">
                                        <label class="form-row-inner">
                                            <input type="text" name="vehicleNumber" id="vehicleNumber" class="input-text" required>
                                            <span class="label">Vehicle Number</span>
                                            <span class="border"></span>
                                        </label>
                                    </div>
                                    <div class="form-row">
                                        <label class="form-row-inner">
                                            <input type="text" name="vehicleOwner" id="vehicleOwner" class="input-text" required>
                                            <span class="label">Vehicle Owner</span>
                                            <span class="border"></span>
                                        </label>
                                    </div>
                                    <div class="form-row">
                                        <label class="form-row-inner">
                                            <input type="tel" name="vehicleOwnerContact" id="vehicleOwnerContact" class="input-text" required>
                                            <span class="label">Vehicle Owner Contact Number</span>
                                            <span class="border"></span>
                                        </label>
                                    </div>
                                    <div class="form-row">
                                        <label class="form-row-inner">
                                            <input type="file" name="vehicleImage" id="vehicleImage" class="input-text" accept="image/*" required>
                                            <span class="label">Vehicle Image</span>
                                            <span class="border"></span>
                                        </label>
                                    </div>

                                    <input type="hidden" name="role" value="admin">

                                    <div class="form-row-last">
                                        <input type="submit" name="register" class="register" value="Add Vehicle">
                                        
                                    </div>
                                </div>
                            </form>

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
            </dev> 
            
            
            
            
            
            
            
            
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Mega City Cab Website 2025</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

   
    <script src="js/adminDashboard/jquery/jquery.min.js"></script>
    <script src="js/adminDashboard/bootstrap/bootstrap.bundle.min.js"></script>
    <script src="js/adminDashboard/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    

</body>

</html>