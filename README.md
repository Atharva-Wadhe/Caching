🚀 Spring Boot Caching Demo

A simple Spring Boot project demonstrating caching in action using annotations like @Cacheable, @CachePut, and @CacheEvict.

📌 Features

✅ In-memory caching using ConcurrentHashMap (default ConcurrentMapCacheManager).

✅ @Cacheable to store method results in cache.

✅ @CachePut to update cache when data changes.

✅ @CacheEvict to remove cache entries when needed.

✅ Example REST APIs to test caching with Weather data.

🛠 Tech Stack

Java 17+

Spring Boot (with Spring Cache)

Maven/Gradle

In-memory cache (default), can be extended to Redis

📂 Project Structure

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

🚦 How Caching Works

1. @Cacheable
First method call → result stored in cache.
Next calls with same key → result returned from cache, DB/service not hit.

2. @CachePut
Always executes the method and updates the cache.

3. @CacheEvict
Removes entry from cache.
Useful when deleting or refreshing data.
