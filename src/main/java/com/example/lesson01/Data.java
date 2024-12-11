package com.example.lesson01;

// 일반 자바 빈(java bean) => spring이 관여하지 않음 => 모든 제어를 우리가 한다.
public class Data {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
