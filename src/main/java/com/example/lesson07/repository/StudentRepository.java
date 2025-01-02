package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// 제네릭: <엔티티, pk의 타입>
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	// 순수한 JPA vs. Spring Data JPA => 여기서는 Spring Data JPA 사용중
	// 아래의 코드는 insert(id가 0) or update(id가 0보다 크면) 둘 다 할 수 있다.
	//public StudentEntity save(StudentEntity se); // 이런걸 안 만들어도 된다. => JpaRepository가 대신 해주고 있어서.
	//public Optional<StudentEntity> findById(int id);
	//public void delete(StudentEntity se);
	//public List<StudentEntity> findAll();
	
	// ex02 select - JPQL를 만들어내는 메소드명 규칙
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name111); // !!!이 name111은 아무 의미 없다. 메소드명이 중요한 것이다!!!
	public List<StudentEntity> findByNameIn(List<String> names); // names도 별 의미 없는 것
	public List<StudentEntity> findByNameAndDreamJob(String name222, String dreamJob222);
	public List<StudentEntity> findByEmailContains(String keyword);
	public List<StudentEntity> findByNameStartingWith(String keyword);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
}
