function updateFare(vehicleWithAC, vehicleWithoutAC) {
            var fareInput = document.getElementById("fareInput");
            
            // Check which car type is selected and update the fare accordingly
            if (document.getElementById("withAC").checked) {
                fareInput.value = "Rs:100/KM & " + vehicleWithAC + "/day"; // Update fare for With AC
            } else if (document.getElementById("withoutAC").checked) {
                fareInput.value = "Rs:100/KM & " + vehicleWithoutAC + "/day"; // Update fare for Without AC
            }
        }