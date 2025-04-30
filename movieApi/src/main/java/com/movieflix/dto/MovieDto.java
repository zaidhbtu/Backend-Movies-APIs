package com.movieflix.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
public class MovieDto {

    private int movieId;

    @NotBlank(message = "Please Provide movie's title!")
    private String title;

    @NotBlank(message = "Please Provide movie's director Name!")
    private String director;

    @NotBlank(message = "Please Provide movie's studio !")
    private String studio;

    //It is a collection of data
    private Set<String> movieCast;

    private int releaseYear;

    @NotBlank(message = "Please Provide movie's poster")
    private String poster;

    @NotBlank(message = "Please Provide movie's url")
    private String posterUrl;


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Set<String> getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(Set<String> movieCast) {
        this.movieCast = movieCast;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public MovieDto(int movieId, String title, String director, String studio, Set<String> movieCast, int releaseYear, String poster, String posterUrl) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.studio = studio;
        this.movieCast = movieCast;
        this.releaseYear = releaseYear;
        this.poster = poster;
        this.posterUrl = posterUrl;
    }
}
