package com.programmersworld.moviecatalogservice.models;

public class Rating {
    private String movieId;
    public Rating(){

    }
    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    private int rating;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
