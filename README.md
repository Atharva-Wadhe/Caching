# 🚀 Spring Boot Caching Demo

A simple Spring Boot project demonstrating caching using `@Cacheable`, `@CachePut`, and `@CacheEvict`.

## 📌 Features
- ✅ In-memory caching using `ConcurrentHashMap` (`ConcurrentMapCacheManager`)
- ✅ `@Cacheable` to store method results in cache
- ✅ `@CachePut` to update cache when data changes
- ✅ `@CacheEvict` to remove cache entries
- ✅ REST APIs to test caching with Weather data

## 🛠 Tech Stack
- Java 17+
- Spring Boot (Spring Cache)
- Maven/Gradle
- In-memory cache (can be extended to Redis)

## 📂 Project Structure
src/main/java/com/cache/weather
│
├── controller
│   └── WeatherController.java   # REST APIs
│
├── service
│   ├── WeatherService.java      # Business logic + caching
│   └── CacheInspectionService.java # Utility to inspect cache
│
├── model
│   └── Weather.java             # Entity/POJO
│
└── repository
    └── WeatherRepository.java   # Simulated DB access


## 🚦 How Caching Works
- `@Cacheable` → First call stores result in cache; next calls return cached value
- `@CachePut` → Always executes method and updates cache
- `@CacheEvict` → Removes entry from cache (useful for deletes/refresh)
