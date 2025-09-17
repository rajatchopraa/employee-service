package com.rajat1.restapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rajat1.restapi.entity.Employee;
import com.rajat1.restapi.repository.EmployeeRepo;
import com.rajat1.restapi.response.DepartmentResponse;
import com.rajat1.restapi.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${departmentservice.base.url}")
	private String departmentServiceBaseUrl;
	public EmployeeResponse getEmployeeById(int id) {
		Employee employee = repo.findById(id).get();
		EmployeeResponse response = mapper.map(employee, EmployeeResponse.class);
		DepartmentResponse departmentResponse = restTemplate.getForObject(departmentServiceBaseUrl+"/{id}", DepartmentResponse.class, id);
		response.setDepartmentResponse(departmentResponse);
		return response;
	}

}
