package com.cache.weather.service;

import com.cache.weather.model.Weather;
import com.cache.weather.repository.WeatherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    @Cacheable(value = "weather", key = "#city")
    public String getWeatherByCity(String city){
        System.out.println("Fetching data from DB for city : "+city);
        Optional<Weather> weather = weatherRepository.findByCity(city);
        return weather.map(Weather::getForecast).orElse("Weather data not available.");
    }

    @CachePut(value = "weather", key = "#city")
    public String updateWeather(String city, String updatedWeather){
        weatherRepository.findByCity(city).ifPresent(weather -> {
            weather.setForecast(updatedWeather);
            weatherRepository.save(weather);
        });
        return updatedWeather;
    }

    @Transactional
    @CacheEvict(value = "weather", key = "#city")
    public void deleteWeather(String city) {
        System.out.println("Removing Weather for : " + city);
        weatherRepository.deleteByCity(city);
    }
}
