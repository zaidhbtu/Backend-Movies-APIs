package com.movieflix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(nullable = false, length= 200)
    @NotBlank(message = "Please Provide movie's title!")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Please Provide movie's director Name!")
    private String director;

    @Column(nullable = false)
    @NotBlank(message = "Please Provide movie's studio !")
    private String studio;

    //It is a collection of data
    @ElementCollection
    @CollectionTable(name ="movie_cast")
    private Set<String> movieCast;

    @Column(nullable = false)
    private int releaseYear;

    @Column(nullable = false)
    @NotBlank(message = "Please Provide movie's poster")
    private String poster;

    public Movie(Object o, String title, String director, String studio, Set<String> movieCast, int releaseYear, String poster) {
    }



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

}
