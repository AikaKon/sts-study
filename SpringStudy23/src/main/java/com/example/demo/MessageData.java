package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
public class MessageData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	@NotBlank
	@Size(min=1 , max=100 )
	private String message;
	
	@Column(nullable = false) 
	private String data;
	
	@Column(nullable = false)
	@NotBlank
	@Size(min=1 , max=20 )
	private String title;

//	@ManyToOne         //多対１の関係。
//	@JoinColumn(name = "user_id")
//	private UserData userData;
	

//	public UserData getUserData() {
//		return userData;
//	}
//	public void setUserData(UserData userData) {
//		this.userData = userData;
//	}
	public long getId() { 
		return id;
	}
	public void setId(long id) { 
		this.id = id;
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
