package com.example.autorental.profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autorental.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase instances
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Get the current user's ID
        val userId = auth.currentUser?.uid

        // Fetch user profile data from Firestore
        if (userId != null) {
            loadUserProfile(userId)
        } else {
            Toast.makeText(this, "User not logged in.", Toast.LENGTH_SHORT).show()
        }

        // Handle Save button click
        binding.btnSave.setOnClickListener {
            saveUserProfile(userId)
        }
    }

    /**
     * Loads the user profile data from Firestore and populates the fields.
     * @param userId The ID of the current user.
     */
    private fun loadUserProfile(userId: String) {
        db.collection("users").document(userId).get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    binding.etFname.setText(document.getString("fname"))
                    binding.etLname.setText(document.getString("lname"))
                    binding.etEmail.setText(document.getString("email"))
                    binding.etDob.setText(document.getString("dob"))
                } else {
                    Toast.makeText(this, "User data not found.", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load profile data.", Toast.LENGTH_SHORT).show()
            }
    }

    /**
     * Saves the updated user profile data to Firestore.
     * @param userId The ID of the current user.
     */
    private fun saveUserProfile(userId: String?) {
        if (userId == null) {
            Toast.makeText(this, "User ID is null. Cannot save data.", Toast.LENGTH_SHORT).show()
            return
        }

        val updatedData = mapOf(
            "fname" to binding.etFname.text.toString().trim(),
            "lname" to binding.etLname.text.toString().trim(),
            "email" to binding.etEmail.text.toString().trim(),
            "dob" to binding.etDob.text.toString().trim()
        )

        db.collection("users").document(userId).update(updatedData)
            .addOnSuccessListener {
                Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to update profile.", Toast.LENGTH_SHORT).show()
            }
    }
}
