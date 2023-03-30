package com.phoenixredwolf.newyorkcityschools.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
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

    object Search: BottomMenu(
        "search",
        icon = Icons.Outlined.Search,
        "Search"
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