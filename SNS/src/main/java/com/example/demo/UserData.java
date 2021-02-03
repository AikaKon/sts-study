package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column
	private String message;
	
	@Column 
	private String data;

	
	public long getId() { 
		return id;
	}
	public void setId(long id) { 
		this.id = id;
	}
	
	public String getName() { 
		return name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
