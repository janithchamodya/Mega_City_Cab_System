function updateFare(vehicleWithAC, vehicleWithoutAC) {
    var startDate = document.getElementById('startDate').value;
    var endDate = document.getElementById('endDate').value;
    var start = new Date(startDate);
    var end = new Date(endDate);
    var timeDiff = end - start;
    var days = Math.ceil(timeDiff / (1000 * 3600 * 24));

    // Validate that startDate and endDate are selected
    if (!startDate || !endDate || isNaN(days) || days < 0) {
        alert("Please select valid start and end dates.");
        return;
    }

    // Check which car type is selected
    var carType = document.querySelector('input[name="carType"]:checked');
    if (!carType) {
        alert("Please select a car type.");
        return;
    }

    // Prepare the data to send to the servlet
    var params = new URLSearchParams();
    params.append("days", days);
    if (carType.value === "withAC") {
        params.append("vehicleWithAC", vehicleWithAC);
        params.append("vehicleWithoutAC", "0.00");
    } else {
        params.append("vehicleWithAC", "0.00");
        params.append("vehicleWithoutAC", vehicleWithoutAC);
    }

    // Send an AJAX request to the servlet
    fetch("FareCalculationServlet?" + params.toString(), {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        if (data.fare) {
            document.getElementById("fareInput").value = "Rs:100/KM & Total Fare: Rs " + data.fare;
        } else if (data.error) {
            alert("Error: " + data.error);
        }
    })
    .catch(error => {
        console.error("Error fetching fare:", error);
        alert("Failed to calculate fare. Please try again.");
    });
}
