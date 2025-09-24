package com.cache.weather.controller;

import com.cache.weather.model.Weather;
import com.cache.weather.repository.WeatherRepository;
import com.cache.weather.service.CacheInspectionService;
import com.cache.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CacheInspectionService cacheInspectionService;

    @GetMapping
    public String getWeather(@RequestParam String city){
        String weatherByCity = weatherService.getWeatherByCity(city);
        return weatherByCity;
    }

    @PostMapping
    public Weather addWeather(@RequestBody Weather weather){
        return weatherRepository.save(weather);
    }

    @GetMapping("/all")
    public List<Weather> getAllWeather(){
        return weatherRepository.findAll();
    }

    @GetMapping("/cacheData")
    public void getCacheData(){
        cacheInspectionService.printCacheContents("weather");
    }

    @PutMapping("/{city}")
    public String updateWeather(@PathVariable String city, @RequestParam String weatherUpdate){
        return weatherService.updateWeather(city, weatherUpdate);
    }

    @DeleteMapping("/{city}")
    public String deleteWeather(@PathVariable String city){
        weatherService.deleteWeather(city);
        return "Weather for the city : " + city + " is deleted from the database and cache evicted.";
    }
}
