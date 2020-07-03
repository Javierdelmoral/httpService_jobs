package com.HTTPservice.HTTPservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.HTTPservice.HTTPservice.domain.Employee;
import com.HTTPservice.HTTPservice.domain.RoleList;
import com.HTTPservice.HTTPservice.persistence.EmployeeRepository;

@RestController

public class EmployeeController {

	private final EmployeeRepository repository;

	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	// Post/Add item to repository

	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}

	// Aggregate root, show all items in repository

	@GetMapping("/employees")
	List<Employee> all() {
		return repository.findAll();
	}
	
	// Get single item by id

	@GetMapping("/employees/id/{id}")
	Employee one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	// Get sorted items by role, Exception doesn't work... 

	@GetMapping("employees/role/{role}")
	Optional<List<Employee>> getRoles(@PathVariable(value = "role") String role) {

		Optional<List<Employee>> listRolesEmployees = repository.findByRole(RoleList.valueOf(role));//.orElseThrow(() -> new EmployeeNotFoundException(role));
		return listRolesEmployees;//.orElseThrow(() -> new EmployeeNotFoundException(role));
	}

	// Get sorted items by name

	@GetMapping("employees/name/{name}")
	List<Employee> getName(@PathVariable(value = "name") String name) {

		List<Employee> listRolesEmployees = repository.findByName(name).orElseThrow(() -> new EmployeeNotFoundException(name));
		return listRolesEmployees;
	}
	

// Get sorted items by firstname if name are completes

//	@CrossOrigin(origins = "http://localhost")
//	@GetMapping("employees/name/{firstName}")
//	List<Employee> getName(@PathVariable(value = "firstName") String firstName) {
//
//		List<Employee> listRolesEmployees = repository.findByName(firstName);
//		return listRolesEmployees;
//	}
	

	// Change item in repository

	@PutMapping("employees/id/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			//employee.getRole().setSalaryRole(newEmployee.getRole().getSalaryRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});
	}

	// Delete item from repository

	@DeleteMapping("/employees/id/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}

}






/*
 * /////////////////////////////////////////////////////////////////////////////
 * 
 * // @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET) //
 * List<Employee> getIDs(@PathVariable float id) { // // List<Employee>
 * listIdsEmployees = repository.findById(id); // return listIdsEmployees; // }
 * 
 * // @GetMapping("/employees/{id}") // List<Employee> byID(@PathVariable float
 * id) { // // List<Employee> listIdsEmployees = repository.findById(id); //
 * return listIdsEmployees; // }
 * 
 * ////////////////////////////////////////////////////////////////////////////
 * 
 * @RequestMapping(method = RequestMethod.GET) // public List<Employee>
 * getRoles(@RequestParam(value="role") String role) { // List<Employee>
 * listRolesEmployees = repository.findByRole(RoleList.valueOf(role)); // return
 * listRolesEmployees; // }
 * 
 * // @RequestMapping(value = "employees/{role}", method = RequestMethod.GET) //
 * List<Employee> getRoles(@PathVariable String role) { // // List<Employee>
 * listRolesEmployees = repository.findByRole(RoleList.valueOf(role)); // return
 * listRolesEmployees; // }
 * 
 *///////////////////////////////////////////////////////////////////////////////
