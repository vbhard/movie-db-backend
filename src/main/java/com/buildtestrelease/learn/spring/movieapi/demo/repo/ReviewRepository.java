/**
 * 
 */
package com.buildtestrelease.learn.spring.movieapi.demo.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author vikasbhardwaj
 *
 */
public interface ReviewRepository extends MongoRepository<Review, ObjectId>{
	

}
