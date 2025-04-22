package com.jkb.weatherapp.data.remote

import com.jkb.weatherapp.data.model.WeatherResponse
import retrofit2.Response

class WeatherRespository {
    suspend fun getWeather(cityName: String, apiKey: String): Response<WeatherResponse> {
        return RetrofitInstance.api.getCurrentWeather(cityName, apiKey)
    }
}