/**
 * 
 */
package com.buildtestrelease.learn.spring.movieapi.demo.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author vikasbhardwaj
 *
 */

public interface MovieRepository extends MongoRepository<Movie, ObjectId>{

Optional<Movie>	findMovieByImdbId(String imdbId);
	
}
