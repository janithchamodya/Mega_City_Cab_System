<%-- 
    Document   : orderConfirm
    Created on : Feb 12, 2025, 9:59:23 PM
    Author     : OZT00106
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%! 
   public List<String> splitDriverIds(String driverIds) {
        if (driverIds != null && !driverIds.isEmpty()) {
            return Arrays.asList(driverIds.split(";"));
        }
        return new ArrayList<>();
    }
%>

<%
    // Retrieve the parameters passed via URL
    
    String userId=request.getParameter("userId");
    String userName = request.getParameter("username");
    String vehicleId = request.getParameter("VehicalId");
    String vehicleModel = request.getParameter("vehicleModel");
    String vehicleName = request.getParameter("vehicleName");
    String vehicleNumber = request.getParameter("vehicleNumber");
    String vehicleOwner = request.getParameter("vehicleOwner");
    String vehicleOwnerContact = request.getParameter("vehicleOwnerContact");
    String vehicleWithAC = request.getParameter("vehicleWithAC");
    String vehicleWithoutAC = request.getParameter("vehicleWithoutAC");
    String driverIds = request.getParameter("driverIds");

    // Printing the values to the console
    System.out.println("userId"+userId);
    System.out.println("userName"+userName);
    System.out.println("vehicleId"+vehicleId);
    System.out.println("Vehicle Model: " + vehicleModel);
    System.out.println("Vehicle Name: " + vehicleName);
    System.out.println("Vehicle Number: " + vehicleNumber);
    System.out.println("Vehicle Owner: " + vehicleOwner);
    System.out.println("Vehicle Owner Contact: " + vehicleOwnerContact);
    System.out.println("Vehicle With AC Price: " + vehicleWithAC);
    System.out.println("Vehicle Without AC Price: " + vehicleWithoutAC);
    System.out.println("Driver ID: " + driverIds);

    // Split the driver IDs into a list (if necessary)
    List<String> driverList = splitDriverIds(driverIds);

    // Set attributes for use in JSP
    request.setAttribute("userId", userId);
    request.setAttribute("userName",userName );
    request.setAttribute("vehicleId",vehicleId);
    request.setAttribute("vehicleModel", vehicleModel);
    request.setAttribute("vehicleName", vehicleName);
    request.setAttribute("vehicleNumber", vehicleNumber);
    request.setAttribute("vehicleOwner", vehicleOwner);
    request.setAttribute("vehicleOwnerContact", vehicleOwnerContact);
    request.setAttribute("vehicleWithAC", vehicleWithAC);
    request.setAttribute("vehicleWithoutAC", vehicleWithoutAC);
    request.setAttribute("driverList", driverList);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirm Vehicle Details</title>
    
    <link rel="stylesheet" type="text/css" href="css/customerDashboard/customerDashboard.css">
    <script type="text/javascript" src="js/customerDashboard/customerDashboard.js"></script>
     <link rel="stylesheet" type="text/css" href="css/loginSignup/login.css">
    <style>
        :root {
            --primary-color: #2c3e50;
            --secondary-color: #3498db;
            --background-color: #f8f9fa;
            --text-color: #333;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--background-color);
            color: var(--text-color);
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
        }

        .container {
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .vehicle-details {
            margin-bottom: 30px;
            border: 1px solid #eee;
            border-radius: 10px;
            padding: 20px;
        }

        .detail-row {
            display: flex;
            justify-content: space-between;
            padding: 12px 0;
            border-bottom: 1px solid #eee;
        }

        .detail-row:last-child {
            border-bottom: none;
        }

        .detail-label {
            font-weight: 600;
            color: var(--primary-color);
            min-width: 150px;
        }

        .detail-value {
            color: #666;
            text-align: right;
        }

        .form-section {
            margin: 25px 0;
        }

        .form-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
            margin-bottom: 20px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: 600;
            margin-bottom: 8px;
            color: var(--primary-color);
        }

        input, select {
            padding: 12px;
            border: 2px solid #ddd;
            border-radius: 8px;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }

        input:focus, select:focus {
            outline: none;
            border-color: var(--secondary-color);
            box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.1);
        }

        .radio-group {
            display: flex;
            gap: 30px;
            margin: 15px 0;
        }

        .radio-option {
            display: flex;
            align-items: center;
            padding: 15px;
            border: 2px solid #ddd;
            border-radius: 8px;
            cursor: pointer;
            transition: all 0.2s ease;
        }

        .radio-option:hover {
            border-color: var(--secondary-color);
            background-color: rgba(52, 152, 219, 0.05);
        }

        .radio-option input[type="radio"] {
            margin-right: 10px;
            accent-color: var(--secondary-color);
            transform: scale(1.2);
        }

        #fareInput {
            background-color: #f8f9fa;
            border: 2px dashed #ddd;
            font-weight: bold;
            color: var(--secondary-color);
            cursor: not-allowed;
        }

        #driverSelect {
            background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='none' stroke='%23333' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3e%3cpolyline points='6 9 12 15 18 9'%3e%3c/polyline%3e%3c/svg%3e");
            background-repeat: no-repeat;
            background-position: right 12px center;
            background-size: 18px;
            appearance: none;
        }

        .price-tag {
            background: var(--secondary-color);
            color: white;
            padding: 4px 8px;
            border-radius: 4px;
            font-size: 0.9em;
            margin-left: 8px;
        }

        @media (max-width: 768px) {
            .form-row {
                grid-template-columns: 1fr;
            }
            
            .radio-group {
                flex-direction: column;
            }
            
            .detail-row {
                flex-direction: column;
                gap: 5px;
            }
            
            .detail-value {
                text-align: left;
            }
        }
    </style>
