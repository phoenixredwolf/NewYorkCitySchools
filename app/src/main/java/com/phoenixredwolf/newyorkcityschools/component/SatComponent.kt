package com.phoenixredwolf.newyorkcityschools.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phoenixredwolf.newyorkcityschools.data.model.SatScore

@Composable
fun SatComponent(satScore: SatScore?) {
    Column(modifier = Modifier.padding(8.dp)){
        Text(text = "Average SAT Scores", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        if (satScore!=null) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                satScore.sat_math_avg_score?.let {
                    Text(text = "Math: $it", fontSize = 12.sp)
                }
                satScore.sat_writing_avg_score?.let {
                    Text(text = "Writing: $it", fontSize = 12.sp)
                }
                satScore.sat_critical_reading_avg_score?.let {
                    Text(text = "Reading: $it", fontSize = 12.sp)
                }
            }
        } else {
            Text(text = "SAT Scores Not Available", fontSize = 12.sp)
        }
    }
}