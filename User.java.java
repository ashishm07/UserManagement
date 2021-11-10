package com.nkn.usermanagement.bean;

public class User {

	private String Name;
	private String Password;

	
	public User(String Name, String Password) {
		super();

		this.Name = Name;
		this.Password = Password;
	}

//	public User(String Name) {
//		super();
//		this.Name = Name;
//	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

}