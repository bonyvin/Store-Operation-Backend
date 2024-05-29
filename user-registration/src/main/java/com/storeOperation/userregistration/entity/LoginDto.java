package com.storeOperation.userregistration.entity;

public class LoginDto {
	
	private String usernameOrEmail;
	private String password;
	private Long storeName;

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}
	public void setStoreName(Long storeName) {
		this.storeName = storeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDto(String usernameOrEmail, String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getStoreName() {
		// TODO Auto-generated method stub
		return storeName;
	}
	

}
