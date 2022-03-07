package com.learn.movieratingservice.controller;


import com.learn.movieratingservice.model.MovieRating;
import com.learn.movieratingservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingController {

    @RequestMapping("/{movieId}")
    public MovieRating getRating(@PathVariable("movieId") String movieId) {
        return new MovieRating(movieId, 9.2);

    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
         List<MovieRating> ratings =  Arrays.asList(
                 new MovieRating("1234gd6", 8.3)
         );
         UserRating userRating = new UserRating();
         userRating.setMovieRatingList(ratings);
         return userRating;

    }


}
