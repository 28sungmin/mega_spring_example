package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input: id(int)
	// output: Review
	public Review selectReviewById(int id);
}
