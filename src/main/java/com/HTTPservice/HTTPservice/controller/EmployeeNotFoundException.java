package com.HTTPservice.HTTPservice.controller;

import com.HTTPservice.HTTPservice.domain.RoleList;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;

	EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}

	EmployeeNotFoundException(RoleList role) {
		super("Could not find employee with role " + role.getNameRole());//doesn't work due to RoleList Class, needs String same as [name]...
	}
	
	EmployeeNotFoundException(String name) {
		super("Could not find employee with name " + name);
	}
}