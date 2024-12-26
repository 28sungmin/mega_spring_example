package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

@Mapper
public interface UserMapper {

	// i: 4개 파라미터
	// o: int or void
	public void insertUserAsField(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("email") String email, 
			@Param("introduce") String introduce);
	
	// i: X
	// o: User or null
	public User selectLatestUser();
	
	public boolean isDuplicateByName(String name);
}
