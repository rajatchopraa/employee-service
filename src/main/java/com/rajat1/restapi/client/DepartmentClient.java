package com.rajat1.restapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rajat1.restapi.response.DepartmentResponse;



@FeignClient(name = "Department-service", url = "${departmentservice.base.url}")
public interface DepartmentClient {
	@GetMapping("/department/{employeeId}")
	public DepartmentResponse findDepartmentByEmployeeId(@PathVariable ("employeeId") int employeeId);

}
