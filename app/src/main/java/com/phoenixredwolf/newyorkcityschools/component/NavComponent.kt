package com.phoenixredwolf.newyorkcityschools.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.phoenixredwolf.newyorkcityschools.data.model.BottomMenu
import com.phoenixredwolf.newyorkcityschools.data.model.School
import com.phoenixredwolf.newyorkcityschools.ui.screens.DetailScreen
import com.phoenixredwolf.newyorkcityschools.ui.screens.HomeScreen
import com.phoenixredwolf.newyorkcityschools.ui.screens.SearchScreen
import com.phoenixredwolf.newyorkcityschools.ui.screens.WebviewScreen
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: MainViewModel
) {
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.isError.collectAsState()
    val schools = mutableListOf<School>()
    val allSchools = viewModel.schoolsResponse.collectAsState().value
    schools.addAll(allSchools)
    NavHost(
        navController = navController,
        startDestination = BottomMenu.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        val isLoading = mutableStateOf(loading)
        val isError = mutableStateOf(error)
        bottomNavigation(navController,schools,viewModel,isLoading,isError)
        composable("Detail/{index}",
            arguments = listOf(navArgument("index"){type = NavType.IntType})
        ) { navBackStackEntry ->
            val index = navBackStackEntry.arguments?.getInt("index")
            index?.let {
                schools.clear()
                schools.addAll(viewModel.schoolsResponse.value)
                val school = schools[index]
                school.dbn?.let { sat -> viewModel.getSatScores(sat) }
                DetailScreen(navController = navController, school = school, viewModel, isLoading, isError)
            }
        }
        composable("Web/{url}",
            arguments = listOf(navArgument("url") {type = NavType.StringType})
        ) {navBackStackEntry ->
            val url = navBackStackEntry.arguments?.getString("url")!!
            WebviewScreen(navController = navController, url = url, isLoading = isLoading, isError = isError)
        }
    }

}

fun NavGraphBuilder.bottomNavigation(
    navController: NavController,
    schools: List<School>,
    viewModel: MainViewModel,
    isLoading: MutableState<Boolean>,
    isError: MutableState<Boolean>
) {
    composable(BottomMenu.Home.route) {
        HomeScreen(
            navController = navController,
            schools,
            isLoading,
            isError
        )
    }
    composable(BottomMenu.Search.route) {
        SearchScreen(
            isLoading,
            isError,
            navController,
            viewModel
        )
    }
//    composable(BottomMenu.Boro.route) {
//        BoroScreen(
//            onFetchBoro = {
//                viewModel.onSelectedBoroChanged(it)
//                viewModel.getSchoolByBoro(it)
//            },
//            viewModel = viewModel,
//            isLoading = isLoading,
//            isError = isError,
//            navController = navController
//        )
//    }
//    composable(BottomMenu.Neighborhood.route) {
//        NeighborhoodScreen(
//            onFetchHood = { viewModel.getSchoolByNeighborhood(it) },
//            viewModel = viewModel,
//            isLoading = isLoading,
//            isError = isError,
//            navController = navController
//        )
//    }
    composable(BottomMenu.Favorites.route) {
        // TODO Add favorties screen that data is saved in and loaded from Room DB
    }
}