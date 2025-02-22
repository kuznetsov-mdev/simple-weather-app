package ru.sandbox.swa.screen.forecast

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.sandbox.swa.model.WeatherItem
import ru.sandbox.swa.screen.common.NoValuePresent
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun ForecastScreen(
    navController: NavController,
    cityName: String,
    lat: String,
    lon: String
) {
    val viewModel: ForecastViewModel = hiltViewModel()
    val isDataLoading by viewModel.isDataLoading.collectAsState()
    val forecast by viewModel.forecast.collectAsState()

    viewModel.getForecast(lat = lat, lon = lon)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        ForecastTopBar(onBackClick = { navController.navigateUp() })

        if (isDataLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "City: $cityName")
                Text(text = "Location: lat($lat), lon($lon)")

                if (forecast.isEmpty()) {
                    NoValuePresent()
                } else {
                    ShowForecastResult(
                        modifier = Modifier.padding(bottom = 10.dp),
                        forecast = forecast
                    )
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun ShowForecastResult(
    modifier: Modifier,
    forecast: List<WeatherItem>
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(
            count = forecast.size
        ) {
            val forecastItem = forecast[it]
            Text(text = "Date: ${convertMsToDate(forecastItem.date)}")
            Text(text = "Temp: ${forecastItem.temperature}")
            Text(text = "Humidity: ${forecastItem.humidity}")
            Text(text = "Wind speed: ${forecastItem.windSpeed}")
        }
    }
}

fun convertMsToDate(ms: Long): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
    val instant = Instant.ofEpochSecond(ms)
    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    return date.format(formatter)
}