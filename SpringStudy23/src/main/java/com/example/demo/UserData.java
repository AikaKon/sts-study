package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String mail;
	
	@Column(length = 50, nullable = false)
	private String age;
	
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private List<MessageData> messageData = new ArrayList<>();
	
//	@Column(nullable = false)
//	@NotBlank
//	@Size(min=1 , max=100 )
//	private String message;
//	
//	@Column(nullable = false) 
//	private String data;
//	
//	@Column(nullable = false)
//	@NotBlank
//	@Size(min=1 , max=20 )
//	private String title;
	
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
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public List<MessageData> getMessage(){
		return messageData;
	}
	public void setMessage(List<MessageData> messageData) {
		this.messageData = messageData;
	}
	
//	public String getMessage() {
//		return message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	
//	public String getData() {
//		return data;
//	}
//	public void setData(String data) {
//		this.data = data;
//	}
//	
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
}
