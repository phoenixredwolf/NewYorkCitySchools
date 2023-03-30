package com.phoenixredwolf.newyorkcityschools.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.phoenixredwolf.newyorkcityschools.data.model.School

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(school: School?, onBackPressed: () -> Unit = {}) {
    TopAppBar(
        title = {
            if (school != null) {
                Text(
                    text = school.school_name!!,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                onBackPressed()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Arrow")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Save School", tint = MaterialTheme.colorScheme.tertiary)
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    )
}
