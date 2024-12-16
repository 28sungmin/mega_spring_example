package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input: id(int)
	// output: Review
	public Review selectReviewById(int id);
	
	// i: Review
	// o: void or int(성공한 행의 개수를 반환)-mybatis가 채워줌
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			// 하나의 맵으로 구성해서 xml로 넘긴다.
			@Param("storeId") int storeId111, 
			@Param("menu") String menu111,
			@Param("userName123123123") String userName111, 
			@Param("point") Double point111, 
			@Param("review") String review111);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
	public int deleteReviewById(int id);
}
