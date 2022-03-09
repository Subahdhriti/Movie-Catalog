package com.learn.movieinfoservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieInfo {

    private String movieId;
    private String movieName;
    private String description;

}
