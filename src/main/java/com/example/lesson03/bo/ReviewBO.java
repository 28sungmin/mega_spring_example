package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired // DI
	private ReviewMapper reviewMapper;
	
	// input: id(int)
	// output: Review
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}
	
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	public int addReviewAsField(int storeId, String menu,
			String userName, Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// i: id, review
	// o: int
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	
	// i: id
	// o: void => Mapper로부터는 받았지만, 나는 안 줄래. 이럴수도 있다.
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
	}
}
