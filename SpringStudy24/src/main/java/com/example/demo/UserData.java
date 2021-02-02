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
	
	@Column(length = 50, nullable = false)
	private String mail;
	
	@Column(nullable = false)
	private String password;
	
	@Column
	private String message;
	
	@Column 
	private String data;
	
	@Column
	private String title;
	
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
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
