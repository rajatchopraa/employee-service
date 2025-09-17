package com.rajat1.restapi.response;

import lombok.Data;

@Data
public class EmployeeResponse {
	
	private int id;

	private String name;

	private String email;
	
	private String bloodGroup;
	private String position;
	private DepartmentResponse departmentResponse;
}
