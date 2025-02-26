function confirmDeletion(event) {
        event.preventDefault(); // Prevent form submission
        Swal.fire({
            title: "Are you sure?",
            text: "You won't be able to revert this!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, delete it!"
        }).then((result) => {
            if (result.isConfirmed) {
                event.target.submit();
               
            } else {
                // Optionally handle cancel action
                Swal.fire("Cancelled", "Your admin is safe", "info");
            }
        });
        return false;  // Prevent default form submission until confirmed
    }

    function confirmReturn(orderNumber) {
        Swal.fire({
            title: 'Are you sure?',
            text: "Confirm return for order #" + orderNumber,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, confirm!'
        }).then((result) => {
            if (result.isConfirmed) {
                document.getElementById(`form-${orderNumber}`).submit();
            }
        });
    }


function showError(errorCode) {
    if (errorCode == 1) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'All fields are required!'
        });
    } else if (errorCode == 2) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Please try again.'
        });
    
    }
}  
function showSuccess(Success) {
    
    if (Success == 1) {
        Swal.fire({
            title: 'Success!',
            text: 'Processing success.',
            icon: 'success',
            confirmButtonText: 'OK'
        });
    } 
    }

function updateAdmin(button) {
        // Get the row that contains the clicked button
        const row = button.closest('tr');

        // Extract input values from the row
        const username = row.querySelector('input[name="username"]').value;
        const nic = row.querySelector('input[name="nic"]').value;
        const phone = row.querySelector('input[name="phone"]').value;
        const email = row.querySelector('input[name="email"]').value;
        const role = row.querySelector('input[name="role"]').value;

        // Create a FormData object to hold the data
        const formData = new FormData();
        formData.append('username', username);
        formData.append('nic', nic);
        formData.append('phone', phone);
        formData.append('email', email);
        formData.append('role', role);

        // Send the data using AJAX (Fetch API)
        fetch('changeAddminDataServlet', {
            method: 'POST',
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            // Show success alert or handle the response as needed
            Swal.fire({
                icon: 'success',
                title: 'Admin details updated!',
                showConfirmButton: false,
                timer: 1500
            });
        })
        .catch(error => {
            // Show error alert in case of failure
            Swal.fire({
                icon: 'error',
                title: 'Failed to update admin details!',
                text: error,
                showConfirmButton: true
            });
        });
    }


function changeAddminData() {
        // Create a new request to the servlet
        fetch('changeAddminDataServlet', {
            method: 'GET', // You can use 'POST' if needed
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded', // Set the correct content type
            }
        })
        .then(response => response.text())  // Process the response as text
        .then(data => {
            console.log('Servlet response:', data);
            
        })
        .catch(error => {
            console.error('Error in calling the servlet:', error);
            
        });
    }

