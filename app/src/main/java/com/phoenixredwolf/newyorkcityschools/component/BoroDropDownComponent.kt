package com.phoenixredwolf.newyorkcityschools.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.phoenixredwolf.newyorkcityschools.data.model.getAllBoros
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel
import com.phoenixredwolf.newyorkcityschools.utility.getBoroName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoroDropDownComponent(
    viewModel: MainViewModel
) {
    val borosList = getAllBoros()
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(getBoroName(borosList[0].name)) }

     ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
//         modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = selectedOptionText,
                onValueChange = { },
                label = { Text("Boro") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                borosList.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(
                            text = when (selectionOption.name) {
                                "SELECT_BORO" -> "SELECT BORO"
                                "STATEN_ISLAND" -> "STATEN ISLAND"
                                else -> selectionOption.name
                            }
                        ) },
                        onClick = {
                            selectedOptionText = selectionOption.name
                            expanded = false
                            if (selectionOption.boroName != "") viewModel.getSchoolByBoro(selectionOption.boroName)
                        }
                    )
                }
            }    }
}