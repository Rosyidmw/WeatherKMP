package org.rosyid.weatherkmp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.rosyid.weatherkmp.data.models.WeatherResponse

class ApiService {

    private val baseURL = "https://api.openweathermap.org/data/2.5/weather?q="

    private val httpClient = HttpClient{
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                isLenient = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getWeather(city: String): WeatherResponse {
        return httpClient.get("$baseURL$city&appid=f3453b882fef15152b60c63ee3c6925c&units=metric").body()
    }


}