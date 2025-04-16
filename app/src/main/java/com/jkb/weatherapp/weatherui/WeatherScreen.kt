package com.jkb.weatherapp.weatherui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen() {
    var city by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Weather App") })
        }
    ) { paddingvalues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingvalues)
                .padding(16.dp)
        ) {
            SearchBar(onSearch = { cityName -> city = cityName })
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Searching weather for: $city")
        }
    }
}