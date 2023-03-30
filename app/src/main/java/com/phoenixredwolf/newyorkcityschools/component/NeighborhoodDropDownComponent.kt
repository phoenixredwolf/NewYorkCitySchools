package com.phoenixredwolf.newyorkcityschools.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel
import com.phoenixredwolf.newyorkcityschools.utility.getNeighborhoods

@Composable
fun NeighborhoodDropDownComponent(
    viewModel: MainViewModel
) {
    val schools = viewModel.schoolsResponse.collectAsState().value
    val neighborhoods = getNeighborhoods(schools).sorted()
    var expanded by remember { mutableStateOf(false) }
    val selected by remember { mutableStateOf( "Select Neighborhood") }

    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)){
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Neighborhood Dropdown list")
            }
            Text(text = selected)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            neighborhoods.forEach {
                DropdownMenuItem(
                    text = { Text(text = it) },
                    onClick = {
                        viewModel.getSchoolByNeighborhood(it)
                        expanded = false
                    })
            }
        }
    }
}