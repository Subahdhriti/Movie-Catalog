package com.learn.moviecatalogservice.controller;


import com.learn.moviecatalogservice.model.CatalogItem;
import com.learn.moviecatalogservice.model.MovieInfo;
import com.learn.moviecatalogservice.model.MovieRating;
import com.learn.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder wcBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        //Get all rated movie Ids


//        List<MovieRating> movieRatings = Arrays.asList(
//                new MovieRating("123",9.2),
//                new MovieRating("124",9.0)
//
//        );

        UserRating movieRatings =  restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/" + userId, UserRating.class);


        //For each movie Id, call movie-info-service and get details
        return  movieRatings.getMovieRatingList().stream().map(movieRating -> {
            //Calling through RestTemplate
            //MovieInfo movieInfo =  restTemplate.getForObject("http://movie-info-service/movies/" + movieRating.getMovieId(), MovieInfo.class);
            //Calling through WebClient
            MovieInfo movieInfo = wcBuilder.build()
                    .get()
                    .uri("http://movie-info-service/movies/" + movieRating.getMovieId())
                    .retrieve()
                    .bodyToMono(MovieInfo.class)
                    .block();

            return new CatalogItem(movieInfo.getMovieName(),"Test",movieRating.getRating());
        }).collect(Collectors.toList());





        //Put them all together
    }



}
