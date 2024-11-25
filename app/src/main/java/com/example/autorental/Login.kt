package com.example.autorental

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autorental.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        // Handle login button click
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            // Input validation
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Show ProgressBar while login is in progress
            showLoading(true)

            // Firebase Authentication login
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    // Hide ProgressBar after the task completes
                    showLoading(false)

                    if (task.isSuccessful) {
                        // Redirect to Home activity if login is successful
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()  // Close the Login activity to prevent back navigation
                    } else {
                        // Display error message if login failed
                        val errorMessage = task.exception?.message ?: "Login failed"
                        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                    }
                }
        }

        // Handle the "Sign Up" link click
        binding.tvSignup.setOnClickListener {
            startActivity(Intent(this, Registration::class.java))
        }
    }

    // Function to show/hide the loading indicator (ProgressBar)
    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
            binding.btnLogin.isEnabled = false  // Disable login button during processing
        } else {
            binding.progressBar.visibility = View.GONE
            binding.btnLogin.isEnabled = true  // Re-enable button after processing
            }
        }
}