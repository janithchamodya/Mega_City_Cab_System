
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


    

function validateForm() {
            // Retrieve form values
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var nic = document.getElementById("nic").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;

            // Username validation (5-15 characters)
    if (username.length < 5 || username.length > 15) {
        Swal.fire({
        icon: 'error',
        title: 'Invalid Username',
        text: 'Username must be between 5 and 15 characters!',
        });
                return false; // prevent form submission
            }

            // Password validation (5-15 characters, strong password)
        var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{5,15}$/;
        if (!passwordPattern.test(password)) {
            Swal.fire({
            icon: 'error',
            title: 'Weak Password',
            text: 'Password must be 5-15 characters long and contain uppercase, lowercase, digits, and special characters!',
                });
                return false; // prevent form submission
            }
            // Email validation using regex
            var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            if (!emailPattern.test(email)) {
                Swal.fire({
                    icon: 'error',
                    title: 'Invalid Email',
                    text: 'Please enter a valid email address!',
                });
                return false; // prevent form submission
            }

            // NIC validation (exactly 10 characters)
            // NIC validation logic
            if (nic.length === 10) {
                // Check if the first 9 characters are digits and the last character is 'v' or 'V'
                if (!/^\d{9}[vV]$/.test(nic)) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Invalid NIC',
                        text: 'NIC must be 9 digits followed by "V" or "v" for the old format!',
                    });
                    return false; // prevent form submission
                }
            } else if (nic.length === 12) {
                // Check if all 12 characters are digits
                if (!/^\d{12}$/.test(nic)) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Invalid NIC',
                        text: 'NIC must be exactly 12 digits for the new format!',
                    });
                    return false; // prevent form submission
                }
            } else {
                // If NIC is neither 10 nor 12 characters
                Swal.fire({
                    icon: 'error',
                    title: 'Invalid NIC',
                    text: 'Invalid NIC',
                });
                return false; // prevent form submission
            }


            // Phone validation (exactly 10 digits)
            if (phone.length !== 10 || isNaN(phone) || phone.charAt(0) !== '0') {
            Swal.fire({
                icon: 'error',
                title: 'Invalid Phone Number',
                text: 'Phone number must be exactly 10 digits',
            });
            return false; // prevent form submission
        }

            

            // If all validations pass, allow form submission
            return true;
        }

    
        
