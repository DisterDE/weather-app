package pro.sky.java.weatherapp.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    @Bean
    public Caffeine caffeineConfig(
            @Value("${cache.time.quantity}") int time,
            @Value("${cache.time.unit}") TimeUnit unit
    ) {
        return Caffeine.newBuilder().expireAfterWrite(time, unit);
    }

    @Bean
    public CacheManager cacheManager(Caffeine caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        caffeineCacheManager.setCacheNames(List.of("weather_forecasts"));
        return caffeineCacheManager;
    }
}
