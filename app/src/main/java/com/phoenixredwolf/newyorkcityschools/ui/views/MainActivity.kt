package com.phoenixredwolf.newyorkcityschools.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.phoenixredwolf.newyorkcityschools.ui.theme.NewYorkCitySchoolsTheme
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewYorkCitySchoolsTheme {
                val viewModel = getViewModel<MainViewModel>()
                viewModel.getAllSchools()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    SchoolApp(viewModel)
                }
            }
        }
    }
}

