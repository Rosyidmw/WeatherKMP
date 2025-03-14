package org.rosyid.weatherkmp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.rosyid.weatherkmp.data.models.WeatherResponse

@Composable
fun HomeScreen() {
    val viewModel = remember { HomeScreenViewModel() }
    LaunchedEffect(Unit) {
        viewModel.fetchWeather("Jakarta")
    }

    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state.value) {
            is HomeScreenState.Loading -> {
                CircularProgressIndicator()
                Text(text = "Loading..")
            }

            is HomeScreenState.Success -> {
                val weather = (state.value as HomeScreenState.Success).data
                HomeScreenContent(weather)
            }

            is HomeScreenState.Error -> {
                val message = (state.value as HomeScreenState.Error).message
                Text(text = message)
            }
        }
    }
}

@Composable
fun HomeScreenContent(weather: WeatherResponse) {
    Column {
        Text(text = weather.name!!)
        Text(text = weather.weather[0].description!!)
        Text(text = weather.main?.temp.toString())
    }
}