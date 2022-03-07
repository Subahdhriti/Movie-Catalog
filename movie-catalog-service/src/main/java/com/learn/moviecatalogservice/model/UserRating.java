package com.learn.moviecatalogservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRating {

    private List<MovieRating> movieRatingList;

}
