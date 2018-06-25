package com.cms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cms.dao.CustomerDAO;
import com.cms.dto.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Customer> getList() {
		String sql="select * from customer";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));			
	}

	@Override
	public int save(Customer customer) {
		String sql = "insert into customer values (?,?)";
		return this.jdbcTemplate.update(sql, new Object[] {customer.getCustomerId(),customer.getName()});	
	}

	@Override
	public int update(Customer customer) {
		String sql = "update customer set name=? where customer_id = ?";
		return this.jdbcTemplate.update(sql, new Object[] {customer.getName(),customer.getCustomerId()});		
	}

	@Override
	public int delete(int id) {
		String sql = "delete from customer where customer_id = ?";
		return this.jdbcTemplate.update(sql, new Object[] {id});			
	}

	@Override
	public Customer get(long id) {
		String sql="select * from customer where customer_id = ?";
		return (Customer)this.jdbcTemplate.queryForObject(sql,new Object[] {id} ,new BeanPropertyRowMapper(Customer.class));		
	}
	
}
