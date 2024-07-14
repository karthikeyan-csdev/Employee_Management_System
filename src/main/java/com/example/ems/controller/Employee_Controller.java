package com.example.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.Repo.Employee_Repo;
import com.example.ems.Entity.*;

@RestController
public class Employee_Controller {
	
	@Autowired
	Employee_Repo emprepo;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return emprepo.findAll();
	}
	
	
	@PostMapping("/employees/addemployee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee emp) {
		
		emprepo.save(emp);
		
	}
	@PutMapping("/employees/update/{id}")
	public Employee updateEmployee(@PathVariable int id) {
		Employee emp = emprepo.findById(id).get();
		emp.setEmail("kk11@g");
		emp.setName("kk11");
		
		emprepo.save(emp);
		
		return emp;
	}
	@DeleteMapping("/employees/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		emprepo.delete(emprepo.findById(id).get());
		
	}
	
	
	
}