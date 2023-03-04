/**
 * 
 */
package com.buildtestrelease.learn.spring.movieapi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.buildtestrelease.learn.spring.movieapi.demo.repo.Movie;
import com.buildtestrelease.learn.spring.movieapi.demo.repo.Review;
import com.buildtestrelease.learn.spring.movieapi.demo.repo.ReviewRepository;

/**
 * @author vikasbhardwaj
 *
 */

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public Review createReview(String reviewBody, String imdbId) {
		Review review = new Review(reviewBody);
		reviewRepo.insert(review);
		
		mongoTemplate.update(Movie.class)
			.matching(Criteria.where("imdbId").is(imdbId))
			.apply(new Update().push("reviewIds").value(review)).first();
		return review;
	}
	
}
