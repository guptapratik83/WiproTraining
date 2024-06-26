document.addEventListener("DOMContentLoaded", function() {
    // Registration form validation
    const registrationForm = document.getElementById("registrationForm");
    registrationForm.addEventListener("submit", function(event) {
        const username = document.getElementById("username").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirm-password").value;

        if (username === "" || email === "" || password === "" || confirmPassword === "") {
            alert("All fields are required.");
            event.preventDefault();
        }

        if (password !== confirmPassword) {
            alert("Passwords do not match.");
            event.preventDefault();
        }
    });

    // Login form validation
    const loginForm = document.getElementById("loginForm");
    loginForm.addEventListener("submit", function(event) {
        const username = document.getElementById("login-username").value;
        const password = document.getElementById("login-password").value;

        if (username === "" || password === "") {
            alert("All fields are required.");
            event.preventDefault();
        }
    });
});
