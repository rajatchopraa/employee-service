package com.rajat1.restapi.config;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */
	@Bean
	public RestTemplate addressTemplateBuilder(@Value("${addressservice.base.url}") String baseUrl, RestTemplateBuilder builder) {
		return builder.rootUri(baseUrl).build();
	}
	@Bean
	public RestTemplate departmentTemplateBuilder(@Value("${departmentservice.base.url}") String baseUrl, RestTemplateBuilder builder) {
		return builder.rootUri(baseUrl).build();
	}
	
}
