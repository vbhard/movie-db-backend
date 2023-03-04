/**
 * 
 */
package com.buildtestrelease.learn.spring.movieapi.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.buildtestrelease.learn.spring.movieapi.demo.repo.Movie;
import com.buildtestrelease.learn.spring.movieapi.demo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vikasbhardwaj
 *
 */
@RestController
@RequestMapping("/api/v1/movies")
@Slf4j
public class MovieController {
	
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> allMovies() {
		log.debug("Getting all movies.");
		return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Movie>> allSingleMovie(@PathVariable String id) {
		log.debug("Getting all movies with imdb id:"+id);
		return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id),HttpStatus.OK);
	}

}
