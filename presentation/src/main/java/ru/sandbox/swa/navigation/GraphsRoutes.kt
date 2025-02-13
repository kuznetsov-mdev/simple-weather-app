package ru.sandbox.swa.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector

sealed class GraphsRoutes(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object SearchRoute : GraphsRoutes(
        route = "search_graph",
        title = "Search",
        icon = Icons.Filled.Search
    )

    data object CitiesRoute : GraphsRoutes(
        route = "cities_graph",
        title = "Cities",
        icon = Icons.Outlined.LocationOn
    )
}