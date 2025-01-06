package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {
	
	@Autowired
	private StudentRepository studentRepository; // 여기서만 BO 생략!!!
	
	// 조회하는 다양한 방법
	@GetMapping("/select1")
	public List<StudentEntity> select1() {
		// 1) 전체 조회(Spring Data JPA가 제공)
		//return studentRepository.findAll();
		
		// 2) id 기준 내림차순 조회
		//return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개
		//return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 "장꾸꾸"인 데이터 조회
		//return studentRepository.findByName("장꾸꾸");
		
		// 5) in문으로 일치하는 값 모두 조회
		// in (유재석, 조세호)
		//return studentRepository.findByNameIn(List.of("유재석", "조세호"));
		
		// 6) 여러 컬럼과 일치하는 데이터 조회
		// 조세호 변호사
		//return studentRepository.findByNameAndDreamJob("조세호", "변호사");
		
		// 7) email 컬럼에 naver가 포함된 데이터 조회 - likeans %naver%
		//return studentRepository.findByEmailContains("naver");
		
		// 8) 이름이 장으로 시작하는 데이터 조회 - like문 장%
		//return studentRepository.findByNameStartingWith("장");
		
		// 9) id가 2 ~ 4 범위 조회 - between
		return studentRepository.findByIdBetween(2, 4); // 둘 다 포함됨
	}
	
	// JPQL 문법, native query
	@GetMapping("/select2")
	public List<StudentEntity> select2() {
		// 장래희망이 "래퍼"인 데이터 조회
		return studentRepository.findByDreamJob("래퍼");
	}
}
