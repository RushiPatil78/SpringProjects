package com.spring.dao;

import java.util.List;

import com.spring.dto.Customer;

public interface CustomerDAO extends BaseDAO<Customer>{
	List<Customer> getList();
}
