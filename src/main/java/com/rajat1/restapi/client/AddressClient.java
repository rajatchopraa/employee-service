package com.rajat1.restapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rajat1.restapi.response.AddressResponse;

@FeignClient(name = "address-service")
public interface AddressClient {
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> findAdressById(@PathVariable("employeeId") int employeeId);
}
