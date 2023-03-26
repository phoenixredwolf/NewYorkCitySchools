package com.phoenixredwolf.newyorkcityschools.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.NearMe
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenu(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Home: BottomMenu(
        "home",
        icon = Icons.Outlined.Home,
        "Home"
    )

    object Boro: BottomMenu(
        "search",
        icon = Icons.Outlined.Map,
        "Boro"
    )

    object Favorites: BottomMenu(
        "favorites",
        icon = Icons.Outlined.Favorite,
        "Favorites"
    )

    object Neighborhood: BottomMenu(
        "neighborhood",
        icon = Icons.Outlined.NearMe,
        "Neighborhood"
    )
}