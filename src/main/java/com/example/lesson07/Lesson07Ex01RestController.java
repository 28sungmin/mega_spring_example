package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C: create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "이성민";
		String phoneNumber = "010-1234-1111";
		String email = "gooddays4001@naver.com";
		String dreamJob = "개발자";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U: update
	@GetMapping("/update")
	public StudentEntity update(
			@RequestParam("id") int id) {
		// id가 5번인 dreamJob 변경
		return studentBO.updateStudentDreamJobById(id, "배우");	
	}
	
	// D: delete
	@GetMapping("/delete")
	public String  delete() {
		// id가 5번인 데이터 삭제
		studentBO.deleteStudentById(5); // 얘는 return이 void
		return "삭제 완료";
	}
}