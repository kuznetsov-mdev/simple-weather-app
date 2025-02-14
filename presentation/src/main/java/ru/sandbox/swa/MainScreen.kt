package ru.sandbox.swa

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.sandbox.swa.api.ConnectivityServiceApi
import ru.sandbox.swa.navigation.AppBottomBar
import ru.sandbox.swa.navigation.MainNavGraph
import ru.sandbox.swa.presentation.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    val viewModel: MainViewModel = hiltViewModel()
    viewModel.observeNetworkState()
    val networkState = viewModel.networkState.collectAsState()
    Scaffold(
        bottomBar = { AppBottomBar(navController = navController) }
    ) {
        Column {
            if (networkState.value != ConnectivityServiceApi.Status.Available) {
                NoInternetView()
            }
            MainNavGraph(navController = navController)
        }
    }
}

@Composable
fun NoInternetView() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(end = 5.dp),
            painter = painterResource(id = R.drawable.ic_no_internet),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline,
        )
        Text(
            text = stringResource(R.string.offline_mode),
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 0.dp),
            textAlign = TextAlign.Center
        )
    }
}