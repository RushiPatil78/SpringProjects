package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomerDAO;
import com.spring.dto.Customer;
import com.spring.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getList() {
		List<Customer> customerList = customerDAO.getList();
		return customerList;
	}

}
