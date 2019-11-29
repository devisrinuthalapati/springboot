package com.bankapp.model.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="myuser_table1")
public class User {
	private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(unique=true)
	private String email;
	@JsonIgnore
	private String password;
	private String address;
	private String[] roles;
	private boolean active;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = encoder.encode(password);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public static BCryptPasswordEncoder getEncoder() {
		return encoder;
	}
	public static void setEncoder(BCryptPasswordEncoder encoder) {
		User.encoder = encoder;
	}
	public User(String name, String email, String password, String address, String[] roles, boolean active) {
		
		this.name = name;
		this.email = email;
		setPassword(password);
		this.address = address;
		this.roles = roles;
		this.active = active;
	}
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	
	

}
