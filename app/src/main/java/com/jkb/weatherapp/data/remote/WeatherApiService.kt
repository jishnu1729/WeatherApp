package com.jkb.weatherapp.data.remote

import com.jkb.weatherapp.data.model.WeatherResponse
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApiService {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): Response<WeatherResponse>
}