package com.rajat1.restapi.service;

import java.net.ResponseCache;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rajat1.restapi.client.AddressClient;
import com.rajat1.restapi.client.DepartmentClient;
import com.rajat1.restapi.entity.Employee;
import com.rajat1.restapi.repository.EmployeeRepo;
import com.rajat1.restapi.response.AddressResponse;
import com.rajat1.restapi.response.DepartmentResponse;
import com.rajat1.restapi.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private ModelMapper mapper;
	//@Autowired
	private RestTemplate departmentRestTemplate;
	private RestTemplate addressRestTemplate;
	private AddressClient addressClient;
	private DepartmentClient departmentClient;
	/*
	 * @Value("${departmentservice.base.url}") private String
	 * departmentServiceBaseUrl;
	 */
	/*
	 * public EmployeeService(RestTemplate departmentTemplateBuilder, RestTemplate
	 * addressTemplateBuilder) { this.departmentRestTemplate =
	 * departmentTemplateBuilder; this.addressRestTemplate = addressTemplateBuilder;
	 * }
	 */
	public EmployeeService(AddressClient addressClient, DepartmentClient departmentClient) {
		this.addressClient=addressClient;
		this.departmentClient=departmentClient;
	}
	public EmployeeResponse getEmployeeById(int id) {
		Employee employee = repo.findById(id).get();
		EmployeeResponse response = mapper.map(employee, EmployeeResponse.class);
		//department service
		//DepartmentResponse departmentResponse = departmentRestTemplate.getForObject("/{id}", DepartmentResponse.class, id);
		//address service
		//AddressResponse addressResponse = addressRestTemplate.getForObject("/{id}", AddressResponse.class, id);
		ResponseEntity<AddressResponse> addressResponse = addressClient.findAdressById(id);
	DepartmentResponse departmentResponse = departmentClient.findDepartmentByEmployeeId(id);
		/*response.setDepartmentResponse(departmentResponse);*/
		response.setAddressResponse(addressResponse.getBody());
		response.setDepartmentResponse(departmentResponse);
		return response;
	}

}
