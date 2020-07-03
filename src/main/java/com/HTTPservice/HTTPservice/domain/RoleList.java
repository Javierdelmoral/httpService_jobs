package com.HTTPservice.HTTPservice.domain;

public enum RoleList {
	
	BURGLAR("burglar", 1500),
	THIEF("thief", 2000),
	MAGE("mage", 3500);
	
	private String role;
	private int salaryRole;
	
	private RoleList(String role, int salaryRole) {
		this.role = role;
		this.salaryRole = salaryRole;
	}

	public int getSalaryRole() {
		return salaryRole;
	}

	public void setSalaryRole(int salaryRole) {
		this.salaryRole = salaryRole;
	}

	public String getNameRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public RoleList orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
