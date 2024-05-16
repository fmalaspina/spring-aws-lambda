package com.app.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.function.Function;

@SpringBootApplication
public class SpringLambdaAgnosticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLambdaAgnosticApplication.class, args);
    }


    @Bean
    Function<String, String> function() {
        return (input) -> {
            return "Hello " + input;
        };
    }
}