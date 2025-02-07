package ru.sandbox.swa.navigation

sealed class ScreensRoutes(val route: String) {
    data object SearchScreen : ScreensRoutes("search_screen")
    data object CitiesScreen : ScreensRoutes("cities_screen")
    data object ForecastScreen : ScreensRoutes("forecast_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}