package com.app.aws.config;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class AwsConfig {

    @Bean
    public Filter getFilter() {
        return new SecurityFilter();
    }

//    @Bean(name="stock")
//    public Function<Map<String,String>, Map<String,Object>> getStock() {
//        return (map) -> {
//            var symbol = map.get("symbol");
//            RestTemplate restTemplate = new RestTemplate();
//            var result = restTemplate
//                    .getForObject("https://eodhd.com/api/fundamentals/{symbol}?api_token=demo&fmt=json",Map.class, symbol);
//            return result;
//        };
//    }

    @Bean(name="reverse")
    public Function<String,String> reverse() {
        return input -> new StringBuilder(input).reverse().toString();
    }

    @Bean(name="normal")
    public Function<String,String> normal() {
        return input -> input;
    }
}
