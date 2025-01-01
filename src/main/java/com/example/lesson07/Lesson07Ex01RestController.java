package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C: create
	@GetMapping("/ex01/create")
	public StudentEntity create() {
		String name = "이성민";
		String phoneNumber = "010-1234-1111";
		String email = "gooddays4001@naver.com";
		String dreamJob = "개발자";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
}
