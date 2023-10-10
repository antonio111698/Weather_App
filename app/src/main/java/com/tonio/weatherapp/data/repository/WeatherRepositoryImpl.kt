package com.tonio.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.tonio.weatherapp.data.mappers.toWeatherInfo
import com.tonio.weatherapp.data.remote.WeatherApi
import com.tonio.weatherapp.domain.repository.WeatherRepository
import com.tonio.weatherapp.domain.util.Resource
import com.tonio.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api : WeatherApi
): WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )

        }catch (e : Exception){
            e.printStackTrace()
            Resource.Error(e.message?: "An unknown error occured")
        }
    }
}