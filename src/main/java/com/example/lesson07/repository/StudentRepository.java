package com.example.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// 제네릭: <엔티티, pk의 타입>
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	// 순수한 JPA vs. Spring Data JPA
	//public StudentEntity save(StudentEntity se); // 이런걸 안 만들어도 된다. => JpaRepository가 대신 해주고 있어서.
	
}
