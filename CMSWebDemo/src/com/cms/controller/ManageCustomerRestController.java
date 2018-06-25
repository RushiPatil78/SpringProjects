package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.Customer;
import com.cms.service.CustomerService;

@RestController
@RequestMapping(value = "/api")
public class ManageCustomerRestController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customerList")
	public String getCustomerList() {
		return "Hello World";
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		Customer customer = customerService.get(id);
		return customer;
	}
}
