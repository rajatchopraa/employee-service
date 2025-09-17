package com.rajat1.restapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rajat1.restapi.entity.Employee;
import com.rajat1.restapi.repository.EmployeeRepo;
import com.rajat1.restapi.response.EmployeeResponse;
import com.rajat1.restapi.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	

	
	@GetMapping("employee/{id}")
	public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable ("id") int id) {
		EmployeeResponse response = empService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}

}
