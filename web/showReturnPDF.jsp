<%-- 
    Document   : showReturnPDF
    Created on : Mar 8, 2025, 9:50:20 AM
    Author     : OZT00106
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Return Confirmation - Mega City Cabs</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 20px;
            background: #f8f9fa;
        }
        .invoice-container {
            max-width: 800px;
            margin: 20px auto;
            background: #ffffff;
            padding: 40px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        .header {
            text-align: center;
            border-bottom: 2px solid #eee;
            padding-bottom: 20px;
            margin-bottom: 30px;
        }
        .section {
            margin-bottom: 25px;
        }
        .highlight-text {
            color: #2c3e50;
            font-size: 1.1em;
            line-height: 1.6;
        }
        .invoice-table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        .invoice-table th, .invoice-table td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }
        .invoice-table th {
            background-color: #f8f9fa;
            width: 30%;
        }
        .button-group {
            text-align: center;
            margin-top: 30px;
        }
        .action-btn {
            padding: 12px 25px;
            margin: 0 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease;
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
        .action-btn:hover {
            opacity: 0.9;
            transform: translateY(-2px);
        }
        .thank-you-section {
            text-align: center;
            color: #28a745;
            margin: 30px 0;
            font-size: 1.2em;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="css/customerDashboard/customerDashboard.css">
    <script type="text/javascript" src="js/customerDashboard/customerDashboard.js"></script>
     <link rel="stylesheet" type="text/css" href="css/loginSignup/login.css">
    </head>
    <body>
        <div class="invoice-container">
            <div class="header">
                <h1>Car Return Confirmation</h1>
                <div class="thank-you-section">
                    <p>Thank you for visiting Mega City Cabs Vehicle Rentals!</p>
                    <p>We wish you had a safe ride!</p>
                </div>
            </div>

            <div class="section">
                <p class="highlight-text">
                    Your order number: <strong>#${orderNumber}</strong><br>
                    Please keep this number for future reference.
                </p>
            </div>

            <div class="section">
                <h3>Order Processing Details</h3>
                <p class="highlight-text">
                    Your booking has been received and placed into our order processing system.<br>
                    Please review the following information about your order:
                </p>
            </div>

            <div class="section">
                <h3>Invoice Details</h3>
                <table class="invoice-table">
                    <tr><th>Order Number:</th><td>#${orderNumber}</td></tr>
                    <tr><th>Vehicle ID:</th><td>${vehicleId}</td></tr>
                    <tr><th>Driver ID:</th><td>${driverId}</td></tr>
                    <!-- Add additional dynamic fields here -->
                </table>
            </div>

            <div class="section">
                <h3>Important Information</h3>
                <ul class="highlight-text">
                    <li>Please retain this confirmation for your records</li>
                    <li>Contact us within 24 hours for any discrepancies</li>
                    <li>Your feedback is important to us</li>
                </ul>
            </div>
    <div class="button-group">
        <button class="btn btn-back" onclick="window.location.href='confirmReturnServlet'">Back to Home</button>
        <button class="btn btn-report" onclick="generateReport()">Download PDF Report</button>
    </div>
            
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
