package com.programmersworld.ratingsdataservice.resources;

import com.programmersworld.ratingsdataservice.model.Rating;
import com.programmersworld.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable String userId) {
        UserRating userRating = new UserRating();
        List<Rating> ratings = Arrays.asList(
                new Rating("123", 4),
                new Rating("456", 5),
                new Rating("789", 6));
        userRating.setUserRating(ratings);
        return userRating;
    }

}
