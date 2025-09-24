package com.cache.weather.repository;

import com.cache.weather.model.Weather;
import com.cache.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Optional<Weather> findByCity(String city);
    void deleteByCity(String city);
}
