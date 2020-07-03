package com.HTTPservice.HTTPservice.persistence;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.HTTPservice.HTTPservice.domain.Employee;
import com.HTTPservice.HTTPservice.domain.RoleList;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Employee("Bilbo", RoleList.BURGLAR)));
      log.info("Preloading " + repository.save(new Employee("Merry", RoleList.BURGLAR)));
      log.info("Preloading " + repository.save(new Employee("Frodo", RoleList.BURGLAR)));
      log.info("Preloading " + repository.save(new Employee("Frodo", RoleList.THIEF)));
      log.info("Preloading " + repository.save(new Employee("Gandalf", RoleList.MAGE)));


    };
  }
}
