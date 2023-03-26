package com.phoenixredwolf.newyorkcityschools.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phoenixredwolf.newyorkcityschools.data.model.School

@Composable
fun SchoolComponent(school: School, onSchoolClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onSchoolClick() },
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 12.dp, top = 8.dp, bottom = 8.dp )
        ) {
            school.school_name?.let {
                Text(
                    text = school.school_name,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }
            school.primary_address_line_1?.let {
                Text(text = school.primary_address_line_1, fontSize = 12.sp)
            }
            Row {
                school.city?.let {
                    Text(text = "${school.city}, ", fontSize = 12.sp)
                }
                school.state_code?.let {
                    Text(text = "${school.state_code}  ", fontSize = 12.sp)
                }
                school.zip?.let {
                    Text(text = school.zip, fontSize = 12.sp)
                }
            }
            school.phone_number?.let {
                Text(text = school.phone_number, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}
