package com.project.bnb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.bnb.models.Pool;
import com.project.bnb.models.Review;
import com.project.bnb.models.User;
import com.project.bnb.repositories.PoolRepository;
import com.project.bnb.repositories.ReviewRepository;
import com.project.bnb.repositories.UserRepository;

@Service
public class ReviewService {
	// Member variables / service initializations go here
		
	private ReviewRepository _rr;
	private PoolRepository _pr;
	private UserRepository _ur;
	public ReviewService(ReviewRepository _rr, PoolRepository _pr, UserRepository _ur) {
		super();
		this._rr = _rr;
		this._pr = _pr;
		this._ur = _ur;
	}
	
	public void createReview(Long poolId, Long userId, String text, int rating) {
		Pool pool = _pr.findOne(poolId);
		User user = _ur.findOne(userId);
		Review review = new Review(text, rating);
		review.setReviewer(user);
		review.setSubject(pool);
		_rr.save(review);
		List<Review> poolReviews = pool.getReviews();
		int newRating = 0;
		for (Review poolReview : poolReviews) {
			newRating += poolReview.getRating();
		}
		System.out.println(newRating);
		System.out.println((double) newRating );
		double saveRating = ((double) newRating)/ ((double) poolReviews.size());
		System.out.println(saveRating);
		pool.setRating(saveRating);
		System.out.println("here's the value we've saved to the pool object in the method: " + pool.getRating());
		_pr.save(pool);
		System.out.println("And here we've saved the updated pool and re-retrieved it, so here's the updated rating: " + _pr.findOne(pool.getId()).getRating());
	}
	
}
