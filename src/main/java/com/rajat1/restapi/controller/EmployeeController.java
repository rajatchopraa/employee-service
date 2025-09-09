package com.rajat1.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rajat1.restapi.entity.Employee;

@RestController
public class EmployeeController {
	
	@GetMapping("employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return null;
		
	}

}
