package com.example.autorental.reusable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.autorental.R

@Composable
fun HeaderSection() {
    Surface(
        color = Color(0xFFD3D3D3),  // Grey background color
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),  // Adjusted height to accommodate larger image if needed
        shape = androidx.compose.foundation.shape.RoundedCornerShape(
            topStart = CornerSize(0.dp),
            topEnd = CornerSize(0.dp),
            bottomStart = CornerSize(0.dp),
            bottomEnd = CornerSize(0.dp)
        )
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.CenterStart // Align Row to start
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Space out items
            ) {
                // Logo image on the left
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(180.dp)  // Adjust size of logo as needed
                )

                // Profile icon on the right
                Image(
                    painter = painterResource(id = R.drawable.profile_icon),  // Replace with actual profile icon resource
                    contentDescription = "Profile Icon",
                    modifier = Modifier
                        .size(48.dp)  // Size of the profile icon
                        .clip(CircleShape)  // Make it circular
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeaderSection() {
    HeaderSection() // Preview the HeaderSection composable
}