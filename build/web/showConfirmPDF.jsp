<%-- 
    Document   : showConfirmPDF
    Created on : Feb 23, 2025, 5:44:09 PM
    Author     : OZT00106
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Booking Confirmation</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .confirmation-header {
            color: #2c3e50;
            text-align: center;
            font-size: 2.5em;
            margin-bottom: 30px;
        }
        .info-box {
            background-color: #ffffff;
            border: 2px solid #3498db;
            border-radius: 10px;
            padding: 20px;
            margin: 20px 0;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .booking-details {
            width: 100%;
            margin: 20px 0;
            border-collapse: collapse;
        }
        .booking-details th {
            background-color: #3498db;
            color: white;
            padding: 12px;
            text-align: left;
        }
        .booking-details td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        .button-group {
            text-align: center;
            margin-top: 30px;
        }
        .btn {
            padding: 10px 20px;
            margin: 0 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
        }
        .btn-back {
            background-color: #3498db;
            color: white;
        }
        .btn-report {
            background-color: #27ae60;
            color: white;
        }
    </style>
</head>
<body>
    <h1 class="confirmation-header">Booking Confirmation</h1>
    
    <div class="info-box">
        <p>Thank you for using our <b>Mega city cabs</b> rental system! We wish you a safe and pleasant journey.</p>
        <p>Your order number: <strong># ${orderNumber}</strong></p>
    </div>

    <h3>Please review your booking details:</h3>
    
    <div class="info-box">
        <p>Your booking has been received and is being processed. Please note:</p>
        <ul>
            <li>Keep your order number <strong># ${orderNumber}</strong> for future reference</li>
            <li>Our support team will contact you if any additional information is needed</li>
            
        </ul>
    </div>

    <h3>Invoice Details</h3>
    
    <table class="booking-details">
        <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>Vehicle Model</td>
            <td>${vehicleModel}</td>
        </tr>
        <tr>
            <td>Vehicle Number</td>
            <td>${vehicleNumber}</td>
        </tr>
        <tr>
            <td>Start Date</td>
            <td>${startDate}</td>
        </tr>
        <tr>
            <td>End Date</td>
            <td>${endDate}</td>
        </tr>
        <tr>
            <td>Total Fare</td>
            <td>${totalFare}</td>
        </tr>
        <tr>
            <td>Driver Name</td>
            <td>${driverName}</td>
        </tr>
        <tr>
            <td>Booking Status</td>
            <td style="color: #27ae60;">Confirmed</td>
        </tr>
    </table>

    <div class="button-group">
        <button class="btn btn-back" onclick="window.location.href='customerdashboard.jsp'">Back to Home</button>
        <button class="btn btn-report" onclick="generateReport()">Download PDF Report</button>
    </div>

    <script>
        function generateReport() {
            // Add PDF generation logic here
            alert('PDF report generation functionality would go here');
        }
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
    <script>
        // Function to generate PDF
        function generateReport() {
            // Hide the buttons before generating the PDF
            const buttons = document.querySelector('.button-group');
            buttons.style.display = 'none';

            // Capture the HTML content
            html2canvas(document.body).then(canvas => {
                const imgData = canvas.toDataURL('image/png');
                const pdf = new jspdf.jsPDF('p', 'mm', 'a4');
                const imgWidth = 210; // A4 width in mm
                const imgHeight = (canvas.height * imgWidth) / canvas.width;

                pdf.addImage(imgData, 'PNG', 0, 0, imgWidth, imgHeight);
                pdf.save(`booking_confirmation_${orderNumber}.pdf`);

                // Show the buttons again after generating the PDF
                buttons.style.display = 'block';
            });
        }
    </script>
</body>
</html>
