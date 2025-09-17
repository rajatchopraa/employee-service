package com.rajat1.restapi.response;

import lombok.Data;

@Data
public class AddressResponse {
private int id;
	
	private String lane1;
	
	private String lane2;
	
	private String state;

	private String zip;

}