</head>
<body>
    <form action="orderConfirmServlet"  method="post">
    <div class="container">
        <div class="vehicle-details">
            <h2 style="color: var(--primary-color); margin-bottom: 20px;">Vehicle Details</h2>
            <div class="detail-row">
                <span class="detail-label">Model:</span>
                <input type="hidden" name="vehicleModel" value="${vehicleModel}">
                <span class="detail-value">${vehicleModel}</span>
            </div>
            <div class="detail-row">
                <span class="detail-label">Vehicle Name:</span>
                <input type="hidden" name="vehicleName" value="${vehicleName}">
                <span class="detail-value">${vehicleName}</span>
            </div>
            <div class="detail-row">
                <span class="detail-label">Vehicle Number:</span>
                <input type="hidden" name="vehicleNumber" value="${vehicleNumber}">
                <span class="detail-value">${vehicleNumber}</span>
            </div>
            <div class="detail-row">
                <span class="detail-label">Owner:</span>
                <input type="hidden" name="vehicleOwner" value="${vehicleOwner}">
                <input type="hidden" name="vehicleOwnerContact" value="${vehicleOwnerContact}">
                <span class="detail-value">${vehicleOwner} (${vehicleOwnerContact})</span>
            </div>
        </div>
            
       


        <input type="hidden" name="vehicalID" value="${vehicleId}">
        <input type="hidden" name="userName" value="${userName}">
        <input type="hidden" name="userId" value="${userId}">
        

        <div class="form-section">
            <h3 style="color: var(--primary-color); margin-bottom: 20px;">Booking Information</h3>
            <div class="form-row">
                <div class="form-group">
                    <label for="startDate">Start Date</label>
                    <input type="date" id="startDate" name="startDate" required>
                </div>
                <div class="form-group">
                    <label for="endDate">End Date</label>
                    <input type="date" id="endDate" name="endDate" required>
                </div>
            </div>


            <div class="form-group">
                <label>Car Type</label>
                <div class="radio-group">
                    <label class="radio-option">
                        <input type="radio" id="withAC" name="carType" value="withAC"
                               onclick="updateFare('${vehicleWithAC}', '${vehicleWithoutAC}')">
                        With AC 
                        <span class="price-tag">${vehicleWithAC}/day</span>
                    </label>
                    <label class="radio-option">
                        <input type="radio" id="withoutAC" name="carType" value="withoutAC"
                               onclick="updateFare('${vehicleWithAC}', '${vehicleWithoutAC}')">
                        Without AC 
                        <span class="price-tag">${vehicleWithoutAC}/day</span>
                    </label>
                </div>

                <!-- Include hidden fields to pass the vehicle rates -->
                <input type="hidden" id="vehicleWithAC" name="vehicleWithAC" value="${vehicleWithAC}">
                <input type="hidden" id="vehicleWithoutAC" name="vehicleWithoutAC" value="${vehicleWithoutAC}">

            </div>

            <div class="form-group">
                <label for="fareInput">Calculated Fare</label>
                <input type="text" id="fareInput" readonly name="fareInput"
                       placeholder="Select car type to calculate fare">
            </div>

            <div class="form-group">
                <label for="driverSelect">Select Driver</label>
                <select id="driverSelect" name="driverSelect">
                    <c:forEach var="driverId" items="${driverList}">
                        <option value="${driverId}">${driverId}</option>
                    </c:forEach>
                </select>

            </div>
        </div>
            <center>
            <div class="form-row-last" >
            <input type="submit" name="register" class="register" value="Submit">
           </div>
            <center>
    </form>
    </div>
        
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
    <script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function () {
        // Get today's date in YYYY-MM-DD format
        let today = new Date().toISOString().split('T')[0];
        // Set the min attribute of the start date input to today's date
        document.getElementById('startDate').setAttribute('min', today);
        document.getElementById('endDate').setAttribute('min', today);
    });
</script>
</body>
</html>