package com.programmersworld.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
/*
class MovieCatalogServiceApplication
@author Riyaz
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServiceApplication {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

   /* @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServiceApplication.class, args);
    }

}
