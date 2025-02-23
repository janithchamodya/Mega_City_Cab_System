<%-- 
    Document   : userGuide
    Created on : Feb 23, 2025, 8:50:37 PM
    Author     : OZT00106
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Vehicle Rental User Guide</title>
    <style>
        .note-box {
            background-color: #f0f8ff;
            border-left: 6px solid #2196F3;
            padding: 15px;
            margin: 20px 0;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
    <h1>Welcome to <B>MEGA CITY CABS</B> Rental Service</h1>
    <h2>User Guide</h2>

    <h3>1. Available Vehicle Options</h3>
    <p>You can rent various types of vehicles:</p>
    <ul>
        <li>&#128661; Cars (Sedans, SUVs, Luxury vehicles)</li>
        <li>&#128652; Buses (12-50 seaters)</li>
        <li>&#128656; Vans (7-12 seaters)</li>
        <li>&#128665; Trucks (1-5 ton capacity)</li>
    </ul>

    <div class="note-box">
        <strong>Tip:</strong> All vehicles come with optional AC/Non-AC options and driver selection.
    </div>

    <h3>2. View Existing Bookings</h3>
    <p>Access your booking history through:</p>
    <ol>
        <li>'My Bookings' section in your profile</li>
        
    </ol>

    <h3>3. Rental Process</h3>
    <h4>Step-by-Step Guide:</h4>
    <ol>
        <li><strong>Select Vehicle Type</strong>
            <ul>
                <li>Choose from Car, Bus, Van, or Truck</li>
                <li>Click your preferred vehicle</li>
            </ul>
        </li>
        
        <li><strong>Confirmation Page</strong>
            <ul>
                <li>Enter journey dates:
                    <br>📅 Start Date - When you need the vehicle
                    <br>📅 End Date - When you'll return it</li>
                <li>Select AC/Non-AC option</li>
                <li>Choose driver preference:
                    <br>✅ With professional driver
                    <br>❌ Self-drive (valid license required)</li>
            </ul>
        </li>
        
        <li><strong>Review & Submit</strong>
            <ul>
                <li>Verify all details</li>
                <li>Click 'Submit Booking'</li>
            </ul>
        </li>
    </ol>

    <h3>4. Pricing & Discounts</h3>
    <table>
        <tr>
            <th>Rental Days</th>
            <th>Discount</th>
            <th>Tax</th>
            <th>Condition</th>
        </tr>
        <tr>
            <td>1 Day</td>
            <td>20%</td>
            <td>8%</td>
            <td>Special Day Discount</td>
        </tr>
        <tr>
            <td>2-5 Days</td>
            <td>7%</td>
            <td>8%</td>
            <td>Standard Short Rental</td>
        </tr>
        <tr>
            <td>6+ Days</td>
            <td>12%</td>
            <td>8%</td>
            <td>Extended Rental Bonus</td>
        </tr>
    </table>

    <h4>Price Calculation Examples:</h4>
    <div class="note-box">
        <strong>Example 1:</strong> Special Day (1 Day Rental)<br>
        Base Price: $100<br>
        (-20% Discount) + 8% Tax = $100 × 0.80 × 1.08 = $86.40
    </div>

    <div class="note-box">
        <strong>Example 2:</strong> 4 Days Rental (Standard)<br>
        Base Price: $400<br>
        (-7% Discount) + 8% Tax = $400 × 0.93 × 1.08 = $401.76
    </div>

    <div class="note-box">
        <strong>Example 3:</strong> 7 Days Rental (Extended)<br>
        Base Price: $700<br>
        (-12% Discount) + 8% Tax = $700 × 0.88 × 1.08 = $665.28
    </div>

    <h3>5. After Booking</h3>
    <ul>
        <li>📥 Download PDF receipt from confirmation page</li>
        <li>🔄 Return to homepage for new bookings</li>
    </ul>

    <h3>Need Help?</h3>
    <p>Contact our 24/7 support team:<br>
    📞 +94 76 496 8093<br>
    📧 MegaCityCabs@vehiclerent.com</p>
    
    
    <div class="button-group" style="text-align: center; margin-top: 30px;">
    <button class="btn btn-back" 
            onclick="window.location.href='customerdashboard.jsp'"
            style="padding: 12px 25px;
                   background-color: #2196F3;
                   color: white;
                   border: none;
                   border-radius: 5px;
                   cursor: pointer;
                   font-size: 16px;
                   margin: 0 10px;
                   transition: background-color 0.3s ease;">
        Back to Home
    </button>
</div>

</body>
</html>
