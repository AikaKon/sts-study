package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

@Entity
@Table
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
//	@Column(length = 20, nullable = false)
//	private String name;
//	
//	@Column(length = 50, nullable = false)
//	private String mail;
//	
//	@Column(nullable = false)
//	private String pass;
	
	@Column(nullable = false)
	@NotBlank
//	@Size(min=1 , max=100 )
	private String message;
	
	@Column(nullable = false) 
	private String data;
	
	@Column(nullable = false)
	@NotBlank
//	@Size(min=1 , max=20 )
	private String title;
	
	public long getId() { 
		return id;
	}
	public void setId(long id) { 
		this.id = id;
	}
//	
//	public String getName() { 
//		return name;
//	}
//	public void setName(String name) { 
//		this.name = name;
//	}
//	
//	public String getMail() {
//		return mail;
//	}
//	public void setMail(String mail) {
//		this.mail = mail;
//	}
//	
//	public String getPass() {
//		return pass;
//	}
//	public void setPass(String pass) {
//		this.pass = pass;
//	}
	
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
