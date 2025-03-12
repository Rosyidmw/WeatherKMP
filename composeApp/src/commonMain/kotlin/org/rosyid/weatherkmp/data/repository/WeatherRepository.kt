package org.rosyid.weatherkmp.data.repository

import org.rosyid.weatherkmp.data.network.ApiService

class WeatherRepository {
    private val apiService = ApiService()

    suspend fun fetchWeather(city: String) = apiService.getWeather(city)
}