package com.buildtestrelease.learn.spring.movieapi.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.buildtestrelease.learn.spring.movieapi.demo.repo.Movie;
import com.buildtestrelease.learn.spring.movieapi.demo.repo.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	public List<Movie> allMovies(){
		
		return movieRepo.findAll();
	}
	
    public Optional<Movie> singleMovie(String id){
		
		return movieRepo.findMovieByImdbId(id);
	}
	
}
