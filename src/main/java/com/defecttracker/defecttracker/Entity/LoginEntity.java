package com.defecttracker.defecttracker.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class LoginEntity {

	 @Id
	 private String userId;
	 private String name;
	 private String password;
	 private String isTester;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsTester() {
		return isTester;
	}
	public void setIsTester(String isTester) {
		this.isTester = isTester;
	}
	public LoginEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginEntity(String userId, String name, String password, String isTester) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.isTester = isTester;
	}
	@Override
	public String toString() {
		return "LoginEntity [userId=" + userId + ", name=" + name + ", password=" + password + ", isTester=" + isTester
				+ "]";
	}
	 
}
