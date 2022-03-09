package com.learn.movieinfoservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelTMDB {

    @JsonProperty("original_title")
    private String movieName;
    @JsonProperty("overview")
    private String description;
    @JsonProperty("vote_average")
    private String rating;
}
