package com.example.jdbc2datasource.model;

public class Employee {
	

	private int id;
	
	private String emp_name;
	
	private String level;

	public Employee() {
		super();
	}

	public Employee(int id, String emp_name, String level) {
		super();
		this.id = id;
		this.emp_name = emp_name;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_name=" + emp_name + ", level=" + level + "]";
	}

}
