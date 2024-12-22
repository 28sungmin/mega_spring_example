package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// DB insert => 결과 방금 가입된 학생 화면
	// http://localhost/lesson04/ex02/add-student
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student, // request parameter명과 필드명이 일치하는 것으로 매핑됨
			Model model) {
		
		// DB insert => 이 과정을 통해 id를 얻을 수 있음
		studentBO.addStudent(student);
		
		// DB select => id로 => 방금 가입된 학생을 얻을 수 있음(다른 스레드랑 겹치지 않음)
		int id = student.getId();
		student = studentBO.getStudentById(id);
		
		// model에 담는다.
		model.addAttribute("student", student);
		
		// 화면으로
		return "lesson04/afterAddStudent";
		
		
	}
}
