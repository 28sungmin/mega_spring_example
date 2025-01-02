package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// i: 파라미터 4개
	// o: StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, 
			String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// i: id, dreamJob
	// o: StudentEntity or null
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null); // Entity가 없으면 null로 저장하겠다. 라는 의미
		if (student != null) {
			// 객체가 null이 아니면 업데이트
			student = student.toBuilder()
			.dreamJob(dreamJob)
			.build(); // !!!!!꼭 다시 대입해준다!!!!!
			
			student = studentRepository.save(student); // update 후 select된 데이터로 다시 저장
		}
		
		return student;
	}
	
	// i: id
	// o: X
	public void deleteStudentById(int id) {
		// 방법1) 고전적인 방법
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student); // id로 where절 걸어서 delete 수행
//		}
		
		// 방법2) Optional 사용 방법
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s)); // null이 아닐 때 () 안의 일을 하겠다. => lambda 표현식
	}
	
	
	// i: 파라미터 4개 => Student(도메인 객체)
	// o: int or void
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
