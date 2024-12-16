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
}
