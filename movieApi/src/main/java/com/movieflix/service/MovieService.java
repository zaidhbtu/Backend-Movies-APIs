package com.movieflix.service;

import com.movieflix.dto.MovieDto;
import com.movieflix.dto.MoviePageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MovieService {

    MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException;

    MovieDto getMovie(int movieId);

    List<MovieDto> getAllMovies();

    String deleteMovie(int movieId) throws IOException;

    MovieDto updateMovie(int movieId, MovieDto movieDto, MultipartFile file) throws IOException;

    MoviePageResponse getAllMoviesWithPagination(Integer pageNumber, Integer pageSize);

    MoviePageResponse getAllMoviesWithPaginationAndSorting(Integer pageNumber, Integer pageSize,
                                                           String sortBy, String dir);

}
