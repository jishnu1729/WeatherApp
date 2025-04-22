package com.jkb.weatherapp.data.remote

import com.jkb.weatherapp.data.model.WeatherResponse
import retrofit2.Call

class WeatherRespository {
    fun getWeather(cityName: String, apiKey: String): Call<WeatherResponse> {
        return RetrofitInstance.api.getCurrentWeather(cityName, apiKey)
    }
}