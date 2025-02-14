package ru.sandbox.swa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import ru.sandbox.swa.screen.city.CitiesScreen
import ru.sandbox.swa.screen.forecast.ForecastScreen
import ru.sandbox.swa.screen.search.SearchScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = GraphsRoutes.SearchRoute.route
    ) {
        navigation(route = GraphsRoutes.SearchRoute.route, startDestination = ScreensRoutes.SearchScreen.route) {
            composable(route = ScreensRoutes.SearchScreen.route) {
                SearchScreen(navController = navController)
            }

            composable(
                route = ScreensRoutes.ForecastScreen.route
                    .plus("/{cityName}")
                    .plus("/{lat}")
                    .plus("/{lon}"),
                arguments = listOf(
                    navArgument("cityName") { type = NavType.StringType },
                    navArgument("lat") { type = NavType.StringType },
                    navArgument("lon") { type = NavType.StringType }
                )
            ) {
                val args = it.arguments
                ForecastScreen(
                    navController = navController,
                    cityName = args?.getString("cityName").toString(),
                    lat = args?.getString("lat").toString(),
                    lon = args?.getString("lon").toString()
                )
            }
        }

        navigation(route = GraphsRoutes.CitiesRoute.route, startDestination = ScreensRoutes.CitiesScreen.route) {
            composable(route = ScreensRoutes.CitiesScreen.route) {
                CitiesScreen(navController = navController)
            }

            composable(
                route = ScreensRoutes.ForecastScreen.route
                    .plus("/{cityName}")
                    .plus("/{lat}")
                    .plus("/{lon}"),
                arguments = listOf(
                    navArgument("cityName") { type = NavType.StringType },
                    navArgument("lat") { type = NavType.StringType },
                    navArgument("lon") { type = NavType.StringType }
                )
            ) {
                val args = it.arguments
                ForecastScreen(
                    navController = navController,
                    cityName = args?.getString("cityName").toString(),
                    lat = args?.getString("lat").toString(),
                    lon = args?.getString("lon").toString()
                )
            }
        }
    }
}