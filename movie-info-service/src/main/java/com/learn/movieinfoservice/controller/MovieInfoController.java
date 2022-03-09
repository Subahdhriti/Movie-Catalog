package com.learn.movieinfoservice.controller;

import com.learn.movieinfoservice.model.ModelTMDB;
import com.learn.movieinfoservice.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieInfoController {


    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId) {
        //return new MovieInfo(movieId,"Titanic","Romantic");

        ModelTMDB modelTMDB = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/"+ movieId + "?api_key="+apiKey, ModelTMDB.class
        );
        return  new MovieInfo(movieId,modelTMDB.getMovieName(), modelTMDB.getDescription());
    }


}

