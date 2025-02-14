package ru.sandbox.swa.screen.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ru.sandbox.swa.navigation.ScreensRoutes
import ru.sandbox.swa.presentation.R
import ru.sandbox.swa.screen.common.NoValuePresent

@Composable
fun SearchScreen(
    navController: NavHostController
) {
    val viewModel: SearchViewModel = hiltViewModel()
    viewModel.getLastSearchedCity()
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
    ) {
        SearchLine(viewModel = viewModel)
        SearchHistory(viewModel = viewModel)
        SearchResults(
            navController = navController,
            viewModel = viewModel
        )
    }
}

@Composable
fun SearchLine(viewModel: SearchViewModel) {
    val searchQuery by viewModel.searchQuery.collectAsState()

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchQuery,
        enabled = true,
        onValueChange = viewModel::onSearchQueryChanged,
        label = { Text(stringResource(id = R.string.search_label)) },
        placeholder = { Text(stringResource(id = R.string.search_placeholder)) },
        singleLine = true
    )
}

@Composable
fun SearchHistory(viewModel: SearchViewModel) {
    val searchHistory = viewModel.searchHistory.collectAsState()
    searchHistory.value?.let { lastSearchedCity ->
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Last searched:"
        )
        Text(
            text = "${lastSearchedCity.country} - ${lastSearchedCity.region} - ${lastSearchedCity.name}",
            color = Color.Gray,
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 5.dp,
                    bottom = 10.dp
                )
                .fillMaxWidth()
                .clickable {
                    viewModel.onSearchQueryChanged(lastSearchedCity.name)
                }
        )
    }
}

@Composable
fun SearchResults(
    navController: NavHostController,
    viewModel: SearchViewModel
) {
    val cities by viewModel.cities.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    if (isSearching) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    } else {
        if (cities.isEmpty()) {
            NoValuePresent()
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(cities.toList()) { city ->
                    Text(
                        text = "${city.country} - ${city.region} - ${city.name}",
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth()
                            .clickable {
                                viewModel.saveSearchHistory(city)
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
    }
}