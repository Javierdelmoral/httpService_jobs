package com.HTTPservice.HTTPservice.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HTTPservice.HTTPservice.domain.Employee;
import com.HTTPservice.HTTPservice.domain.RoleList;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findById(Long  id);
	Optional<List<Employee>> findByRole(RoleList role);
	Optional<List<Employee>> findByName(String name);

}
