function showConfirmation(model, vehicleName, vehicleNumber, vehicleOwner, vehicleOwnerContact, vehicleWithAC, vehicleWithoutAC) {
    Swal.fire({
        title: `Book ${vehicleName}`,
        html: `
            <style>
                .form-row { 
                    display: flex; 
                    gap: 15px; 
                    margin-bottom: 15px;
                }
                .form-group { 
                    flex: 1; 
                    min-width: 200px;
                }
                .radio-group1 {
                    display: flex;
                    gap: 20px;
                    margin: 10px 0;
                    
                }
                .radio-group2 {
                            display: flex;
                            gap: 20px;
                            margin: 10px 0;
                            margin-left:75px;
                           
        

                        }
                .swal2-input {
                    width: 100% !important;
                    margin: 5px 0 !important;
                }
                label {
                    font-weight: bold;
                    margin-top: 10px;
                    display: block;
                }
            </style>
            <div>
                <div>
                    <table style="width: 100%;">
                        <tr>
                            <td style="text-align: left; padding: 8px;"><strong>Model:</strong></td>
                            <td style="text-align: left; padding: 8px;">${model}</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 8px;"><strong>Vehicle Name:</strong></td>
                            <td style="text-align: left; padding: 8px;">${vehicleName}</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 8px;"><strong>Vehicle Number:</strong></td>
                            <td style="text-align: left; padding: 8px;">${vehicleNumber}</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 8px;"><strong>Vehicle Owner:</strong></td>
                            <td style="text-align: left; padding: 8px;">${vehicleOwner}</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 8px;"><strong>Owner Contact:</strong></td>
                            <td style="text-align: left; padding: 8px;">${vehicleOwnerContact}</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 8px;"><strong>With AC Price:</strong></td>
                            <td style="text-align: left; padding: 8px;">Rs:100/KM & ${vehicleWithAC}/day</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 8px;"><strong>Without AC Price:</strong></td>
                            <td style="text-align: left; padding: 8px;">Rs:100/KM &${vehicleWithoutAC}/day</td>
                        </tr>
                    </table>
                </div>


                <div class="form-row">
                    <div class="form-group">
                        <label>Start Date:</label>
                        <input type="date" id="startDate" class="swal2-input" required>
                    </div>
                    <div class="form-group">
                        <label>End Date:</label>
                        <input type="date" id="endDate" class="swal2-input" required>
                    </div>
                </div>

                <label>Select Car Type:</label>
                <div class="radio-group1">
                    <div>
                        <input type="radio" id="withAC" name="carType" value="withAC" onclick="updateFare('${vehicleWithAC}')">
                        <label for="withAC">With AC Rs:100/KM & (${vehicleWithAC}/day)</label>
                    </div>
                    <div>
                        <input type="radio" id="withoutAC" name="carType" value="withoutAC" onclick="updateFare('${vehicleWithoutAC}')">
                        <label for="withoutAC">Without AC Rs:100/KM & (${vehicleWithoutAC}/day)</label>
                    </div>
                </div>

                <label>Fare:</label>
                <div id="fareDisplay" class="swal2-input" style="background: #f8f9fa; cursor: not-allowed">
                    Select car type to see the fare
                </div>

                

                <label>Select Driver:</label>
                <select id="driverSelect" class="swal2-input">
                    <option value="driver1">Driver 1</option>
                    <option value="driver2">Driver 2</option>
                    <option value="driver3">Driver 3</option>
                </select>
            </div>
        `,
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, book it!",
        focusConfirm: false,
        preConfirm: () => {
            // Add validation here if needed
        }
    }).then((result) => {
        // Handle confirmation logic
    });
}

function updateFare(fare) {
    document.getElementById('fareDisplay').innerHTML = `Rs:100/KM & ${fare}/day`;
}
