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
    <script type="text/javascript" src="js/loginSignup/loginSignup.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
    #content-wrapper {
        background: url('images/bg.jpg') no-repeat center center fixed;
        background-size: 100% 600px; 
        height: 3000px;
        width: 90%;
        position: relative;
        
    }
    
    
    #content-wrapper::before {
        content: '';
        position: absolute;
        top: 0;
        left: o;
        right: 0;
        bottom: 0;
        background: rgba(255, 255, 255, 0.92);
        z-index: -1;
    }
</style>

</head>

<body id="page-top"  >
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
                        <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Admin Facilities:</h6>
                        <a class="collapse-item" href="addVehical.jsp">Add Vehicle</a>
                        <a class="collapse-item" href="addDriver.jsp">Add Drivers</a>
                        <a class="collapse-item" href="changeVehicalDetailsServlet">Update /Delete Vehicle</a>
                        <a class="collapse-item" href="changeDriverDetailsServlet">Update /Delete Drivers</a>
                        <a class="collapse-item" href="adminViewAllCustomerServlet">View All Customer</a>
                        <a class="collapse-item" href="adminViewAllBookingsServlet">View All Bookings</a>
                        </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Addmin Controls</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="confirmReturnServlet">Return New</a>
                        
                    </div>
                </div>
            </li>
           

            <!-- Divider -->
            <hr class="sidebar-divider">

        </ul>
        

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
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small" >
                             <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                <%= session.getAttribute("admin") != null ? session.getAttribute("admin") : "Guest" %>
                            </span>

                                    
                                </span>
                                <img class="img-profile rounded-circle"
                                     src="images/adminDashboard/../customerDashboard/undraw_profile_1.svg">
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
              

            
           
            
            
            
            
            
            
            <!-- End of Main Content -->
        
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
                        <span aria-hidden="true">�</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>

   
    <script src="js/adminDashboard/jquery/jquery.min.js"></script>
    <script src="js/adminDashboard/bootstrap/bootstrap.bundle.min.js"></script>
    <script src="js/adminDashboard/jquery-easing/jquery.easing.min.js"></script>

    

    

</body>

</html>