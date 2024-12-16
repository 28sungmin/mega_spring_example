package com.example.lesson02.domain;

import java.time.LocalDateTime;

// DTO, domain, model, 지금은 entity(가공되지 않은)이기도 하다. 
public class UsedGoods {
	// field
	private int id;
	private int sellerId;
	private String title;
	private String description;
	private int price;
	private String picutreUrl;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPicutreUrl() {
		return picutreUrl;
	}
	public void setPicutreUrl(String picutreUrl) {
		this.picutreUrl = picutreUrl;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}	
}
