package com.jkb.weatherapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkb.weatherapp.data.model.WeatherResponse
import com.jkb.weatherapp.data.remote.WeatherRespository
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRespository = WeatherRespository()
) : ViewModel() {
    private val _weatherData = mutableStateOf<WeatherResponse?>(null)
    val weatherData: State<WeatherResponse?> = _weatherData

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    fun fetchWeather(city: String, apiKey: String) {
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            try {
                val response = repository.getWeather(city, apiKey)
                if (response.isSuccessful && response.body() != null) {
                    _weatherData.value = response.body()
                } else {
                    _error.value = "City not found or API error"
                }
            } catch (e: Exception) {
                _error.value = "Failed to load weather data"
            } finally {
                _isLoading.value = false
            }
        }
    }

}
