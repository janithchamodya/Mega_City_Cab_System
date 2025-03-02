<%-- 
    Document   : customerdashboard
    Created on : Feb 10, 2025, 3:44:25 PM
    Author     : OZT00106
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mega City Cab - Customer Dashboard</title>

   
    
    <link href="css/adminDashboard/fontawesome/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="css/adminDashboard/mega-city-admin/Mega City Cabadmin.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/loginSignup/login.css">
    <script type="text/javascript" src="js/customerDashboard/customerDashboard.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swcsseetalert2@11"></script>
    
   
     
      
      <link rel="stylesheet" type="text/css" href="css/customerDashboard/bootstrap.css" />
      
      <link href="css/customerDashboard/font-awesome.min.css" rel="stylesheet" />
      
      <link href="css/customerDashboard/style.css" rel="stylesheet" />
    
      <link href="css/customerDashboard/responsive.css" rel="stylesheet" />
    
    
</head>

<body id="page-top">
    <div id="wrapper">
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

          
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="customerdashboard.jsp">
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
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Booking</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Customer Booking:</h6>
                        <a class="collapse-item" href="addVehicleServlet?vehicleType=car">Car Booking</a>
                        <a class="collapse-item" href="addVehicleServlet?vehicleType=van">Van Booking</a>
                        <a class="collapse-item" href="addVehicleServlet?vehicleType=bus">Bus Booking</a>
                        
                        <a class="collapse-item" href="addVehicleServlet?vehicleType=bike">Truck Booking</a>

                        
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Facilities</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Customer Facilities:</h6>
                       
                        <a class="collapse-item" href="showMyBookingServlet">View My Booking</a>
                        
                        
                    </div>
                </div>
            </li>
             

            <!-- Divider -->
            <hr class="sidebar-divider">
            <div class="sidebar-heading">
                Reference
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>User Guide</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        
                        <a class="collapse-item" href="userGuide.jsp">User Guide</a>
                        
                    </div>
                </div>
            </li>


            

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
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small" >
                             <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                <%= session.getAttribute("user") != null ? session.getAttribute("user") : "Guest" %>
                            
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
            
            <section class="slider_section " style="margin-top: -70px;">
                
                <div id="customCarousel1" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active" >
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                <span>
                                                    Save 30% on Car Rentals
                                                </span>
                                                <br>
                                                Book Your Ride Today!
                                            </h1>
                                            <p>
                                                Enjoy unbeatable discounts on our wide range of vehicles. Whether it's for business or leisure, Mega City Cab has you covered. Drive away in comfort and style!
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Rent Now
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                <span>
                                                    Free Ride for Lucky Winners
                                                </span>
                                                <br>
                                                Exclusive Offers Await!
                                            </h1>
                                            <p>
                                                Be one of our lucky customers to win a free day of driving! Book now and stand a chance to get a free rental or amazing discounts on your next ride.
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Get Started
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                <span>
                                                    Up to 50% Off
                                                </span>
                                                <br>
                                                On Premium Vehicles
                                            </h1>
                                            <p>
                                                Ride luxury at half the price! Get up to 50% off on our premium car rentals. Don't miss out on this limited-time offer. Your journey starts here with Mega City Cab!
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Explore Deals
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            
        
            
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
                    <a class="btn btn-primary" href="login.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>

   
    <script src="js/adminDashboard/jquery/jquery.min.js"></script>
    <script src="js/adminDashboard/bootstrap/bootstrap.bundle.min.js"></script>
    <script src="js/adminDashboard/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/customerDashboard/jquery-3.4.1.min.js"></script>
    
    <script src="js/customerDashboard/popper.min.js"></script>
      
    <script src="js/customerDashboard/bootstrap.js"></script>
      
    <script src="js/customerDashboard/custom.js"></script>

    

</body>

</html>
