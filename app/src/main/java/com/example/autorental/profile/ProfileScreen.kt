package com.example.autorental.profile

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ProfileScreen(auth: FirebaseAuth, db: FirebaseFirestore) {
    val context = LocalContext.current
    val currentUser = auth.currentUser
    val userId = currentUser?.uid

    // State variables for user details
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }

    // Fetch user data from Firestore
    LaunchedEffect(userId) {
        if (userId != null) {
            db.collection("users").document(userId).get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        firstName = document.getString("fname") ?: ""
                        lastName = document.getString("lname") ?: ""
                        email = document.getString("email") ?: ""
                        dob = document.getString("dob") ?: ""
                    }
                    isLoading = false
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Failed to fetch user data", Toast.LENGTH_SHORT).show()
                    isLoading = false
                }
        } else {
            isLoading = false
        }
    }

    if (isLoading) {
        // Show loading state while data is being fetched
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Text(text = "Loading...")
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Profile", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)

            // Editable fields for user details
            ProfileInputField(label = "First Name", value = firstName) { firstName = it }
            ProfileInputField(label = "Last Name", value = lastName) { lastName = it }
            ProfileInputField(label = "Email", value = email, enabled = false) { } // Non-editable field
            ProfileInputField(label = "Date of Birth", value = dob) { dob = it }

            // Save changes button
            Button(onClick = {
                if (userId != null) {
                    val updatedUser = mapOf(
                        "fname" to firstName,
                        "lname" to lastName,
                        "email" to email,
                        "dob" to dob
                    )
                    db.collection("users").document(userId).update(updatedUser)
                        .addOnSuccessListener {
                            Toast.makeText(context, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(context, "Failed to update profile", Toast.LENGTH_SHORT).show()
                        }
                }
            }) {
                Text(text = "Save Changes")
            }
        }
    }
}

@Composable
fun ProfileInputField(label: String, value: String, enabled: Boolean = true, onValueChange: (String) -> Unit) {
    Column {
        Text(text = label, style = androidx.compose.material3.MaterialTheme.typography.labelMedium)
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}
