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

    @Bean(name="reverse")
    public Function<String,String> reverse() {
        return input -> new StringBuilder(input).reverse().toString();
    }


}
