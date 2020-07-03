package com.HTTPservice.HTTPservice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String name;
	private RoleList role;
//	private String firstName;
//	private String lastName;

	Employee() {
	}

	public Employee(String name, RoleList role) {
		this.name = name;
		this.role = role;
		
//intento de usar el GET para buscar por name cuando son nombres completos...
//		if (this.name.contains(" ")) {
//			String[] parts = name.split(" ");
//			this.firstName = parts[0];
//			this.lastName = parts[1];
//		}

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the role
	 */
	public RoleList getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleList role) {
		this.role = role;
	}
	
	public int getSalary() {
		return role.getSalaryRole();
	}

	@Override
	public String toString() {
		return "Employee [id = " + getId() + ", name = " + getName() + ", role = " + getRole().getNameRole()
				+ ", with salary of = " + getRole().getSalaryRole() + "]";
	}

}


