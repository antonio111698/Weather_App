package com.tonio.weatherapp.domain.repository

import com.tonio.weatherapp.domain.util.Resource
import com.tonio.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double):Resource<WeatherInfo>

}