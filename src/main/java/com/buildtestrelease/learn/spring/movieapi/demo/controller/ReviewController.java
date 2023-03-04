package com.buildtestrelease.learn.spring.movieapi.demo.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.buildtestrelease.learn.spring.movieapi.demo.repo.Review;

import com.buildtestrelease.learn.spring.movieapi.demo.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/reviews")
@Slf4j
public class ReviewController {
	
		
	@Autowired
	private ReviewService reviewService; 
	
	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
		log.debug("Add this review: "+payload);
		return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
	}

}
