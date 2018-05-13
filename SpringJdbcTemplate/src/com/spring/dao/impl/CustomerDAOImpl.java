package com.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.dao.CustomerDAO;
import com.spring.dto.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Customer> getList() {
		String sql="select * from customer";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));			
	}

}
