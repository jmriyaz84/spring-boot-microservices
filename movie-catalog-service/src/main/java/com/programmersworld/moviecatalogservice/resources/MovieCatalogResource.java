package com.programmersworld.moviecatalogservice.resources;

import com.programmersworld.moviecatalogservice.models.CatalogItem;
import com.programmersworld.moviecatalogservice.models.Movie;
import com.programmersworld.moviecatalogservice.models.Rating;
import com.programmersworld.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

   /* @Autowired
    private WebClient.Builder webClientBuilder;*/

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
        return userRating.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "description", rating.getRating());
        }).collect(Collectors.toList());
    }
}


/**
 * Retrieve in content through web client
 * Movie movie = webClientBuilder.build()
 * .get()
 * .uri("http://localhost:8082/movies/" + rating.getMovieId())
 * .retrieve()
 * .bodyToMono(Movie.class)
 * .block();
 */

