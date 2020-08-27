package com.example.jdbc2datasource.model;

public class Userdata {
	
	private int id;
	
	private String user;
	
	private String designation;
	
	public Userdata() {
		super();
	}

	public Userdata(int id, String user, String designation) {
		super();
		this.id = id;
		this.user = user;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Userdata [id=" + id + ", user=" + user + ", designation=" + designation + "]";
	}
	
}
