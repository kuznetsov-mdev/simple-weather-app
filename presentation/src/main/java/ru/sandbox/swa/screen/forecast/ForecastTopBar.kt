package ru.sandbox.swa.screen.forecast

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ru.sandbox.swa.SimpleWeatherAppTheme
import ru.sandbox.swa.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastTopBar(
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = MaterialTheme.colorScheme.scrim,
            navigationIconContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ForecastTopBarPreview() {
    SimpleWeatherAppTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            ForecastTopBar(
                onBackClick = {}
            )
        }
    }
}