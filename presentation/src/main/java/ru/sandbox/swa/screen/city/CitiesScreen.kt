package ru.sandbox.swa.screen.city

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.sandbox.swa.navigation.ScreensRoutes

@Composable
fun CitiesScreen(navController: NavController) {
    val viewModel: CitiesViewModel = hiltViewModel()
    viewModel.fetchCities()
    val searchedCities by viewModel.searchedCities.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(searchedCities.toList()) { city ->
            Text(
                text = city.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(
                            ScreensRoutes.ForecastScreen.withArgs(
                                city.name,
                                city.lat.toString(),
                                city.lon.toString()
                            )
                        )
                    }
            )
        }
    }
}